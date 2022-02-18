package com.example.stud_nav.data.repos;

import com.example.stud_nav.data.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepo extends JpaRepository<News,Long> {

    Page<News> findAll(Pageable pageable);
}
