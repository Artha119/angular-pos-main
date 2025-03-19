package com.artha.angular_pos_backend.repository;

import com.artha.angular_pos_backend.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser,String> {

    @Query(value = "SELECT * FROM application_user WHERE email = ?1 AND password = ?2", nativeQuery = true)
    Optional<ApplicationUser> login(String email,String password);

    @Query(value = "SELECT * FROM application_user WHERE email = ?1", nativeQuery = true)
    Optional<ApplicationUser> getByEmail(String email);
}
