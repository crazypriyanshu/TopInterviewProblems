## Requirements 
1. Elevator and floors : System includes 3 elevator cars and total of 15 floors
2. Elevators shall be capable of moving up, down or remain idle
3. Elevator door operation : should open only when idle and in no motion
4. Inside each elevator buttons can be pressed to show which floor, the direction of movement and capacity
5. Floor panel display with buttons for calling lift and display indicating status of each elevator
6. Elevator system control manages the elevator movement , door operation and monitor elevator system
7. Upon calling an elevator the system shall intelligently assign most suitable elevator based on current location and trajectory


DIRECTIONS

FLOOR_NUMBER

ELEVATOR_NUMBER

DOOR_ACTION

Interfaces : BUTTON

<<Interface>> Button
    + isPressed
    + press() boolean

Extends : 
    ElevatorButton:
        + floorNumber : FLOOR_NUMBER
    DoorButton:
        + doorAction : DOOR_ACTION
    Hall Button:
        + direction : DIRECTIONS

<<Interface>> Panel
    Extends : 
        InsidePanel
            + floorButton : List<FLOOR_NUMBER>
            + doorButton : List<DOOR_ACTION>
        OutsidePanel
            + direction : List<DIRECTIONS>
            + moveUp() : void
            + moveDown() : void

Class Display:
    + floorNumber : FLOOR_NUMBER
    + direction : DIRECTIONS
    + weight : int

Class Door:
    + status : DOOR_ACTION
    + openDoor() : void
    + closeDoor() : void
Class Floor:
    + floorNumber
    + panel : OutsidePanel

Class Elevator:
    + elevatorNumber : ELEVATOR_NUMBER
    + door : Door
    + panel :Display
    + currentFloor : FLOOR_NUMBER
    + direction : DIRECTIONS

Class ElevatorSystem:
    + elevators : List<Elevator>
    + floors: List<Floor>
    + requestElevator(Direction: DIRECTIONS, Floor: FLOOR_NUMBER): Elevator
    + openDoor(Elevator elevator): void
    + closeDoor(Elevator elevator) : void
    + floorRequest(Elevator elevator, FLOOR_NUMBER: floor): void