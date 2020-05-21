package team.ustc.sensor.dao;

import org.springframework.stereotype.Repository;
import team.ustc.sensor.entity.Sensor;
import team.ustc.sensor.entity.SensorView;

import java.util.List;


/**
 * 传感器概览数据库操作接口
 *
 * @auther MrJoker
 */

@Repository
public interface SensorViewDao {

    /**
     * 按 id 查询传感器
     * @param sensorId ID
     * @return sensorNum
     */
    SensorView querySensorView(Integer sensorId);

    /**
     * 查询传感器个数
     * @param type 查询类型
     * @param condition 查询条件
     * @return sensorNum
     */
    int querySensorNum(String type, String condition);

    /**
     * 查询传感器列表
     * @param type 查询类型
     * @param condition 查询条件
     * @param pageStart  返回位置
     * @param pageSize   返回个数
     * @return sensorList
     */
    List<SensorView> querySensorPage(String type, String condition, int pageStart, int pageSize);


    /**
     * 插入传感器概览
     * @param sensorView 传感器
     * @return ID
     */
    int insertSensorView(SensorView sensorView);

    /**
     * 删除传感器概览
     * @param sensorId 传感器ID
     * @return ID
     */
    int deleteSensorView(int sensorId);


}