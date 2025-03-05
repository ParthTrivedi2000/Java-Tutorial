package org.allTopics.Structural.Decorator.PizzaExample;

public class MushRoom extends ToppingDecorator{

    BasePizza pizza;

    public MushRoom(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 30;
    }
}
