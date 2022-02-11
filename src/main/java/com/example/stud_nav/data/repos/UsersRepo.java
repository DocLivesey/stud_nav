package com.example.stud_nav.data.repos;

import com.example.stud_nav.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<User, Long> {
}
