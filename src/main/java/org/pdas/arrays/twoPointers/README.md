This single topic alone covers 20–30% of interview problems.

Why?? Interviewers use it to test:
1. Logical thinking
2. Invariants
3. Optimization mindset (O(n) vs O(n²))
4. Edge-case handling



**Two pointers = controlled movement of indices based on invariant**

Problems : 
* Is the array sorted? - sorted array can give us directions
* Am I searching for pairs / triplets / ranges? - ranges are very important to reduce compute
* Can I shrink search space instead of brute force? - very important, shrinking space gives us lesser area to find and hence reduce search radius and speed of search
* Is there a monotonic property? - If we have any property that it has to match

If above problem, we can handle that problem via 2 pointer approach

### Terminology 


#### Invariants
What would stay true when pointers move?
Eg. `while(left < right){
        if(arr[left] + arr[right] == target)
        // do somthing
        }`
So this `(left < right)` becomes Invariants

#### Pointer movement logic

Exactly 1 pointer moves per step

#### Termination condition
Has to be like `(left < right)` conditions can't go infinite

#### Sorted vs Unsorted arrays
* **Sorted** → classic Two Pointer
* **Unsorted** → pre-process (sort / hashmap)

## Example problems:

#### Level 1: Two Sum (Sorted Array)
Given sorted array, find if a pair of sums to target - check TwoPairBruteForce.java file
Learning : 
1. sorted array gives us monotonic movement
2. only pointer moves per iteration 

#### Level 2: Counting / Multiple Answers
Count pairs with sum < target - now we need to count the pairs which falls less than target
check = CountPairSumTarget.java

#### Level 3: Removing duplicates
Problem remove duplicates from sorted arrays:
Core idea : one pointer reads and one pointer writes


#### Level 4: Dutch flag




