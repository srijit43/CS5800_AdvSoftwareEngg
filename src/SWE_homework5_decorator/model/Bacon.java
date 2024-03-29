package SWE_homework5_decorator.model;

public class Bacon extends ToppingDecorator {
    private static final double BACON_PRICE = 2.0;

    public Bacon(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + BACON_PRICE;
    }
}
