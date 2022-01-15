package com.example.emailfirstverification.repository;

import com.example.emailfirstverification.entity.Users;
import com.example.emailfirstverification.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(Users user);
}
