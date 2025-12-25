Lets suppose we have an object and we want to make a complete copy of that object. How do we do that ?
1. First create a new object of that class and then go through all the fields and copy it one by one, but what if the fields are private and not visible to outside object
2. Also we have to know object's class to create duplicate hence our code is dependent on that class


## Solution: Prototype Design Pattern
The prototype design pattern delegates the actual object for cloning the object itself.
This pattern declares the a common interface for all objects that support cloning

