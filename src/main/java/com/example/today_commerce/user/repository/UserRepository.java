package com.example.today_commerce.user.repository;

import com.example.today_commerce.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 사용자 Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
