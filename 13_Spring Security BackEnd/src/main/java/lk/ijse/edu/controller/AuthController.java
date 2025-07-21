package lk.ijse.edu.controller;

import lk.ijse.edu.dto.ApiResponse;
import lk.ijse.edu.dto.AuthDTO;
import lk.ijse.edu.dto.RegisterDTO;
import lk.ijse.edu.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> signup(@RequestBody RegisterDTO user){
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.register(user)
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> logion(@RequestBody AuthDTO authDto){
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.authenticate(authDto)
        ));
    }
}
