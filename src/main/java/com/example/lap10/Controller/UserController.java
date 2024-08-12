package com.example.lap10.Controller;

import com.example.lap10.Model.User;
import com.example.lap10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String Message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(Message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String Message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(Message);


        }
        boolean isUpdated = userService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.status(200).body("isUpdated");
        }
        return ResponseEntity.status(400).body("isUpdated");


    }
@DeleteMapping("/delete{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("isDeleted");

        }
        return ResponseEntity.status(400).body("isDeleted");
}


}