package com.binde.user.controller;


import com.binde.user.dto.UserRequest;
import com.binde.user.dto.UserResponse;
import com.binde.user.service.impl.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImplementation userService;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.fetchAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponse>> fetchUser(@PathVariable Long id) {
        if (userService.fetchUser(id).isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(userService.fetchUser(id));
    }

    @PostMapping
    public ResponseEntity<String> createUsers(@RequestBody UserRequest userRequest) {
        userService.addUsers(userRequest);
        return ResponseEntity.ok("user successfully added");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest updatedUserRequest,
                                             @PathVariable Long id) {
        boolean updated = userService.updateUser(id, updatedUserRequest);
        if (updated)
            return ResponseEntity.ok("user updated successfully added");
        return ResponseEntity.notFound().build();

    }
}
