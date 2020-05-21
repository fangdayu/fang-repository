package team.ustc.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import team.ustc.sensor.dao.SensorDao;
import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.Sensor;

import java.util.List;

@Service
public class SensorServiceImpl {
    @Autowired
    private SensorDao sensorDao;

    public List<Sensor> querySensorAll() {
        return sensorDao.querySensorAll();
    }

    public Sensor querySensorById(int id) {
        return sensorDao.querySensorById(id);
    }

    public List<Sensor> combinedQuery(String brand, String product_id, String type, String type_detail, String input,
                                      String output, String using_environment, String sRange, String sLevel,
                                      String application, String description, String strength, String more_detail) {
        return sensorDao.combinedQuery(brand, product_id, type, type_detail, input,
                output, using_environment, sRange, sLevel, application, description, strength, more_detail);
    }

    public void addSensor(String brand, String product_id, String type, String type_detail, String input,
                          String output, String using_environment, String sRange, String sLevel,
                          String application, String description, String strength, String more_detail) {
        sensorDao.addSensor(brand, product_id, type, type_detail, input,
                output, using_environment, sRange, sLevel, application, description, strength, more_detail);
    }

    public void updateSensor(String id, String columnName, String newColumn) {
        sensorDao.updateSensor(id, columnName, newColumn);
    }

    public void deleteSensor(String id) {
        sensorDao.deleteSensor(id);
    }

}
