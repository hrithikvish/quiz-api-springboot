package com.hrithikvish.springbootquizapp.dao;

import com.hrithikvish.springbootquizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM \"quiz-questions\" q WHERE q.category=:cat ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Question> getRandomQuestionsByCategory(String cat, int num);

}