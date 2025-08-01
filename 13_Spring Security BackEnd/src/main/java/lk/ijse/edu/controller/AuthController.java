package lk.ijse.edu.controller;

import lk.ijse.edu.dto.ApiResponse;
import lk.ijse.edu.dto.AuthDTO;
import lk.ijse.edu.dto.RegisterDTO;
import lk.ijse.edu.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser(
            @RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.register(registerDTO)));
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> login(
            @RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.authenticate(authDTO)));
    }
}