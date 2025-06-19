package com.auth.controller;
import com.auth.dto.AuthRequest;
import com.auth.dto.AuthResponse;
import com.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://heartfelt-blancmange-de144e.netlify.app")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        return service.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return service.login(request);
    }
}
