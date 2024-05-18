package Finals_model;

import java.time.LocalTime;
import java.util.List;

// Observer Pattern
public class Restaurant implements Publisher {
    private String name;
    private String address;
    private String county;

    // Operating hours
    private LocalTime openTime;
    private LocalTime closeTime;

    private List<Food> menus;

    public Restaurant(String name, String address, String county, LocalTime openTime, LocalTime closeTime, List<Food> menus) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public List<Food> getMenus() {
        return menus;
    }

    public void setMenus(List<Food> menus) {
        this.menus = menus;
    }

    @Override
    public void takeOrders(CPPFoodDelivery cppFoodDelivery) {
        // iterate all the orders and choose the one for this restaurant
        cppFoodDelivery.getOrders()
                .stream()
                .filter(order -> order.getRestaurant().getName().contains(this.name))
                .findFirst()
                .ifPresent(order -> {
                    // restaurant matched
                    // make sure its operating hours
                    if (order.getOrderPlacedAt().toLocalTime().isAfter(this.openTime)
                            && order.getOrderPlacedAt().toLocalTime().isBefore(this.closeTime)) {
                        // cook the food
                        try  {
                            // delay in cooking
                            System.out.println("Restaurant >>" + this.name + " is cooking food for " + order.getCustomer().getName());
                            Thread.sleep(2000);
                            System.out.println("Restaurant >>" + this.name + " cooked food for " + order.getCustomer().getName());

                            // publish event to the cppFoodDelivery
                            cppFoodDelivery.observeOrderFromRestaurant(order);

                        } catch (Exception e) {

                        }

                    } else {
                        System.out.println("we cant take the order since the restaurant is closed ");
                    }
                });
    }
}

