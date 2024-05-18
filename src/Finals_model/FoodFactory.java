package Finals_model;

/**
 * Factory Pattern and Singleton Pattern
 */
public class FoodFactory {

    private static FoodFactory foodFactory;

    private FoodFactory() {

    }

    public static FoodFactory getInstance() {
        if (foodFactory == null) {
            foodFactory = new FoodFactory();
        }
        return foodFactory;
    }

    public Food createFood(String name, String cuisineType, String dietryType) {
        Food food = new Food();

        food.setName(name);
        food.setCuisineType(cuisineType);
        food.setDietryType(dietryType);

        return food;
    }
}
