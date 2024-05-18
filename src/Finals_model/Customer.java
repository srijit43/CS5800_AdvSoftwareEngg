package Finals_model;

import java.util.List;


/**
 * Builder Pattern
 */
public class Customer {
    private String name;
    private String address;
    private String county;
    private List<String> dietryRestrictions;

    private Customer(CustomerBuilder customerBuilder) {
        this.name = customerBuilder.name;
        this.address = customerBuilder.address;
        this.county = customerBuilder.county;
        this.name = customerBuilder.name;
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

    public List<String> getDietryRestrictions() {
        return dietryRestrictions;
    }

    public void setDietryRestrictions(List<String> dietryRestrictions) {
        this.dietryRestrictions = dietryRestrictions;
    }

    public static class CustomerBuilder {

        private String name;
        private String address;
        private String county;
        private List<String> dietryRestrictions;

        public CustomerBuilder() {

        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder county(String county) {
            this.county = county;
            return this;
        }

        public CustomerBuilder dietryRestrictions(List<String> dietryRestrictions) {
            this.dietryRestrictions = dietryRestrictions;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
