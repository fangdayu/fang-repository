package team.ustc.sensor.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.ustc.sensor.entity.Sensor;
import team.ustc.sensor.entity.User;
import team.ustc.sensor.service.SensorServiceImpl;
import team.ustc.sensor.service.UserServiceImpl;
import team.ustc.sensor.util.JwtUtils;
import team.ustc.sensor.util.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 响应传感器增删查改请求
 */
@RestController
@Api(description = "传感器Controller")
public class SensorController {
    @Autowired
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    @Autowired
    SensorServiceImpl sensorServiceImpl = new SensorServiceImpl();

    @PostMapping(value = "/sensor/queryAll")
    @ApiOperation(value = "/sensor/queryAll", notes = "查询全部传感器信息")
    public R checkLogin(@RequestParam("token") String token) {
        //判断用户token是否有效
        if (JwtUtils.checkToken(token)) {
            //有效返回查询结果
            return R.ok().data("list", sensorServiceImpl.querySensorAll());
        } else {
            //token无效返回错误信息
            return R.error().message("用户token无效");
        }
    }

    @PostMapping(value = "/sensor/queryById")
    @ApiOperation(value = "/sensor/queryById", notes = "通过id查询传感器")
    public R queryById(@RequestParam("token") String token, @RequestParam("id") int id) {
        //判断用户token是否有效
        if (JwtUtils.checkToken(token)) {
            //根据id查询传感器
            Sensor sensor = sensorServiceImpl.querySensorById(id);
            if (sensor != null) {
                //查询到传感器返回传感器数据
                return R.ok().data("sensor", sensor);
            } else {
                //未查询到，返回错误信息
                return R.error().message("未查询到对应id传感器");
            }
        } else {
            //token无效返回错误信息
            return R.error().message("用户token无效");
        }
    }

    //非id属性进行组合模糊查询，查询用不到的须传入值为null的字符串
    @PostMapping(value = "/sensor/combinedQuery")
    @ApiOperation(value = "/sensor/combinedQuery", notes = "条件组合模糊查询，不参与查询的属性值须传入null字符串")
    public R combinedQuery(@RequestParam("token") String token, @RequestParam("brand") String brand,
                           @RequestParam("product_id") String product_id, @RequestParam("type") String type,
                           @RequestParam("type_detail") String type_detail, @RequestParam("input") String input,
                           @RequestParam("output") String output, @RequestParam("using_environment") String using_environment,
                           @RequestParam("sRange") String sRange, @RequestParam("sLevel") String sLevel,
                           @RequestParam("application") String application, @RequestParam("description") String description,
                           @RequestParam("strength") String strength, @RequestParam("more_detail") String more_detail) {
        //判断用户token是否有效
        if (JwtUtils.checkToken(token)) {
            //组合查询传感器
            List<Sensor> list = sensorServiceImpl.combinedQuery(brand, product_id, type, type_detail, input,
                    output, using_environment, sRange, sLevel, application, description, strength, more_detail);
            if (list != null) {
                //查询到传感器返回传感器数据
                return R.ok().data("list", list);
            } else {
                //未查询到，返回错误信息
                return R.error().message("未查询到对应传感器");
            }
        } else {
            //token无效返回错误信息
            return R.error().message("用户token无效");
        }
    }

    @PostMapping(value = "/sensor/addSensor")
    @ApiOperation(value = "/sensor/addSensor", notes = "添加传感器")
    public R addSensor(@RequestParam("token") String token, @RequestParam("brand") String brand,
                       @RequestParam("product_id") String product_id, @RequestParam("type") String type,
                       @RequestParam("type_detail") String type_detail, @RequestParam("input") String input,
                       @RequestParam("output") String output, @RequestParam("using_environment") String using_environment,
                       @RequestParam("sRange") String sRange, @RequestParam("sLevel") String sLevel,
                       @RequestParam("application") String application, @RequestParam("description") String description,
                       @RequestParam("strength") String strength, @RequestParam("more_detail") String more_detail) {
        //判断用户token是否有效
        if (JwtUtils.checkToken(token)) {
            //有效返回查询结果
            sensorServiceImpl.addSensor(brand, product_id, type, type_detail, input,
                    output, using_environment, sRange, sLevel, application, description, strength, more_detail);
            Sensor sensor = sensorServiceImpl.combinedQuery(brand, product_id, type, type_detail, input,
                    output, using_environment, sRange, sLevel, application, description, strength, more_detail).get(0);
            return R.ok().data("sensor", sensor);
        } else {
            //token无效返回错误信息
            return R.error().message("用户token无效");
        }
    }

    @PostMapping(value = "/sensor/updateSensor")
    @ApiOperation(value = "/sensor/updateSensor", notes = "更新传感器，须传入传感器id,要更新的属性名称,更新后的属性值")
    public R updateSensor(@RequestParam("token") String token, @RequestParam("id") String id,
                          @RequestParam("columnName") String columnName, @RequestParam("newColumn") String newColumn) {
        //判断用户token是否有效
        if (JwtUtils.checkToken(token)) {
            Sensor sensor = sensorServiceImpl.querySensorById(Integer.parseInt(id));
            if (sensor != null) {
                //新建set存放属性名
                Set<String> set = new HashSet<String>();
                set.add("brand");
                set.add("product_id");
                set.add("type");
                set.add("type_detail");
                set.add("input");
                set.add("output");
                set.add("using_environment");
                set.add("sRange");
                set.add("sLevel");
                set.add("application");
                set.add("description");
                set.add("strength");
                set.add("more_detail");
                //判断输入属性名称是否满足要求
                if (set.contains(columnName)) {
                    sensorServiceImpl.updateSensor(id, columnName, newColumn);
                    return R.ok().message("返回更新后的传感器信息").data("sensor", sensorServiceImpl.querySensorById(Integer.parseInt(id)));
                } else {
                    return R.error().message("");
                }
            } else {
                return R.error().message("错误的传感器id");
            }
        } else {
            //token无效返回错误信息
            return R.error().message("用户token无效");
        }
    }

    @PostMapping(value = "/sensor/deleteSensor")
    @ApiOperation(value = "/sensor/deleteSensor", notes = "删除传感器，仅限管理员（fangdayu123）操作")
    public R deleteSensor(@RequestParam("token") String token, @RequestParam("id") String id) {
        //判断token是否是管理员的token
        if (JwtUtils.getMemberNameByJwtToken(token).equals("fangdayu123")) {
            Sensor sensor = sensorServiceImpl.querySensorById(Integer.parseInt(id));
            //判断传感器id是否正确
            if (sensor != null) {
                sensorServiceImpl.deleteSensor(id);
                return R.ok().message("已成功删除该传感器");
            } else {
                return R.error().message("错误的传感器id");
            }
        } else {
            return R.error().message("您没有删除权限");
        }
    }

}
