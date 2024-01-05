package com.hrithikvish.springbootquizapp.service;

import com.hrithikvish.springbootquizapp.model.Question;
import com.hrithikvish.springbootquizapp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public Optional<Question> getQuestionById(int id) {
        return questionDAO.findById(id);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDAO.save(question);
            return new ResponseEntity<>("Question Added Successfully!", HttpStatus.CREATED);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not added.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public String delQuestion(int id) {
        questionDAO.deleteById(id);
        return "Question Deleted Successfully!";
    }
}
