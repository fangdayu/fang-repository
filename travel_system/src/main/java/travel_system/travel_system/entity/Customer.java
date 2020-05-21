package travel_system.travel_system.entity;

public class Customer {
    private Integer customers_id;
    private String customersName;

    public Customer() {
    }

    public Customer(Integer customers_id, String customersName) {
        this.customers_id = customers_id;
        this.customersName = customersName;
    }

    public Integer getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(Integer customers_id) {
        this.customers_id = customers_id;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customers_id=" + customers_id +
                ", customersName='" + customersName + '\'' +
                '}';
    }
}
