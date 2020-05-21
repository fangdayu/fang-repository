package team.ustc.sensor.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.ustc.sensor.config.web.WebSecurityConfiguration;
import team.ustc.sensor.entity.Sensor;
import team.ustc.sensor.entity.User;
import team.ustc.sensor.service.UserServiceImpl;
import team.ustc.sensor.util.CheckFormat;
import team.ustc.sensor.util.Encrypt;
import team.ustc.sensor.util.JwtUtils;
import team.ustc.sensor.util.R;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@Api(description = "用户Controller")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    @Autowired
    Encrypt encrypt = new Encrypt();
    @Autowired
    CheckFormat checkFormat = new CheckFormat();

    //处理登录请求
    @PostMapping(value = "/user/login")
    @ApiOperation(value = "/user/login", notes = "登录请求处理方法")
    public R checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        //返回数据库加密信息
        User user = userServiceImpl.queryUser(username);
        if (user == null) {
            //R.error返回查询错误信息
            return R.error().message("登录失败，用户名不存在");
        }
        if (user.getPassword().equals(encrypt.md5(password))) {
            //R.ok返回查询成功信息,将带有用户信息的token返回
            return R.ok().data("token", JwtUtils.getJwtToken(Integer.toString(user.getId()), user.getUsername()));
        } else {
            //返回
            return R.error().message("登录失败，请检查密码是否正确");
        }
    }

    //退出登录
    @PostMapping("/user/logout")
    @ApiOperation(value = "/user/logout", notes = "退出登录方法")
    public R logout(@RequestParam("token") String token) {
        //验证用户成功，修改token
        if (JwtUtils.checkToken(token)) {
            //修改token使其无效，并将无效token返回
            token = token + 1;
            return R.ok().data("invalidToken", token);
        } else {
            return R.error().message("用户登录认证失败");
        }
    }

    //检查注册申请
    @PostMapping(value = "user/logup")
    @ApiOperation(value = "user/logup", notes = "注册方法")
    public R checkLogup(@RequestParam("username") String username, @RequestParam("password") String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        //检查输入格式
        if (!checkFormat.checkFormat(newUser)) return R.error().message("输入格式不正确");
        //检查用户名是否已存在
        User user = userServiceImpl.queryUser(username);
        if (user != null) {
            return R.error().message("用户名已存在");
        }
        //成功注册
        else {
            userServiceImpl.addUser(username, encrypt.md5(password));
            User addedUser = userServiceImpl.queryUser(username);
            return R.ok().message("注册成功").data("token", JwtUtils.getJwtToken(Integer.toString(addedUser.getId()), addedUser.getUsername()));
        }
    }


    //修改用户密码
    @PostMapping(value = "user/updatePassword")
    @ApiOperation(value = "user/updatePassword", notes = "更改密码方法")
    public R updatePassword(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("newPassword") String newPassword) {
        User user = userServiceImpl.queryUser(username);
        if (user == null) {
            return R.error().message("修改失败，用户名不存在");
        }
        if (!checkFormat.checkFormat(user)) return R.error().message("输入格式不正确");

        if (user.getPassword().equals(encrypt.md5(password))) {
            userServiceImpl.updateUserPassword(username, encrypt.md5(newPassword));
            //R.ok返回查询成功信息,将带有用户信息的token返回
            return R.ok().message("用户密码修改成功");
        } else {
            //返回
            return R.error().message("修改失败，请检查密码是否正确");
        }
    }

    @PostMapping(value = "/user/deleteUser")
    @ApiOperation(value = "user/deleteUser", notes = "删除用户方法，限管理员")
    public R deleteSensor(@RequestParam("token") String token, @RequestParam("id") String id) {
        //判断token是否是管理员的token
        if (JwtUtils.getMemberNameByJwtToken(token).equals("fangdayu123")) {
            User user = userServiceImpl.queryUserById(id);
            //判断用户id是否正确，且不可删除管理员账户
            if (user != null && !user.getUsername().equals("fangdayu123")) {
                userServiceImpl.deleteUser(id);
                return R.ok().message("已成功删除该用户");
            } else {
                return R.error().message("错误的用户id");
            }
        } else {
            return R.error().message("您没有删除权限");
        }
    }
}
