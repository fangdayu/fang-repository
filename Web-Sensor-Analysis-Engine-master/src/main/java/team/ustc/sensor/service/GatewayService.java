package team.ustc.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.ustc.sensor.dao.GatewayDetailDao;
import team.ustc.sensor.entity.GatewayDetail;
import team.ustc.sensor.entity.SensorDetail;
import team.ustc.sensor.entity.SensorView;

import java.util.Map;


@Service
public class GatewayService {
    @Autowired
    GatewayDetailDao gatewayDetailDao;

    //网关查询
    public GatewayDetail queryGatewayDetail(int gatewayId) {
        return gatewayDetailDao.queryGatewayDetail(gatewayId);
    }

    /* 插入数据 */
    public int insertGateway(Map<String, Object> input) {
//        SensorView sensorView = new SensorView(input);
        GatewayDetail gatewayDetail = new GatewayDetail(input);
//        sensorViewDao.insertSensorView(sensorView);
        gatewayDetailDao.insertGatewayDetail(gatewayDetail);
        return 1;
    }
}
