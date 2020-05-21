package team.ustc.sensor.util;

import org.springframework.stereotype.Component;
import team.ustc.sensor.entity.User;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类：检查用户名密码格式
 *
 * @auther MrJoker
 */
@Component
public class CheckFormat {
    public boolean checkFormat(User user){

        if(user.getUsername().length() < 6){
            return false;
        }
        if(user.getUsername().length() > 18){
            return false;
        }
        if(user.getPassword().length() < 6){
            return false;
        }
        if(user.getPassword().length() > 18){
            return false;
        }
        Pattern pat = Pattern.compile("[A-Za-z0-9]*");
        Matcher matchUsername = pat.matcher(user.getUsername());
        if(!matchUsername.matches()){
            return false;
        }
        Matcher matchPassword = pat.matcher(user.getPassword());
        if(!matchPassword.matches()){
            return false;
        }
        Pattern let = Pattern.compile("[A-Za-z]");
        Pattern num = Pattern.compile("[0-9]");
        Matcher letUsername = let.matcher(user.getUsername());
        Matcher numUsername = num.matcher(user.getUsername());
        if(!(letUsername.find() && numUsername.find())){
            return false;
        }
        Matcher letPassword = let.matcher(user.getPassword());
        Matcher numPassword = num.matcher(user.getPassword());
        if(!(letPassword.find() && numPassword.find())){
            return false;
        }
        return true;
    }
}
