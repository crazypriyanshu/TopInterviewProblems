## Visitor Design Pattern: Decoupling the data structures from operations

### The Problem: "Fat" Domain Models
In complex system like Insurance CRM , we often have a stable **Element Hierarchy**  (Resident, Bank, Restaurant, Company)
The naive approach is to add sendEmail(), calculateRisk(), generateReport() directly into the classes

#### The "Architectural" smell:
1. SRP violation: Bank class who is responsible for bank specific data, now suddenly has to sendEmails, generateReports
2. OCP violation: Everytime if notification team want to update notification logic or add a new notification type, we have to re-open, modify and retest entire `PotentialClient` hierarchy
3. Liskov Substitution Principle: Adding unnecessary behaviors to the base class leads to empty or unsupported implementations

## The Solution: Visitor Pattern and double dispatch
**Visitor pattern** separates the `Data Structure` from `Algorithm` . 
it moves the behavior to a separate hierarchy of objects called **Visitors**

**Double Dispatch** : Java only supports Single dispatch - meaning 
`it chooses which method to call at runtime based on the runtime type of receiver object`
Java doesn't know how to choose a method based on the runtime type of argument
Hence, we use accept() method that simulates the double dispatch:
1. The context call - client.accept(Visitor) - First Dispatch : finds the `Resident` or the `Bank` class
2. The resident calls this with visitor.visit(this); - Second dispatch : since `this` is known to be a `Resident` at compile time - it triggers the specific visit(Resident r) method

### When to use this pattern:
1. Use Visitor when class hierarchy is stable(you need not add new types of clients often), but operations are constantly changing
2. Avoid using when we are constantly adding new subclasses eg. adding (School, Factory, Hospital) - we need to update every existing Visitor interface and implementation







Imagine a use case where we are in a insurance company and insurance company has variety of clients
and we want to manage the diff potential class, if you see the code, 

the naive way : it works fine, 
because all diff clients have diff functionality and all of them extends the `PotentialClient` class and create right objects at runtime
but let's imagine we have new requirement, sendEmail() which we have to send to each client , but mail for different subclass will have diff stry
1. resident - medical insurance ad will be sent
2. bank - theft insurance ad mail will be sent
3. restaurant - fire insurance mail will be sent

Simple : add a sendMail() method in `PotentialClient` class and all the subclasses will implement them : But by doing this, we violated 
Single responsibility and Open/Close principle 

To cater this kind of use case : we use Visitor Design pattern


## Visitor Design pattern
This is a behavioral design pattern
It separates the behaviour on the objects on which they operate

So to do this, we create a `Visitor` interface and implement that using `InsuranceMessagingVisitor` class where we have defined messaging logic for each type of client(Bank, Resident, Company ..)
Also we use a DoubleDispatch - delegates the choosing of the proper method to the object itself, instead of client selecting the object
we will add a method `accept(Visitor visitor)` to abstract class `PotentialClient` and all its method will have to implement

![img.png](img.png)

![img_1.png](img_1.png)