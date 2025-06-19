package com.auth.service;
import com.auth.dto.AuthRequest;
import com.auth.dto.AuthResponse;
import com.auth.entity.User;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public AuthResponse register(AuthRequest req) {
        if (repo.findByEmail(req.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        repo.save(user);
        return new AuthResponse("Registered Successfully", user.getEmail());
    }

    public AuthResponse login(AuthRequest req) {
        User user = repo.findByEmail(req.getEmail());
        if (user == null || !user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new AuthResponse("Login Success", user.getEmail());
    }
}
