package SWE_homework2model;

public enum PizzaChainType {

    PIZZA_HUT("Pizza Hut"),
    DOMINOS("Dominos"),
    LITTLE_CAESARS("Little Caesars");
    public final String name;

    PizzaChainType(String name) {
        this.name = name;
    }
}
