package lk.ijse.edu.dto;

import lk.ijse.edu.entity.Role;
import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String role; //USER or ADMIN
}
