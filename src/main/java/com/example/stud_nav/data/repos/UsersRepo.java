package com.example.stud_nav.data.repos;

import com.example.stud_nav.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
