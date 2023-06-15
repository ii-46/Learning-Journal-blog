package com.inthava.learningjournal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);


    @Modifying
    @Query("UPDATE User u SET u.password = :password  WHERE u.id = :id")
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    User findByUsername(String username);
}
