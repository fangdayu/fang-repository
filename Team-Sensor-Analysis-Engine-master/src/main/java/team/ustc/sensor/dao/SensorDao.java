package team.ustc.sensor.dao;

import org.springframework.web.bind.annotation.RequestParam;
import team.ustc.sensor.entity.Sensor;

import java.util.List;

/**
 * 传感器数据库操作接口
 *
 * @auther MrJoker
 */

public interface SensorDao {
    /**
     * 展示传感器
     *
     * @return sensorList
     */
    List<Sensor> querySensorAll();

    /**
     * 根据ID查找传感器
     *
     * @return sensor
     */
    Sensor querySensorById(int ID);

    /**
     * 组合查询
     *
     * @return
     */
    List<Sensor> combinedQuery(String brand, String product_id, String type, String type_detail, String input,
                               String output, String using_environment, String sRange, String sLevel,
                               String application, String description, String strength, String more_detail);

    /**
     * 插入传感器Sensor
     **/
    void addSensor(String brand, String product_id, String type, String type_detail, String input,
                   String output, String using_environment, String sRange, String sLevel,
                   String application, String description, String strength, String more_detail);

    /**
     * 更新传感器信息
     */
    void updateSensor(String id, String columnName, String newColumn);

    /**
     * 删除传感器信息
     */
    void deleteSensor(String id);
}
