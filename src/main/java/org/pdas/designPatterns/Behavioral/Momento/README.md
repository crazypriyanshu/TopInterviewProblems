## Memento Design pattern: The time machine of design patterns
This pattern basically deals with use cases where we want to capture state of object without exposing the object's internal structure


### Memento Design Pattern: Snapshot and Encapsulation
This is a behavioral design pattern that allows an object's state to be captured and restored at later time without violating encapsulation.
It provides a mechanism to implement **Undo/Redo** functionality **without** making object's internal fields `public`

1. Encapsulation is preserved: The "Caretaker" object, (which manages the history), never actually sees the data inside "Memento". It treats as a black box.
2. SRP: The "Originator" the main object, doesn't need to manage its own history . it only needs to know how to create and consume snapshots
3. Provides a way to revert an object to a known good state if the operation fails in midway

### Formal Anatomy:
1. Originator : The object whose state we want to change. It creates Memento and uses it to restore state
2. Memento: A "Value Object" that acts as a snapshot. It is typically immutable
3. Caretaker: The history manager (Stack type DS). It just keeps track of Memento and never modifies or inspect its contents


## Common Use cases:
1. TextEditors: Managing undo buffers
2. Games: Save game or rewind mechanisms
3. Database transactions: Rolling back previous internal state to a previous checkpoint
4. Form wizards: Allowing users to go back to previous steps and restore filled data



### Narrow vs Wide Interface
**_Wide Interface_**: The Document (Originator) can see everything inside Memento, because it created it. It can read the fields to restore its state
The Narrow Interface: The HistoryManager(Caretaker) has no idea about the Memento, it can't call getContent, or getX_coordinate as they are private

