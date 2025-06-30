package lk.ijse.edu.controller;

import jakarta.servlet.annotation.MultipartConfig;
import lk.ijse.edu.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

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

    //save customer - Query Params
    @PostMapping(params = {"CID", "CName", "CAddress"})
    public String saveCustomerQueryParams(@RequestParam("CID") String CID, @RequestParam("CName") String CName, @RequestParam("CAddress") String CAddress) {
        System.out.println("Customer ID: " + CID);
        System.out.println("Customer Name: " + CName);
        System.out.println("Customer Address: " + CAddress);
        return "Customer saved via Query Params";
    }

    //save customer - path variables
    @PostMapping(path = "saveWithPathVariable/{CID}/{CName}/{CAddress}")
    public String saveCustomerPathVariables(@PathVariable("CID") String CID, @PathVariable("CName") String CName, @PathVariable("CAddress") String CAddress) {
        System.out.println("Customer ID: " + CID);
        System.out.println("Customer Name: " + CName);
        System.out.println("Customer Address: " + CAddress);
        return "Customer saved via Path Variables";
    }
}
