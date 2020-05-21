package travel_system.travel_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import travel_system.travel_system.entity.Hotel;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping({"/"})
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String map1(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "login";
    }

    @RequestMapping("/index")
    public String mapIndex(Model model) {
        return "index";
    }

    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
//            return "dashboard";
            session.setAttribute("loginUser", username);
            return "redirect:/index";
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
