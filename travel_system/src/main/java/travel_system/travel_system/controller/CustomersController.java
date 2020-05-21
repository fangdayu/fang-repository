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
public class CustomersController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/addCustomer")
    public String map1(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCust(Customer customer) {
        jdbcTemplate.update("insert into customers values(" + customer.getCustomers_id() + ",\"" + customer.getCustomersName() + "\");");
        return "index";
    }

    @RequestMapping("/queryCustomer")
    public String queryF(Model model) {
        model.addAttribute("customer", new Customer());
        List<Customer> list = jdbcTemplate.query("select * from customers order by customers_id asc",new BeanPropertyRowMapper<>(Customer.class));
        model.addAttribute("list",list);
        return "queryCustomer";
    }



}
