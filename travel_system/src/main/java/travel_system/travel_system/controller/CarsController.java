package travel_system.travel_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import travel_system.travel_system.entity.Car;
import travel_system.travel_system.entity.Flight;
import travel_system.travel_system.entity.Hotel;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/addCar")
    public String map1(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCar(Car car) {
        jdbcTemplate.update("insert into cars values(" + car.getCars_id() + ",\""
                + car.getType() + "\",\"" + car.getLocation() + "\"," + car.getPrice() + ","
                + car.getNumCars() + "," + car.getNumAvail() + ");");
        return "index";
    }

    @RequestMapping("/queryCar")
    public String queryC(Model model) {
        model.addAttribute("car", new Car());
        List<Car> list = jdbcTemplate.query("select * from cars order by cars_id asc", new BeanPropertyRowMapper<>(Car.class));
        model.addAttribute("list", list);
        return "queryCar";
    }

}
