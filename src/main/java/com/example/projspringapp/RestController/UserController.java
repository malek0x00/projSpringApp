package com.example.projspringapp.RestController;

import com.example.projspringapp.DTO.ErrorMessage;
import com.example.projspringapp.DTO.LoginDTO;
import com.example.projspringapp.DTO.LoginResponseDTO;
import com.example.projspringapp.Model.User;
import com.example.projspringapp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(user.getPassword().getBytes());
        String hashedPass = new String(messageDigest.digest());

        User tmp = User.builder()
                .city(user.getCity())
                .cin(user.getCin())
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .password(hashedPass)
                .build();
        try {
            User createdUser = userRepository.save(tmp);
            return ResponseEntity.ok(new LoginResponseDTO(createdUser.getId(), createdUser.getName(), createdUser.getEmail(), createdUser.getCin(), createdUser.getCity()));
        }
        catch (Exception ex){
            return ResponseEntity.ok(new ErrorMessage("User Already Exists"));

        }

    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        Pageable pageable = PageRequest.of(1, 10);
        return userRepository.findAll(pageable).getContent();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO creds) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(creds.getPassword().getBytes());
        String hashedPass = new String(messageDigest.digest());
        //return creds.getPassword();
        User tmp = userRepository.findUserByEmailIsAndPasswordIs(creds.getEmail(), hashedPass);
        try {
            return ResponseEntity.ok(new LoginResponseDTO(tmp.getId(), tmp.getName(), tmp.getEmail(), tmp.getCin(), tmp.getCity()));
        }
        catch(Exception e){
            return ResponseEntity.ok(new ErrorMessage("User Not Found"));
        }
    }



}
