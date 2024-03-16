package SWE_homework2model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Singleton Abstract Factory
public class MacronutrientMealFactory {
    private static MacronutrientMealFactory instance;
    private final MacronutrientFactory carbFactory;
    private final MacronutrientFactory proteinFactory;
    private final MacronutrientFactory fatFactory;

    private MacronutrientMealFactory() {
        carbFactory = new CarbFactory();
        proteinFactory = new ProteinFactory();
        fatFactory = new FatFactory();
    }

    public static MacronutrientMealFactory getInstance() {
        if (instance == null) {
            instance = new MacronutrientMealFactory();
        }
        return instance;
    }

    public List<String> createMeal(String dietPlan) {
        List<String> meal = new ArrayList<>();
        meal.add(carbFactory.createCarb());
        meal.add(proteinFactory.createProtein());
        meal.add(fatFactory.createFat());

        if (dietPlan.equalsIgnoreCase("Paleo")) {
            if (!meal.get(0).equalsIgnoreCase("pistachio")) {
                meal.set(0, "pistachio");
            }
            if (meal.get(1).equalsIgnoreCase("tofu")) {
                String[] proteinOptions = {"fish", "chicken", "beef"};
                meal.set(1, proteinOptions[new Random().nextInt(proteinOptions.length)]);
            }
            if (meal.get(2).equalsIgnoreCase("cheese") || meal.get(2).equalsIgnoreCase("sour cream")) {
                String[] fatOptions = {"avocado", "tuna"};
                meal.set(2, fatOptions[new Random().nextInt(fatOptions.length)]);
            }
        } else if (dietPlan.equalsIgnoreCase("Vegan")) {
            meal.set(1, "tofu");
            if (meal.get(2).equalsIgnoreCase("cheese") || meal.get(2).equalsIgnoreCase("sour cream")) {
                String[] fatOptions = {"avocado", "tuna"};
                meal.set(2, fatOptions[new Random().nextInt(fatOptions.length)]);
            }
        } else if (dietPlan.equalsIgnoreCase("Nut Allergy")) {
            if (meal.get(0).equalsIgnoreCase("pistachio")) {
                String[] carbOptions = {"cheese", "bread", "lentils"};
                meal.set(0, carbOptions[new Random().nextInt(carbOptions.length)]);
            }
            if (meal.get(2).equalsIgnoreCase("peanuts")) {
                String[] fatOptions = {"avocado", "sour cream", "tuna"};
                meal.set(2, fatOptions[new Random().nextInt(fatOptions.length)]);
            }
        }

        return meal;
    }
}

