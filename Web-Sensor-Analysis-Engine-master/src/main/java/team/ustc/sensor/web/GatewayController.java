package team.ustc.sensor.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.GatewayDetail;
import team.ustc.sensor.entity.SensorDetail;
import team.ustc.sensor.entity.SensorView;
import team.ustc.sensor.entity.StatusCode;
import team.ustc.sensor.service.GatewayService;
import team.ustc.sensor.util.Encrypt;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GatewayController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Encrypt encrypt;
    @Autowired
    private GatewayService gatewayService;

    /**
     * 查询网关详情
     */
    @GetMapping("/queryGatewayDetail")
    @ApiImplicitParams({@ApiImplicitParam(name = "gatewayId",
            value = "网关id",
            dataType = "Integer",
            paramType = "query",
            required = true)})
    public Map<String, Object> getGatewayDetail(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer gatewayId = Integer.valueOf(request.getParameter("gatewayId"));
        GatewayDetail gatewayDetail = gatewayService.queryGatewayDetail(gatewayId);
        if (gatewayDetail != null) {
            map.put("code", StatusCode.SUCCESS.getCode());
            map.put("data", gatewayDetail);
        } else {
            map.put("code", StatusCode.NOTFOUND.getCode());
        }
        return map;
    }

    /**
     * 添加网关
     */
    @PostMapping("GatewayAdd")
    public Map<String, Object> addDevice(@RequestBody Map<String, Object> input) {
        Map<String, Object> map = new HashMap<String, Object>();
        int gatewayId = (int) input.get("gatewayId");
        GatewayDetail gatewayDetail = gatewayService.queryGatewayDetail(gatewayId);
        if (gatewayDetail != null) {
            map.put("code", StatusCode.BADREQUEST.getCode());
        } else {
            gatewayService.insertGateway(input);
//            sensorService.insertSensor(input);
            GatewayDetail gatewayDetail12 = gatewayService.queryGatewayDetail(gatewayId);
//            SensorDetail sensorDetail2 = sensorService.querySensor(sensorId);
            if (gatewayDetail.equals(gatewayDetail12)) {
                map.put("code", StatusCode.SUCCESS.getCode());
            } else {
                map.put("code", StatusCode.SERVERERROR.getCode());
            }
        }
        return map;
    }


//    /**
//     * 搜索网关
//     */
//    @GetMapping("/searchGatewayDetail")
//    @ApiImplicitParams({ @ApiImplicitParam(name = "word",
//            value = "关键词",
//            dataType = "String",
//            paramType = "query",
//            required = true)})
//    public Map<String, Object> getSensorSearch(HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        String word = request.getParameter("word");
//        if(word.length() < 2) {
//            map.put("code", StatusCode.BADREQUEST.getCode());
//            return map;
//        }
//        List<SensorView> list = sensorService.searchSensor(word);
//        if (list != null && list.size() > 0) {
//            map.put("code", StatusCode.SUCCESS.getCode());
//            map.put("data", list);
//        }else {
//            map.put("code", StatusCode.NOTFOUND.getCode());
//        }
//        return map;
//    }
}
