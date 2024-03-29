package SWE_Decorator_driver;

import SWE_homework5_decorator.model.Bacon;
import SWE_homework5_decorator.model.BaseFood;
import SWE_homework5_decorator.model.Cheese;
import SWE_homework5_decorator.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        // Create food items
        FoodItem burger = new BaseFood(5.0);
        FoodItem fries = new BaseFood(2.0);

        // Add toppings
        FoodItem cheeseBurger = new Cheese(burger);
        FoodItem baconCheeseBurger = new Bacon(cheeseBurger);
        FoodItem baconFries = new Bacon(fries);

        // Create an order
        List<FoodItem> orderItems = new ArrayList<>();
        orderItems.add(baconCheeseBurger);
        orderItems.add(baconFries);

        // Calculate total order cost
        double totalCost = calculateTotalCost(orderItems);
        System.out.println("Total cost before discount: $" + totalCost);

        // Apply loyalty discount
        double discountedTotalCost = applyDiscount(totalCost, "Gold");
        System.out.println("Total cost after discount: $" + discountedTotalCost);
    }

    public static double calculateTotalCost(List<FoodItem> items) {
        double totalCost = 0;
        for (FoodItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public static double applyDiscount(double totalCost, String loyaltyStatus) {
        double discountPercentage;
        switch (loyaltyStatus) {
            case "Gold":
                discountPercentage = 0.1;
                break;
            case "Silver":
                discountPercentage = 0.05;
                break;
            case "Bronze":
                discountPercentage = 0.02;
                break;
            default:
                discountPercentage = 0.0;
        }
        return totalCost * (1 - discountPercentage);
    }
}
