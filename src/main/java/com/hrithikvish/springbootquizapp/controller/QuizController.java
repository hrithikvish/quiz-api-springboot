package com.hrithikvish.springbootquizapp.controller;

import com.hrithikvish.springbootquizapp.model.QuestionLite;
import com.hrithikvish.springbootquizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String cat, @RequestParam int num, @RequestParam String title) {
        return quizService.createQuiz(cat, num, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionLite>> getQuiz(@PathVariable int id) {
        return quizService.getQuiz(id);
    }

}
