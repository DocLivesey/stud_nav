package com.example.stud_nav.data.repos;

import com.example.stud_nav.data.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {
    List<Course> findAllBySpeciality(String speciality);
}
