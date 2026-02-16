Task is to build a system that processes customer orders.
System must handle 2 highly volatile areas:
1. Dynamic discounting : Discount vary by customer type (VIP, GUEST, EMPLOYEE)
2. Multi-carrier Shipping: Shipping costs and tracking logic change based on the provider and destination country(DHL, FEDEx)

Functional req:
1. VIP gets a flat 15% discount, guests get 0%
2. Black Friday overrides everyone to get a 30% discount
3. DHL calculates cost by weight, FEDEx calculates the rates by distance
4. System must be flexible enough to add a new carrier without changing the core Order processor class

Class - OrderProcessor : it should process Order based on customer and Shipping provider