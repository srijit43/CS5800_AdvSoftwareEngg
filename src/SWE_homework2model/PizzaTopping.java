package SWE_homework2model;

public enum PizzaTopping {

    PEPPERONI("Pepperoni"),
    SAUSAGE("Sausage"),
    MUSHROOMS("Mushrooms"),
    BACON("Bacon"),
    ONIONS("Onions"),
    EXTRA_CHEESE("Extra Cheese"),
    PEPPERS("Peppers"),
    CHICKEN("Chicken"),
    OLIVES("Olives"),
    SPINACH("Spinach"),
    TOMATO_AND_BASIL("Tomato and Basil"),
    BEEF("Beef"),
    HAM("Ham"),
    PESTO("Pesto"),
    SPICY_PORK("Spicy Pork"),
    HAM_AND_PINEAPPLE("Ham and Pineapple");
    public final String name;
    PizzaTopping(String name) {
        this.name = name;
    }
}
