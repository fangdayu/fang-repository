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
import travel_system.travel_system.entity.Reservation;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/queryReservation")
    public String queryR(Model model) {
        model.addAttribute("reservation", new Reservation());
        List<Reservation> list = jdbcTemplate.query("select * from reservations order by reservations_id asc", new BeanPropertyRowMapper<>(Reservation.class));
        model.addAttribute("list", list);
        return "queryReservation";
    }

    @RequestMapping("/flightReservation")
    public String queryF(Model model) {
        model.addAttribute("reservation", new Reservation());
        List<Flight> listf = jdbcTemplate.query("select * from flights order by flights_id asc", new BeanPropertyRowMapper<>(Flight.class));
        model.addAttribute("listf", listf);
        return "flightReservation";
    }

    @PostMapping("/flightReservation")
    public String flightR(Reservation reservation) {

        jdbcTemplate.update("insert into reservations values(" + reservation.getReservations_id() + ",\""
                + reservation.getResvKey() + "\"," + 0 + "," + reservation.getCustId() + ");");
        jdbcTemplate.update("update flights set numAvail=numAvail-1 where flights_id=" + Integer.parseInt(reservation.getResvKey()) + ";");
        return "index";
    }

    @RequestMapping("/carReservation")
    public String queryC(Model model) {
        model.addAttribute("reservation", new Reservation());
        List<Car> listc = jdbcTemplate.query("select * from cars order by cars_id asc", new BeanPropertyRowMapper<>(Car.class));
        model.addAttribute("listc", listc);
        return "carReservation";
    }

    @PostMapping("/carReservation")
    public String carR(Reservation reservation) {
        jdbcTemplate.update("insert into reservations values(" + reservation.getReservations_id() + ",\""
                + reservation.getResvKey() + "\"," + 1 + "," + reservation.getCustId() + ");");
        jdbcTemplate.update("update cars set numAvail=numAvail-1 where cars_id=" + Integer.parseInt(reservation.getResvKey()) + ";");
        return "index";
    }


    @RequestMapping("/hotelReservation")
    public String queryH(Model model) {
        model.addAttribute("reservation", new Reservation());
        List<Hotel> listh = jdbcTemplate.query("select * from hotels order by hotels_id asc", new BeanPropertyRowMapper<>(Hotel.class));
        model.addAttribute("listh", listh);
        return "hotelReservation";
    }

    @PostMapping("/hotelReservation")
    public String hotelR(Reservation reservation) {
        jdbcTemplate.update("insert into reservations values(" + reservation.getReservations_id() + ",\""
                + reservation.getResvKey() + "\"," + 2 + "," + reservation.getCustId() + ");");
        jdbcTemplate.update("update hotels set numAvail=numAvail-1 where hotels_id=" + Integer.parseInt(reservation.getResvKey()) + ";");
        return "index";
    }

}
