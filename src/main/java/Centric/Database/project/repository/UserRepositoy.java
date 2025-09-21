package Centric.Database.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Centric.Database.project.model.User;

public interface UserRepositoy  extends JpaRepository<User ,Long> {

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail  (@Param("email") String email);

}
