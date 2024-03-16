package SWE_homework2model;

public class Dominos implements PizzaChain {

    public Dominos() {

    }

    @Override
    public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
        return new Pizza.PizzaBuilder(size, PizzaChainType.DOMINOS);
    }
}
