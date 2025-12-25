## FlyWeight design pattern
A flyweight refers to an object that minimises the memory usage by sharing some of the initial object data within similar object.
Should be used only when program has huge number of similar objects which barely fits in available RAM
This splits the initial state into 2 : intrinsic(immutable) and extrinsic(mutable) state 