package SWE_homework_2driver;

import SWE_homework2model.Customer;
import SWE_homework2model.MacronutrientMealFactory;

import java.util.List;

// Driver program
public class Question2driver {
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("John", "No Restriction"),
                new Customer("Alice", "Paleo"),
                new Customer("Bob", "Vegan"),
                new Customer("Emma", "Nut Allergy"),
                new Customer("Mike", "No Restriction"),
                new Customer("Sarah", "Paleo")
        );

        MacronutrientMealFactory mealFactory = MacronutrientMealFactory.getInstance();

        for (Customer customer : customers) {
            List<String> meal = mealFactory.createMeal(customer.getDietPlan());
            System.out.println("Customer: " + customer.getName());
            System.out.println("Diet Plan: " + customer.getDietPlan());
            System.out.println("Meal: " + meal);
            System.out.println();
        }
    }
}