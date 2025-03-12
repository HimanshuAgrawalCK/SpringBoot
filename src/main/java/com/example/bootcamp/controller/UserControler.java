package com.example.bootcamp.controller;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// helllo
@RestController
@RequestMapping("/api")
public class UserControler {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        System.out.println("This is get user in controller");
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/filteruser")
    public ResponseEntity<List<UserDTO>> getFilteredUser(@RequestParam("startWith") String userStartWith) {
        System.out.println(userStartWith);
        System.out.println("This is filtered method in controller");
        return ResponseEntity.ok(userService.getFilteredUser(userStartWith));
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        System.out.println("hello");
        UserDTO dto = userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping("/userupdate")
    public ResponseEntity<UserDTO> updateUser(@RequestParam("id")Long id, @RequestBody UserDTO user)
    {
        System.out.println(user);
        return ResponseEntity.ok(userService.updateUser(id, user));
    }


    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam("id")Long id)
    {
        System.out.println("DELETING USER");
        return ResponseEntity.ok(userService.deleteUser(id));
    }


}
