package team.ustc.sensor.dao;

import team.ustc.sensor.entity.User;

/**
 * 用户数据库操作接口
 *
 * @auther MrJoker
 */
public interface UserDao {

    /**
     * 通过用户名查询账户
     *
     * @param username
     * @return user
     */
    User queryUser(String username);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User queryUserById(String id);

    /**
     * 添加用户
     *
     * @param username
     * @param password
     */
    void addUser(String username, String password);

    /**
     * 修改用户密码
     *
     * @param username
     * @param password
     */
    void updateUserPassword(String username, String password);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(String id);

}
