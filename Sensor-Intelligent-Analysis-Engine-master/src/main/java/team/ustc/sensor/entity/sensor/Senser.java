package team.ustc.sensor.entity.sensor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 方达宇
 * 基本传感器类
 */
@Entity
public class Senser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorID;  //传感器ID，唯一标识传感器的主键
    private String sensorCompany;  //传感器公司
    private int sensorType;  //传感器类型

    //无参构造函数
    public Senser() {
    }

    //有参构造函数
    public Senser(Long sensorID, String sensorCompany, int sensorType) {
        this.sensorID = sensorID;
        this.sensorCompany = sensorCompany;
        this.sensorType = sensorType;
    }

    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorCompany() {
        return sensorCompany;
    }

    public void setSensorCompany(String sensorCompany) {
        this.sensorCompany = sensorCompany;
    }

    public int getSensorType() {
        return sensorType;
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }
}
