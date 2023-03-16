package pl.onak.d.planner.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.onak.d.planner.dto.CreateUserRequest;

import pl.onak.d.planner.dto.CreateUserResponse;
import pl.onak.d.planner.service.UserService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {

        CreateUserResponse createUserResponse = userService.addUser(createUserRequest);

        return new ResponseEntity<CreateUserResponse>(createUserResponse, HttpStatus.CREATED);
    }
}