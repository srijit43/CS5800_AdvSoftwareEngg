package SWE_homework_2driver;

import SWE_homework2model.*;

public class Question1Driver {
    public static void main(String[] args) {

        pizzaHutDriverWithAllSizes(new PizzaHut());

        pizzaHutDriverWithSmallAndLargeSizes(new PizzaHut());
        littleCaesarsWithSmallAndMediumSizes(new LittleCaesars());
        dominosWithSmallAndLarge(new Dominos());
    }

    private static void dominosWithSmallAndLarge(PizzaChain dominos) {
        Pizza smallPizza = dominos.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.CHICKEN)
                .build();

        Pizza largePizza = dominos.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.HAM)
                .build();

        smallPizza.eat();
        largePizza.eat();
    }

    private static void littleCaesarsWithSmallAndMediumSizes(PizzaChain littleCaesars) {
        Pizza mediumPizza = littleCaesars.pizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.PEPPERS)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.MUSHROOMS)
                .build();

        Pizza largePizza = littleCaesars.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.PEPPERS)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.MUSHROOMS)
                .addTopping(PizzaTopping.BEEF)
                .addTopping(PizzaTopping.HAM_AND_PINEAPPLE)
                .addTopping(PizzaTopping.HAM)
                .build();

        mediumPizza.eat();
        largePizza.eat();
    }


    private static void pizzaHutDriverWithSmallAndLargeSizes(PizzaChain pizzaHut) {
        Pizza smallPizza = pizzaHut.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .build();

        Pizza largePizza = pizzaHut.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.BEEF)
                .build();

        smallPizza.eat();
        largePizza.eat();
    }

    public static void pizzaHutDriverWithAllSizes(PizzaChain pizzaHut){

        Pizza smallPizza = pizzaHut.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .build();

        Pizza mediumPizza = pizzaHut.pizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.PEPPERS)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.MUSHROOMS)
                .build();

        Pizza largePizza = pizzaHut.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.PEPPERS)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.MUSHROOMS)
                .addTopping(PizzaTopping.BEEF)
                .addTopping(PizzaTopping.HAM_AND_PINEAPPLE)
                .addTopping(PizzaTopping.HAM)
                .build();

        smallPizza.eat();
        mediumPizza.eat();
        largePizza.eat();
    }
}
