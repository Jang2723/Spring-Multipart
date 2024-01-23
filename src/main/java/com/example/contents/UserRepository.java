package com.example.contents;

import com.example.contents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // User findByUsernameEquals(String username); // 위 아래 둘다 기능은 같지만 null 값 반환의 차이
    boolean existsByUsername(String username);

}
