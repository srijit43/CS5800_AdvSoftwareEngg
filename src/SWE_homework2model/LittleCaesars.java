package SWE_homework2model;

public class LittleCaesars implements PizzaChain {

    public LittleCaesars(){

    }

    @Override
    public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
        return new Pizza.PizzaBuilder(size, PizzaChainType.LITTLE_CAESARS);
    }
}