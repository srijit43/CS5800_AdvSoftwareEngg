package SWE_homework2model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Pizza {

    private final List<PizzaTopping> pizzaToppings;
    private final PizzaSize pizzaSize;

    private final PizzaChainType pizzaChain;

    private Pizza(PizzaBuilder pizzaBuilder){
        this.pizzaToppings = pizzaBuilder.pizzaToppings;
        this.pizzaSize = pizzaBuilder.pizzaSize;
        this.pizzaChain = pizzaBuilder.pizzaChain;
    }

    public void eat(){
        System.out.println("--------------------------------------");
        System.out.println("Pizza Chain : " + this.pizzaChain.name);
        System.out.println("Pizza Size  : " + this.pizzaSize.size);
        IntStream.rangeClosed(1, pizzaToppings.size()).forEach(index -> System.out.println("Pizza Topping " + index + " : " + this.pizzaToppings.get(index - 1)));
        System.out.println("--------------------------------------");
    }
    public static class PizzaBuilder {
        private List<PizzaTopping> pizzaToppings;
        private PizzaSize pizzaSize;
        private PizzaChainType pizzaChain;

        public PizzaBuilder(PizzaSize pizzaSize, PizzaChainType pizzaChain){
            this.pizzaSize = pizzaSize;
            this.pizzaToppings = new ArrayList<>();
            this.pizzaChain = pizzaChain;
        }

        public PizzaBuilder addTopping(PizzaTopping pizzaTopping)  {
            if (pizzaTopping != null){
                this.pizzaToppings.add(pizzaTopping);
            }
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }

}
