## Virtual Threads

Virtual Threads introduced with Java 21 release are perhaps the biggest shift in Java concurrency model.

**Understand the relationship between the User-mode Thread, the JVM Scheduler, and the OS Kernel Thread**.
* Platform Threads - 1:1 relationship between OS Threads, 
* Virtual Threads - M:1 relationship between OS Threads
* Platform Threads - are expensive ~ 1MB size 
* Virtual Threads - are cheap ~ KB's
* Platform Threads - are managed by OS kernel
* Virtual Threads - are managed by JVM (JoinForkPool)
* Platform Threads - have limit - depending upon OS
* Virtual Threads - millions (CPU/ MEMORY BOUND)


When we run a virtualThread - JVM mounts it onto a standard Platform thread. The carrier thread actually executes the instructions on CPU.
When a virtual thread hits an blocking I/O operation like fetching from Db or reading a big file or even Thread.sleep, JVM unmounts the virtual thread.
saves its state in heap and frees up the carrier thread to go work on different virtual thread.


### Problems with virtual thread
The "**_Synchronized_**" Performance Collapse (aka **Pinning**)
Virtual Threads use `yield` to unmount, however current implementation of JVM can-not unmount a thread if it's under `synchronized` block. 
This is the problem. This would block the carrier thread. So in a way that carrier thread got pinned.
If all our Carrier Threads(usually equal to CPU core count) get pinned, our entire application grinds to a halt. 
Even though we have "millions" of Virtual Threads, they have no "Carrier" to run on.

Platform Threads don't have this problem because the OS kernel don't care about Java's `synchronized` keyword, it would just preempt the thread.

How to fix this problem ??
**ReentrantLock** is part of the java.util.concurrent package. 
Unlike the synchronized keyword (which is built into the JVM bytecode/object header), 
ReentrantLock was updated in JDK 21 to play nice with Virtual Threads.

When a Virtual Thread hits a lock.lock() call in a ReentrantLock, it can successfully unmount from the Carrier Thread.

### ForkJoinPool: built to support virtual Threads
Virtual Threads work on principle of Work stealing

Normal **ThreadPoolExecutor**(used by Platform Threads) uses a single, shared blocking queue. 
Every worker thread fights for the same lock to get a task.

The **ForkJoinPool** used for Virtual Threads (the Carrier Pool) works differently
* Every Carrier Thread has its own local Deque (Double-Ended Queue)
* The thread that owns the queue pushes and pops from the top (LIFO). This is great for cache locality (the most recent task is likely already in the CPU cache).
* If Carrier Thread A finishes all tasks in its local Deque, it doesn't just sit idle. 
* It becomes a "Thief." and tries to steal, it looks at Carrier Thread B’s Deque and steals a task from the bottom (FIFO).


#### How Virtual Thread plugs into this???
When we call `Thread.startVirtualThread(...);` -> JVM creates the `VirtualThread` object in the **heap** 
JVM pushes this Virtual Thread as a task in `ForkJoinPool`
Now a Carrier Thread(OS thread in the pool) picks up this `Virtual thread` and moves it's stack from heap to its own stack and starts executing it.
When virtual threads have blocking I/O call - it will not block the carrier thread rather it will trigger a **Continuation Yield**. 
The stack is copied back to heap and then this `Virtual Thread` is marked as waiting and Carrier thread is now free to steal any other thread from another queue

The default scheduler for Virtual Threads is **ForkJoinPool** specifically tuned for this purpose:
 * It is static and shared across the whole JVM.
 * It stays alive even if tasks are waiting on I/O


Learnings:
1. Virtual Threads are essentially **Continuations** wrapped in a **Runnable** that the **ForkJoinPool** manages.
2. Blocking is handled by the JVM, not the OS
3. Because the stack is on the Heap,it can grow and shrink dynamically.
4. A Platform Thread has a fixed-size stack (usually 1MB) allocated by the OS, which is why they are so "expensive."