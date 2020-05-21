package travel_system.travel_system.entity;

public class Flight {
    private Integer flights_id;
    private String flightNum;
    private Integer price;
    private Integer numSeats;
    private Integer numAvail;
    private String fromCity;
    private String arivCity;

    public Flight() {
    }

    public Flight(Integer flights_id, String flightNum, Integer price, Integer numSeats, Integer numAvail, String fromCity, String arivCity) {
        this.flights_id = flights_id;
        this.flightNum = flightNum;
        this.price = price;
        this.numSeats = numSeats;
        this.numAvail = numAvail;
        this.fromCity = fromCity;
        this.arivCity = arivCity;
    }

    public Integer getFlights_id() {
        return flights_id;
    }

    public void setFlights_id(Integer flights_id) {
        this.flights_id = flights_id;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getArivCity() {
        return arivCity;
    }

    public void setArivCity(String arivCity) {
        this.arivCity = arivCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flights_id=" + flights_id +
                ", flightNum='" + flightNum + '\'' +
                ", price=" + price +
                ", numSeats=" + numSeats +
                ", numAvail=" + numAvail +
                ", fromCity='" + fromCity + '\'' +
                ", arivCity='" + arivCity + '\'' +
                '}';
    }
}
