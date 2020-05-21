package team.ustc.sensor.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.ustc.sensor.dao.SensorDao;
import team.ustc.sensor.dao.SensorViewDao;
import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.*;
import team.ustc.sensor.service.SensorService;
import team.ustc.sensor.util.Encrypt;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应传感器请求
 */
@RestController
public class SensorController {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Encrypt encrypt;

    /**
     * 查询传感器列表
     */
    @GetMapping("/SensorView")
    public Map<String, Object> getSensorView(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String type = request.getParameter("type");
        String condition = request.getParameter("condition");
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        int pageStart = (pageNum - 1) * pageSize;
        if(pageStart < 0) {
            map.put("code", StatusCode.BADREQUEST.getCode());
            return map;
        }
        int total = sensorService.querySensorNum(type, condition);
        List<SensorView> list = sensorService.querySensorPage(type, condition, pageStart, pageSize);
        if (list != null && list.size() > 0) {
            map.put("code", StatusCode.SUCCESS.getCode());
            map.put("data", list);
            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
            map.put("total", total);
        }else {
            map.put("code", StatusCode.NOTFOUND.getCode());
        }
        return map;
    }


    /**
     * 查询传感器详情
     */
    @GetMapping("/SensorDetail")
    @ApiImplicitParams({ @ApiImplicitParam(name = "sensorId",
            value = "传感器id",
            dataType = "Integer",
            paramType = "query",
            required = true)})
    public Map<String, Object> getSensorDetail(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer sensorId = Integer.valueOf(request.getParameter("sensorId"));
        SensorDetail sensorDetail = sensorService.querySensor(sensorId);
        if (sensorDetail != null) {
            map.put("code", StatusCode.SUCCESS.getCode());
            map.put("data", sensorDetail);
        }else {
            map.put("code", StatusCode.NOTFOUND.getCode());
        }
        return map;
    }

    /**
     * 搜索
     */
    @GetMapping("/SensorSearch")
    @ApiImplicitParams({ @ApiImplicitParam(name = "word",
            value = "关键词",
            dataType = "String",
            paramType = "query",
            required = true)})
    public Map<String, Object> getSensorSearch(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String word = request.getParameter("word");
        if(word.length() < 2) {
            map.put("code", StatusCode.BADREQUEST.getCode());
            return map;
        }
        List<SensorView> list = sensorService.searchSensor(word);
        if (list != null && list.size() > 0) {
            map.put("code", StatusCode.SUCCESS.getCode());
            map.put("data", list);
        }else {
            map.put("code", StatusCode.NOTFOUND.getCode());
        }
        return map;
    }


    /**
     * 添加传感器
     */
    @PostMapping("SensorAdd")
    public Map<String, Object> addDevice(@RequestBody Map<String, Object> input){
        Map<String, Object> map = new HashMap<String, Object>();
        int sensorId = (int)input.get("sensorId");
        SensorDetail sensorDetail = sensorService.querySensor(sensorId);
        if(sensorDetail != null){
            map.put("code", StatusCode.BADREQUEST.getCode());
        }else {
            sensorService.insertSensor(input);
            SensorDetail sensorDetail2 = sensorService.querySensor(sensorId);
            if(sensorDetail.equals(sensorDetail2)){
                map.put("code", StatusCode.SUCCESS.getCode());
            }else {
                map.put("code", StatusCode.SERVERERROR.getCode());
            }
        }
        return map;
    }


    /**
     * 删除传感器
     */
    @PostMapping("SensorRemove")
    public Map<String, Object> removeDevice(@RequestBody Map<String, Object> input){
        Map<String, Object> map = new HashMap<String, Object>();
        String username = input.get("username").toString();
        String password = input.get("password").toString();
        int sensorId = Integer.valueOf(input.get("sensorId").toString());
        User user = userDao.queryUser(username);
        if(user == null){
            map.put("code", StatusCode.NOTFOUND.getCode());
        }else if(!user.getPassword().equals(encrypt.md5(password))){
            map.put("code", StatusCode.BADREQUEST.getCode());
        }else{
            sensorService.deleteSensor(sensorId);
            map.put("code", StatusCode.SUCCESS.getCode());
        }
        return map;
    }

}
