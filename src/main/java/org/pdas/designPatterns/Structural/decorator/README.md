Imagine we are building a coffee shop, and we are now selling a plain coffee
Then, we want to add options in our menu:
* Coffee with Milk
* Coffee with Sugar
* Coffee with WhipCream
* Coffee with Milk AND Sugar

If we use inheritance then we would have end up in creating class for almost all the options and implement all the methods
This is what we call **class explosion**

Decorator design pattern suggest that instead of inheriting behaviour we can wrap it. 