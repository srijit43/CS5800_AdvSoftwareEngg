package SWE_homework5_decorator.model;

public class Cheese extends ToppingDecorator {
    private static final double CHEESE_PRICE = 1.5;

    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + CHEESE_PRICE;
    }
}
