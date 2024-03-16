package SWE_homework2model;

public class PizzaHut implements PizzaChain {

    public PizzaHut(){

    }

    @Override
    public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
        return new Pizza.PizzaBuilder(size, PizzaChainType.PIZZA_HUT);
    }
}
