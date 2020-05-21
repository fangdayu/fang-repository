package travel_system.travel_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import travel_system.travel_system.entity.Car;
import travel_system.travel_system.entity.Customer;
import travel_system.travel_system.entity.Hotel;

import java.util.List;

@Controller
public class HotelsController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/addHotel")
    public String map1(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "addHotel";
    }

    @PostMapping("/addHotel")
    public String addHotel(Hotel hotel) {
        jdbcTemplate.update("insert into hotels values(" + hotel.getHotels_id() + ",\""
                + hotel.getName() + "\",\"" + hotel.getLocation() + "\"," + hotel.getPrice() + ","
                + hotel.getNumRooms() + "," + hotel.getNumAvail() + ");");
        return "addHotel";
    }

    @RequestMapping("/queryHotel")
    public String queryH(Model model) {
        model.addAttribute("hotel",new Hotel());
        List<Hotel> list = jdbcTemplate.query("select * from hotels order by hotels_id asc", new BeanPropertyRowMapper<>(Hotel.class));
        model.addAttribute("list", list);
        return "queryHotel";
    }

//    @PostMapping("/queryHotel")
////    public String queryH2(@RequestParam("hotels_id") int id){
////        List<Hotel> list=jdbcTemplate.query("select * from hotels where hotels_id="+id+";",new BeanPropertyRowMapper<>(Hotel.class));
////        System.out.println(list);
////        return  "redirect:/queryHotel";
////    }


}
