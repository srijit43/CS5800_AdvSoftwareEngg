package SWE_homework5_decorator.model;

// Concrete component
public class BaseFood implements FoodItem {
    private double basePrice;

    public BaseFood(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}
