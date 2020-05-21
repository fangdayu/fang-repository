package travel_system.travel_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import travel_system.travel_system.entity.Customer;
import travel_system.travel_system.entity.Flight;

import java.util.List;
import java.util.Map;

@Controller
public class FlightController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/addFlight")
    public String map1(Model model) {
        model.addAttribute("flight", new Flight());
        return "addFlight";
    }

    @PostMapping("/addFlight")
    public String addFlight(Flight flight) {
        jdbcTemplate.update("insert into flights values(" + flight.getFlights_id() + ",\""
                + flight.getFlightNum() + "\"," + flight.getPrice() + "," + flight.getNumSeats() + ","
                + flight.getNumAvail() + ",\"" + flight.getFromCity() + "\",\"" + flight.getArivCity() + "\");");
        return "index";
    }

    @RequestMapping("/queryFlight")
    public String queryF(Model model) {
        model.addAttribute("flight", new Flight());
        List<Flight> list = jdbcTemplate.query("select * from flights",new BeanPropertyRowMapper<>(Flight.class));
        model.addAttribute("list",list);
        return "queryFlight";
    }

//    @PostMapping("/listFlight")
//    public String listFlight(Model model,Flight flight) {
//        model.addAttribute("flight",flight);
////        jdbcTemplate.queryForList("select * from flights"+" where flights_id ="+flight.getFlights_id()+";");
//        System.out.println(jdbcTemplate.queryForList("select * from flights"));
//        return "";
//    }

}
