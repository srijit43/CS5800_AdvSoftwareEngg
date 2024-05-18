package Finals_driver;

import Finals_model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver_file {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        CPPFoodDelivery deliveryApp = new CPPFoodDelivery();

        customers.add(new Customer.CustomerBuilder()
                .name("John Doe")
                .address("123 Elm Street")
                .county("LA County")
                .dietryRestrictions(Arrays.asList("Vegetarian"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Jane Smith")
                .address("456 Oak Avenue")
                .county("Orange County")
                .dietryRestrictions(Arrays.asList("Vegan", "Gluten-Free"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Alice Johnson")
                .address("789 Pine Road")
                .county("San Bernardino County")
                .dietryRestrictions(Arrays.asList("Nut Allergy"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Bob Brown")
                .address("101 Maple Street")
                .county("LA County")
                .dietryRestrictions(Arrays.asList("Lactose Intolerant"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Charlie Davis")
                .address("202 Birch Lane")
                .county("Orange County")
                .dietryRestrictions(Arrays.asList("Pescatarian"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Daisy Evans")
                .address("303 Cedar Boulevard")
                .county("San Bernardino County")
                .dietryRestrictions(Arrays.asList("Soy Allergy"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Evan Ford")
                .address("404 Walnut Drive")
                .county("LA County")
                .dietryRestrictions(Arrays.asList("Vegetarian", "Peanut Allergy"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Fiona Green")
                .address("505 Chestnut Avenue")
                .county("Orange County")
                .dietryRestrictions(Arrays.asList("Shellfish Allergy"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("George Harris")
                .address("606 Ash Road")
                .county("San Bernardino County")
                .dietryRestrictions(Arrays.asList("Keto Diet"))
                .build());

        customers.add(new Customer.CustomerBuilder()
                .name("Hannah Lewis")
                .address("707 Spruce Street")
                .county("LA County")
                .dietryRestrictions(Arrays.asList("Halal"))
                .build());

        List<Driver> drivers = new ArrayList<>();

        drivers.add(createDriver("Michael Johnson", "LA County", "111 Elm Street", LocalTime.of(7, 0), LocalTime.of(20, 0)));
        drivers.add(createDriver("Sarah Williams", "Orange County", "222 Oak Avenue", LocalTime.of(16, 0), LocalTime.of(0, 0)));
        drivers.add(createDriver("David Smith", "San Bernardino County", "333 Pine Road", LocalTime.of(0, 0), LocalTime.of(8, 0)));
        drivers.add(createDriver("Emma Brown", "LA County", "444 Maple Street", LocalTime.of(8, 0), LocalTime.of(20, 0)));
        drivers.add(createDriver("James Jones", "Orange County", "555 Birch Lane", LocalTime.of(16, 0), LocalTime.of(0, 0)));
        drivers.add(createDriver("Olivia Davis", "San Bernardino County", "666 Cedar Boulevard", LocalTime.of(0, 0), LocalTime.of(8, 0)));
        drivers.add(createDriver("William Garcia", "LA County", "777 Walnut Drive", LocalTime.of(8, 0), LocalTime.of(20, 0)));
        drivers.add(createDriver("Sophia Martinez", "Orange County", "888 Chestnut Avenue", LocalTime.of(16, 0), LocalTime.of(0, 0)));


        List<Restaurant> restaurants = new ArrayList<>();

        // Create food items
        List<Food> italianMenu = new ArrayList<>();
        italianMenu.add(FoodFactory.getInstance().createFood("Spaghetti Bolognese", "Italian", "None"));
        italianMenu.add(FoodFactory.getInstance().createFood("Margherita Pizza", "Italian", "Vegetarian"));

        List<Food> mexicanMenu = new ArrayList<>();
        mexicanMenu.add(FoodFactory.getInstance().createFood("Tacos", "Mexican", "None"));
        mexicanMenu.add(FoodFactory.getInstance().createFood("Vegetarian Burrito", "Mexican", "Vegetarian"));

        List<Food> chineseMenu = new ArrayList<>();
        chineseMenu.add(FoodFactory.getInstance().createFood("Kung Pao Chicken", "Chinese", "None"));
        chineseMenu.add(FoodFactory.getInstance().createFood("Vegetable Spring Rolls", "Chinese", "Vegan"));

        List<Food> indianMenu = new ArrayList<>();
        indianMenu.add(FoodFactory.getInstance().createFood("Butter Chicken", "Indian", "None"));
        indianMenu.add(FoodFactory.getInstance().createFood("Chana Masala", "Indian", "Vegan"));

        // Create restaurants
        restaurants.add(new Restaurant("Luigi's Italian Bistro", "123 Elm Street", "LA County", LocalTime.of(10, 0), LocalTime.of(22, 0), italianMenu));
        restaurants.add(new Restaurant("El Taco Loco", "456 Oak Avenue", "Orange County", LocalTime.of(11, 0), LocalTime.of(23, 0), mexicanMenu));
        restaurants.add(new Restaurant("Dragon Palace", "789 Pine Road", "San Bernardino County", LocalTime.of(10, 0), LocalTime.of(21, 0), chineseMenu));
        restaurants.add(new Restaurant("Spice of India", "101 Maple Street", "LA County", LocalTime.of(12, 0), LocalTime.of(22, 0), indianMenu));

        // registers drivers
        drivers.forEach(driver -> deliveryApp.registerDriver(driver));

        // order a food
        deliveryApp.placeOrder(customers.get(0), restaurants.get(0), italianMenu, getTime());
    }

    private static Driver createDriver(String name, String county, String address, LocalTime startShift, LocalTime endShift) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setCounty(county);
        driver.setAddress(address);
        driver.setStartShift(startShift);
        driver.setEndShift(endShift);
        return driver;
    }

    public static LocalDateTime getTime() {
        // Example LocalDateTime to check
        LocalDateTime dateTimeToCheck = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 30));
        return dateTimeToCheck;
    }
}