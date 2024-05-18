package Finals_model;

public class Food {
    private String name;
    private String cuisineType;
    private String dietryType; // Fats, Carbs, Vegis, Protein

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getDietryType() {
        return dietryType;
    }

    public void setDietryType(String dietryType) {
        this.dietryType = dietryType;
    }
}
