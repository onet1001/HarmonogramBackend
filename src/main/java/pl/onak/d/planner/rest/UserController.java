package pl.onak.d.planner.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.onak.d.planner.dto.AddUserRequest;

import pl.onak.d.planner.entity.User;
import pl.onak.d.planner.exeption.UserExistsException;
import pl.onak.d.planner.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<Object> registerNewUser(@RequestBody AddUserRequest addUserRequest) {

        User result = userService.addUser(addUserRequest);
        return ResponseHandler.generateResponse("User created succesfully!",HttpStatus.CREATED, result);
    }

}
