package lk.ijse.edu.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String name;
    private String username;
    private String password;
    private String role; // ADMIN or USER
}
