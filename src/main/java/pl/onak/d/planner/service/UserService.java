package pl.onak.d.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.onak.d.planner.dto.CreateUserRequest;
import pl.onak.d.planner.dto.CreateUserResponse;
import pl.onak.d.planner.exeption.UserExistsException;
import pl.onak.d.planner.repository.UserRepository;
import pl.onak.d.planner.entity.User;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(CreateUserRequest createUserRequest) {
        String email = createUserRequest.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new UserExistsException(String.format("User with email %s already exists", email));
        }
        User user = User.builder()
                .name(createUserRequest.getName())
                .email(createUserRequest.getEmail())
                .build();
        userRepository.save(user);
        return user;
    }
}
