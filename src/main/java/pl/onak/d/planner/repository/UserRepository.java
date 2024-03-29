package pl.onak.d.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.onak.d.planner.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
