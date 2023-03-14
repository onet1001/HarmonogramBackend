package pl.onak.d.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.onak.d.planner.dto.AddUserRequest;
import pl.onak.d.planner.exeption.UserExistsException;
import pl.onak.d.planner.repository.UserRepository;
import pl.onak.d.planner.entity.User;

import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(AddUserRequest addUserRequest) {
        String email = addUserRequest.getEmail();
        Optional<User> workerByEmail = userRepository.findUserByEmail(email);
        if (workerByEmail.isPresent()){
            throw new UserExistsException(String.format("User with email %s already exists", email));
        }
        User user = User.builder()
                .name(addUserRequest.getName())
                .email(addUserRequest.getEmail())
                .build();
        userRepository.save(user);
        return user;
    }
}
