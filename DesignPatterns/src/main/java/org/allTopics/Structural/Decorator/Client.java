package org.allTopics.Structural.Decorator;

/*
So from name itself we can understood like there must be something as a base thing. And simply we are
decorating that thing based on the requirement.

- So please note here that, base thing is object of a class. And decorator is Wrapper which can wraps up the
base object to fulfill additional requirements. That decorated thing is also an object but that object is
of Decorator class. And also want to tell you that we can have any decorating features. Let's take an example.

Use Cases:-
1) Pizza:-
- We can have a base pizza (i.e. base class of base pizza)
- Then we can have pizza with Extracheese. So this extracheese can be decorated on base pizza.
- Same we can have mushroom on base pizza.
- We can have Jalapeno on base pizza.
- We can have another layer of cheese. ie. double cheese on base pizza.
So all above requirements can be fulfilled as a decorator on base pizza.

2) Car:-
- We can have a Base car, which is having normal seat and engine and stearing.
- Now we can have Car with SeatCover.
- Base Car + SeatCover + Foglight
- Base Car + Fog light
- Base Car + Power Stearing
- Base Car + AntiLocking Brake System
And all the combination of above features.

3) Coffee:-
- We can have base Coffee in a mug.
- Base Coffee + Extra Milk
- Base Coffee + Cream
- Base Coffee + Decafe
- Base Coffee + Espresso
etc etc


- Now one of the issue yu=ou can see from above example is, if you can extend base class and create class for
each feature, than There is issue of Class Explosion since we can have so many classes based on the combination
of the features available. So there is a need of Decorator.

- So wherever you can see something like you are having Base thing, and then you might have different Toppings
or extra requirements on top of it, there you need Decorator design pattern.

Mostly common asked interview Questions on these design pattern:-
1) Design Pizza Shop
2) Design Coffee Machine

Now let's see how exactly decorator helps here.

- Now we will be having BasePizza abstract class. And it's concrete classes are Marghereta, veg delight etc etc.
These are not toppings but concrete class for which base pizza available. i.e. IS-A relationship between concrete
class and abstract class.

- Then we can have Toppings abstract class. Now here please recall as we have discussed these topping wraps
base thing and it itself is a object ryt. so just want to say that toppings must have that base object.
i.e. toppings HAS-A relationship with BasePizza. And now once toppings added then it is Pizza only.
So basically it is also object of pizza i.e. it also has IS-A relationship with pizza.

 */


import org.allTopics.Structural.Decorator.PizzaExample.BasePizza;
import org.allTopics.Structural.Decorator.PizzaExample.ExtraCheese;
import org.allTopics.Structural.Decorator.PizzaExample.Margherita;
import org.allTopics.Structural.Decorator.PizzaExample.MushRoom;

public class Client {
    public static void main(String[] args) {
        BasePizza pizza1 = new Margherita(); // Normal basePizza margherita without any toppings
        BasePizza pizza2 = new ExtraCheese(new Margherita()); // Margherita + ExtraCheese
        BasePizza pizza3 = new MushRoom(new ExtraCheese(new Margherita())); // Margherita + ExtraCheese + Mushroom

        System.out.println(pizza1.cost());
        System.out.println(pizza2.cost());
        System.out.println(pizza3.cost());
    }


}
