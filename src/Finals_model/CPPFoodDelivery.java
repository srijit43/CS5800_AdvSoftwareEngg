package Finals_model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CPPFoodDelivery implements Subscriber  {
    private List<Order> orders;
    private List<Driver> drivers;

    public void placeOrder(Customer customer, Restaurant restaurant, List<Food> foods, LocalDateTime orderTime) {
        if (orders == null) {
            this.orders = new ArrayList<>();
        }
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderPlacedAt(orderTime);
        order.setRestaurant(restaurant);
        orders.add(order);
        restaurant.takeOrders(this);
    }

    public void registerDriver(Driver driver) {
        if (drivers == null) {
            drivers = new ArrayList<>();
        }
        drivers.add(driver);
    }

    @Override
    public void observeOrderFromRestaurant(Order order) {
        // at this time the food is being cooked by the restaurant
        // check for drivers in the county of the user
        Optional<Driver> selectedDriver = drivers.stream()
                .filter(driver -> driver.getCounty().contains(order.getCustomer().getCounty()))
                .filter(driver ->
                        (
                                driver.getStartShift()
                                        .isAfter(order.getOrderPlacedAt().toLocalTime())
                                        ||
                                        driver.getStartShift()
                                                .isBefore(order.getOrderPlacedAt().toLocalTime())
                        )
                                &&
                                driver.getEndShift()
                                        .isAfter(order.getOrderPlacedAt().toLocalTime())
                )
                .findFirst();

        if (selectedDriver.isEmpty()) {
            // no drivers found
            System.out.println("There are no drivers found to deliver food for " + order.getCustomer().getName() + " from restaurant " + order.getRestaurant().getName());
            return;
        }

        // driver found so deliver the order
        selectedDriver.get().deliverOrder(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}