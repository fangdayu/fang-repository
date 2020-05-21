package travel_system.travel_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import travel_system.travel_system.entity.Car;
import travel_system.travel_system.entity.Customer;
import travel_system.travel_system.entity.Flight;

import java.util.List;

@Controller
public class RouteController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/queryRoute")
    public String queryR(Model model) {
        model.addAttribute("customer", new Customer());
        List<Flight> listf = jdbcTemplate.query("select * from flights where flights_id= (select " +
                "resvKey from reservations where resvType=0 and custId=1) ",new BeanPropertyRowMapper<>(Flight.class));
        model.addAttribute("listf",listf);
        List<Car> listc = jdbcTemplate.query("select * from cars where cars_id= (select " +
                "resvKey from reservations where resvType=1 and custId=1) ",new BeanPropertyRowMapper<>(Car.class));
        model.addAttribute("listc",listc);
        return "queryRoute";
    }
}
