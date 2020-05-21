package team.ustc.sensor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.User;
import team.ustc.sensor.util.Encrypt;


/**
 * 账号数据操作事务
 *
 * @auther MrJoker
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;

    public User queryUser(String username) {
        return userDao.queryUser(username);
    }

    public User queryUserById(String id){return userDao.queryUserById(id);}

    public void addUser(String username, String password) {
        userDao.addUser(username, password);
    }

    public void updateUserPassword(String username, String password) {
        userDao.updateUserPassword(username, password);
    }

    public void deleteUser(String id){
        userDao.deleteUser(id);
    }
}
