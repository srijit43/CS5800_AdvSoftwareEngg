package Finals_model;

import java.time.LocalTime;

public class Driver {
    private String name;
    private String county;
    private String address;
    private LocalTime startShift;
    private LocalTime endShift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getStartShift() {
        return startShift;
    }

    public void setStartShift(LocalTime startShift) {
        this.startShift = startShift;
    }

    public LocalTime getEndShift() {
        return endShift;
    }

    public void setEndShift(LocalTime endShift) {
        this.endShift = endShift;
    }


    public void deliverOrder(Order order) {
        System.out.println("Order was delivered to the customer " + order.getCustomer().getName() + " from restaurant " + order.getRestaurant().getName() + " by driver "+ this.name);
    }
}
