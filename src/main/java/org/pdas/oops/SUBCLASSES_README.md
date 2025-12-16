## Subclass
Take an example of a Vehicle and a car
We can imply that car is a real vehicle or we can say the real implementation of a class of vehicle , 
We can also call a car as vehicle
In OOPS also we are doing the same thing when we define like below : 
    ``Vehicle car = new Car(); // shows that we are creating a Vehicle which is a car``
A subclass is defined as a child class or derived class - which simply means:
    - subclass inherits the properties of base class
    - subclass can have their own special implementations
    - subclass can override the base class methods - for compiler check we use @Override - this also is a polymorphism
    - syntax : public class Car extends Vehicle
    - a subclass shows the `IS-A` relationship which means that child class is a base-classType
    
Memory allocation : 
    - memory is allocated for **both** the super class and subclass fields within the **single subclass object on the heap**
    - obviously superclass constructor is called first because of implicit or explicit use of _super()_;
    - subclass constructors runs and initializes its own object
Rule : 
    - A method marked as final can't be over-riden in the subclass
    - A class marked as final can't have a child class or none can extend this class