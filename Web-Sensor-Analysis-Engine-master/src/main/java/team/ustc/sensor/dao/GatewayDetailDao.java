package team.ustc.sensor.dao;

import team.ustc.sensor.entity.GatewayDetail;
import team.ustc.sensor.entity.SensorDetail;

public interface GatewayDetailDao {
    /**
     * 根据ID查找网关
     *
     * @param gatewayId 网关ID
     * @return sensor
     */
    GatewayDetail queryGatewayDetail(int gatewayId);

    /**
     * 插入网关详情
     *
     * @param gatewayDetail 网关
     * @return ID
     */
    int insertGatewayDetail(GatewayDetail gatewayDetail);
}
