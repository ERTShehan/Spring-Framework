package lk.ijse.edu.controller;

import jakarta.servlet.annotation.MultipartConfig;
import lk.ijse.edu.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
//@MultipartConfig
public class CustomerController {
    //save customer - form data(x-www-form-urlencoded)
    //CID - Customer ID
    //CNAME - Customer Name
    //CAddress - Customer Address
    @PostMapping
    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        //x-www-form-urlencoded data widiyata awai
        System.out.println("Customer ID: " + customerDTO.getCID());
        System.out.println("Customer Name: " + customerDTO.getCName());
        System.out.println("Customer Address: " + customerDTO.getCAddress());
        return "Customer saved";
    }
}
