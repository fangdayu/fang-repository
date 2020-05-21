package team.ustc.sensor.dao;

import org.springframework.stereotype.Repository;
import team.ustc.sensor.entity.User;

import java.math.BigDecimal;

/**
 * 用户数据库操作接口
 *
 * @auther MrJoker
 */
@Repository
public interface UserDao {

    /**
     * 通过用户名查询账户
     * @param username
     * @return user
     */
    User queryUser(String username);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 添加用户
     * @param price 转入金额
     * @param username 转入用户
     */
    void editBalance(BigDecimal price, String username);
}
