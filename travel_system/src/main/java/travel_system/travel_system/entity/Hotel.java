package travel_system.travel_system.entity;

public class Hotel {
    private Integer hotels_id;
    private String name;
    private String location;
    private Integer price;
    private Integer numRooms;
    private Integer numAvail;

    public Hotel() {
    }

    public Hotel(Integer hotels_id, String name, String location, Integer price, Integer numRooms, Integer numAvail) {
        this.hotels_id = hotels_id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.numRooms = numRooms;
        this.numAvail = numAvail;
    }

    public Integer getHotels_id() {
        return hotels_id;
    }

    public void setHotels_id(Integer hotels_id) {
        this.hotels_id = hotels_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotels_id=" + hotels_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numRooms=" + numRooms +
                ", numAvail=" + numAvail +
                '}';
    }
}
