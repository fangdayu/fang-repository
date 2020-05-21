package team.ustc.sensor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.ustc.sensor.dao.SensorDao;
import team.ustc.sensor.dao.UserDao;
import team.ustc.sensor.entity.Sensor;
import team.ustc.sensor.entity.User;
import team.ustc.sensor.util.Encrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应传感器请求
 */
@RestController
public class LogController {

    @Autowired(required = false)
    UserDao userDao;
    @Autowired
    Encrypt encrypt = new Encrypt();

    /**
     * 登录请求
     * @Auther MrJoker
     */
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User input, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        String username = input.getUsername();
        String password = input.getPassword();
        User user = userDao.queryUser(username);
        if(user == null){
            map.put("message", "用户名不存在");
            map.put("code", 404);
        }else if(!user.getPassword().equals(encrypt.md5(password))){
            map.put("message","密码不正确");
            map.put("code", 500);
        }else{
            map.put("message", "登录成功");
            map.put("username", username);
            map.put("usertype", user.isCompany());
            map.put("code", 200);
            session.setAttribute("user", username);
        }
        System.out.println(username + "请求登录：" + map.get("message"));
        return map;
    }

    /**
     * 注册请求
     * @Auther MrJoker
     */
    @PostMapping("logup")
    public Map<String, Object> logup(@RequestBody User input, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        String username = input.getUsername();
        User user = userDao.queryUser(username);
        if(user != null){
            map.put("message", "用户已存在");
            map.put("code", 111);
        }else {
            input.setPassword(encrypt.md5(input.getPassword()));
            userDao.addUser(input);
            user = userDao.queryUser(username);
            if(user != null){
                map.put("message", "注册成功");
                map.put("username", username);
                map.put("usertype", user.isCompany());
                map.put("code", 200);
                session.setAttribute("user", username);
            }else {
                map.put("message", "注册失败，请重试");
                map.put("code", 500);
            }
        }
        System.out.println(username + "注册请求：" + map.get("message"));
        return map;
    }


    /**
     * 获取用户信息
     */
    @GetMapping("/getUser")
    public Map<String, Object> getDevice(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("接收到查询用户请求" + id);
        User user = userDao.queryUser(id);
        if (user != null) {
            user.setPassword(null);
            map.put("data", user);
            map.put("message", "用户信息已返回");
            map.put("code", 200);
        }else {
            map.put("message", "用户信息未找到");
            map.put("code", 404);
        }
        return map;
    }
}