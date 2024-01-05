package com.hrithikvish.springbootquizapp.controller;

import com.hrithikvish.springbootquizapp.model.Question;
import com.hrithikvish.springbootquizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions") //@RequestMapping(value="allQuestions", method=RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("{id}")
    public Optional<Question> getQuestion(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("del/{id}")
    public String delQuestion(@PathVariable int id) {
        return questionService.delQuestion(id);
    }

}
