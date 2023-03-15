package pl.onak.d.planner.mappers;

import org.springframework.stereotype.Component;
import pl.onak.d.planner.dto.CreateUserResponse;
import pl.onak.d.planner.entity.User;
@Component
public class UserMapper {

    public CreateUserResponse createUserResponse(User user){
        return CreateUserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
