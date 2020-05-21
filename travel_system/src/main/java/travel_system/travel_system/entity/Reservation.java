package travel_system.travel_system.entity;

public class Reservation {
    private Integer reservations_id;
    private String resvKey;
    private Integer resvType;
    private Integer custId;

    public Reservation() {
    }

    public Reservation(Integer reservations_id, String resvKey, Integer resvType, Integer custId) {
        this.reservations_id = reservations_id;
        this.resvKey = resvKey;
        this.resvType = resvType;
        this.custId = custId;
    }

    public Integer getReservations_id() {
        return reservations_id;
    }

    public void setReservations_id(Integer reservations_id) {
        this.reservations_id = reservations_id;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    public Integer getResvType() {
        return resvType;
    }

    public void setResvType(Integer resvType) {
        this.resvType = resvType;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservations_id=" + reservations_id +
                ", resvKey='" + resvKey + '\'' +
                ", resvType=" + resvType +
                ", custId=" + custId +
                '}';
    }
}
