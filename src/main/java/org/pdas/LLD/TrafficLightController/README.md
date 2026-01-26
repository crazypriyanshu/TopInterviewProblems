How to Design ?

### Req Gathering:
1. Design a traffic light controller, which would manage much traffic light signal booths
2. Admin should be able to set the green state and yellow state time counter
3. A traffic signal would have 3 light states : RED, GREEN, YELLOW
4. Traffic signal will be installed on an intersection point, where there would be 4 ways to go > East to West and West to East and North to south (limiting the req, to focus on design)
5. There should be a monitoring system where we should be able to monitor which intersection, which traffic way is open or close

*** Out of Scope ***
two-way roads
### Identifying Entities
Nouns: 
Traffic-Light 
Traffic-Light-Controller
Intersection-Point

Intersection-Point holds the Traffic-Light and From Traffic controller 

### Design Patterns
Since the traffic light has 3 states: GREEN, YELLOW , RED
Traffic Light-
* It holds a reference to a SignalState object
* It contains the direction and intersectionId, representing the - "**state data**"
* It also acts as a **Subject** for Observers

SignalState-
* Defines the contract handle(TrafficLight context)
* it passes the TrafficLight instance back into the method
* This allows the concrete states to call context.setNextState(), effectively driving the transition

ConcreteState-
RED_STATE - 
GREEN_STATE - GreenState "knows" that the next logical step is YellowState.

TrafficObserver-
* The TrafficLight has a One-to-Many relationship with TrafficObserver
* When the color changes, the TrafficLight would iterate through the observers list and call update()

IntersectionController-
* Context - IntersectionController
* State Interface - IntersectionState 


### Design:
