package org.allTopics.Structural.Facade;

/*
you can just google the meaning of word facade, facade means boundary or outside of the building. means exterior of
something. as if exterior looks good even though inside of building is very bad, but still exterior will make
attract the people to come there.

- For example you went to restaurant, you ordered 3 things. Pizza, Dessert, Lemonade.
Now waiter goes to 1st station in the kitchen and bring pizza once it ready. then took cutter and do 6 slice of it.
then put some olives and other things on it to decorate and to make it more testy as well as looks good. Similarly
waiter goes to station 2 and get dessert and put up cherry, kismiss and so many things on it to make it good looking.
Then waiter goes to 3rd station and he took Lemonade and put ice onto it etc etc. And then finally waiter brings it to the
customer. Now for customer it is nothing more than just doing order to the waiter. But eventually waiter did whole
lot of complex task and come back.
- So here waiter will be like Facade which eventually perform that complex tasks but at front part behaving as very simply
presentable form.

So simply Facade is nothing but front face of any complex backend. Or means it's simple connection with the complex
backend system.

- One more real life practical scenario is, Order Payment System.
So once someone hit the /orders API endpoint to create order, so order system has to do so many things. to generate
the order, the to talk with payment system for payment then once payment is done, it needs to notify the seller of
the product, notify the customer about order, notify payment service/bank for payment things etc etc...

So instead of calling these each methods manually everytime for everyone, we can have all the methods placed inside
helper() method present inside the separate helper class. and simply call the helper() method to place any order. So
this is how we can implement the facade. And this is one of the most obvious pattern. means even though if we won't
aware about design pattern with this name, anyhow we would be doing the same right? means create separate method
and place all the required methods inside it so that only one method will be called by caller whenever it is
required.

- So suppose if 1 class is having 4-5 complex methods, similarly another class is also having same 4-5 complex methods
then we can have helper class which should contains all these complex methods and that can be used by any number of
classes whenever required. This helper is known as Facade design pattern.

So simply Facade is a simple layer to a complex subsystem. You can say that it's a proxy.

 */

public class FacadeIntro {
}
