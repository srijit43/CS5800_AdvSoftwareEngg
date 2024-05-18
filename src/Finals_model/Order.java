package Finals_model;



import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private List<Food> foods;
    private LocalDateTime orderPlacedAt;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public LocalDateTime getOrderPlacedAt() {
        return orderPlacedAt;
    }

    public void setOrderPlacedAt(LocalDateTime orderPlacedAt) {
        this.orderPlacedAt = orderPlacedAt;
    }

}
