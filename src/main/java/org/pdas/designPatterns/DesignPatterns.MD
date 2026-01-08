## Design Patterns in OOPS

### Creational Design Patterns

This talks about how the objects are created

#### Singleton Design Pattern:
Ensure a class has only one instance globally (use with caution!).


#### Factory Design Pattern:
Delegate object creation to a subclass so you don't hardcode class names.

* When to use: When you don't know the exact types of objects your code will work with until runtime (e.g., loading different enemy types from a file).

* When NOT to use: If your classes are simple and rarely change. Adding a factory for two classes that will never change just adds unnecessary boilerplate.


#### Abstract Factory Design Pattern:
A factory that creates other factories (for families of related objects).

#### Builder Design Pattern:
Construct complex objects step-by-step (prevents "Constructor Hell").

* **When to use**: When an object has 10+ optional parameters (e.g., a User profile or a HttpRequest). It prevents "telescoping constructors."

* **When NOT to use**: For simple objects with only 2 or 3 required fields. It's overkill and makes the code more code.

#### Prototype Design Pattern:
Create new objects by "cloning" an existing one instead of using new




### Structural Patterns (The "Anatomy" of Systems)

#### Adapter Design Pattern:
The "Translator" that makes two incompatible interfaces work together.

* When to use: When you are using a 3rd party library that has great functionality but its method names/interfaces don't match your project.

* When NOT to use: If you have access to the source code of both sides. It's better to refactor the code to match than to create a "bridge" for no reason.

#### Bridge Design Pattern:
Separate an abstraction from its implementation so both can vary independently.

#### Composite Design Pattern:
Treat individual objects and compositions of objects uniformly (Tree structures)

#### Decorator Design Pattern:
Add new responsibilities to an object dynamically by wrapping it.
* **When to use**: When you need to add behaviors to objects at runtime without breaking other objects of the same class.

* **When NOT to use**: When the "layers" of decorators get too deep. If you find yourself wrapping an object in 15 decorators, it becomes a nightmare to debug the stack trace.


#### Facade Design Pattern:
Provide a single, simple entry point to a complex library or subsystem.

#### Flyweight Design Pattern:
Share common parts of objects to save memory (used for thousands of small objects).

#### Proxy Design Pattern:
A "Gatekeeper" that controls access to another object (security, lazy loading).
* **When to use**: For Lazy Loading (don't load a 50MB image until it's on screen) or Security (checking permissions).

* **When NOT to use**: When performance is the absolute priority. Every proxy adds a small overhead "hop" between the client and the real object.






### Behavioral Patterns (The "Conversation" between Objects)
Focus: How objects communicate and distribute responsibility.

#### Chain Of Responsibility Design Pattern:
Pass a request along a chain of handlers until one of them handles it.

#### Command Design Pattern:
Turn a request into a standalone object (enables Undo/Redo).

* **When to use**: When you need "Undo/Redo" functionality or if you want to queue actions to be performed later (like a task runner).

* **When NOT to use**: If you just want to call a method. Turning every single method call into a Command object will quadruple the number of classes in your project.

#### Iterator Design Pattern:
Access elements of a collection without exposing its underlying representation.


#### Mediator Design Pattern:
A central "Hub" that prevents objects from talking directly to each other.

#### Memento Design Pattern:
Capture and restore an object's internal state (Snapshots).

#### Observer Design Pattern:
A "Subscription" model where objects notify others of state changes.

* **When to use**: In any GUI or event-driven system where one change (data update) needs to reflect in many places (UI, Logs, Analytics).

* **When NOT to use**: In small, synchronous scripts. If not managed well (i.e., failing to "unsubscribe"), Observers can cause Memory Leaks in Java because the Subject holds a reference to the Observer forever.

#### State Design Pattern:
Allow an object to change its behavior when its internal state changes.

#### Strategy Design Pattern:
Define a family of algorithms and make them interchangeable at runtime.

* **When to use**: When you have a massive switch or if-else block that decides how to do an action (e.g., different sorting algorithms or different payment methods).

* **When NOT to use**: If you only have two possible behaviors and they never change. A simple if-else is much faster to read for future developers.

#### Template Design Pattern:
Define the skeleton of an algorithm, letting subclasses fill in the steps.

#### Visitor Design Pattern:
Add new operations to a class hierarchy without modifying the classes themselves.