package pl.onak.d.planner.rest;


import org.springframework.web.bind.annotation.*;
import pl.onak.d.planner.dto.AddUserRequest;

import pl.onak.d.planner.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public void registerNewUser(@RequestBody AddUserRequest addUserRequest){
        userService.addUser(addUserRequest);}

//    @ExceptionHandler({UserExistsException.class})
//    public ResponseEntity handleExeption(){
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
}
