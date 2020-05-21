package team.ustc.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.ustc.sensor.dao.SensorDetailDao;
import team.ustc.sensor.dao.SensorViewDao;
import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.Sensor;
import team.ustc.sensor.entity.SensorDetail;
import team.ustc.sensor.entity.SensorView;
import team.ustc.sensor.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 传感器数据操作事务
 *
 * @auther MrJoker
 */
@Service
public class SensorService {
    @Autowired
    private SensorViewDao sensorViewDao;
    @Autowired
    private SensorDetailDao sensorDetailDao;

    /* */
    public int querySensorNum(String type, String condition){
        return sensorViewDao.querySensorNum(type, condition);
    }

    public List<SensorView> querySensorPage(String type, String condition, int pageStart, int pageSize) {
        return sensorViewDao.querySensorPage(type, condition, pageStart, pageSize);
    }

    public SensorDetail querySensor(int sensorId) {
        return sensorDetailDao.querySensorDetail(sensorId);
    }

    /* 关键字查询 */
    public List<SensorView> searchSensor(String word) {
        List<Integer> ids = sensorDetailDao.searchSensor(word);
        List<SensorView> res = new ArrayList<>();
        for(int i : ids) {
            SensorView sensorView = sensorViewDao.querySensorView(i);
            res.add(sensorView);
        }
        return res;
    }

    /* 插入数据 */
    public int insertSensor(Map<String, Object> input) {
        SensorView sensorView = new SensorView(input);
        SensorDetail sensorDetail = new SensorDetail(input);
        sensorViewDao.insertSensorView(sensorView);
        sensorDetailDao.insertSensorDetail(sensorDetail);
        return 1;
    }

    public int deleteSensor(int sensorId) {
        sensorViewDao.deleteSensorView(sensorId);
        sensorDetailDao.deleteSensorDetail(sensorId);
        return 1;
    }
}
