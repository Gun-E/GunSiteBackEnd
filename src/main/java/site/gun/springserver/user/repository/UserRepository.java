package site.gun.springserver.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import site.gun.springserver.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailOrPhone(String email, String phone);
    boolean existsUserByEmailLike(String userEmail);
}
