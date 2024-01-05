package com.hrithikvish.springbootquizapp.dao;

import com.hrithikvish.springbootquizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
