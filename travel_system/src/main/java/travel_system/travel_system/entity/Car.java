package travel_system.travel_system.entity;

public class Car {
    private Integer cars_id;
    private String type;
    private String location;
    private Integer price;
    private Integer numCars;
    private Integer numAvail;

    public Car() {
    }

    public Car(Integer cars_id, String type, String location, Integer price, Integer numCars, Integer numAvail) {
        this.cars_id = cars_id;
        this.type = type;
        this.location = location;
        this.price = price;
        this.numCars = numCars;
        this.numAvail = numAvail;
    }

    public Integer getCars_id() {
        return cars_id;
    }

    public void setCars_id(Integer cars_id) {
        this.cars_id = cars_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumCars() {
        return numCars;
    }

    public void setNumCars(Integer numCars) {
        this.numCars = numCars;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cars_id=" + cars_id +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numCars=" + numCars +
                ", numAvail=" + numAvail +
                '}';
    }
}
