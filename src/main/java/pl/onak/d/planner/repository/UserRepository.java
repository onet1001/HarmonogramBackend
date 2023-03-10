package pl.onak.d.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.onak.d.planner.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

}
