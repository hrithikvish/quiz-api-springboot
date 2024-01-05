package com.hrithikvish.springbootquizapp.service;

import com.hrithikvish.springbootquizapp.dao.QuestionDAO;
import com.hrithikvish.springbootquizapp.dao.QuizDAO;
import com.hrithikvish.springbootquizapp.model.Question;
import com.hrithikvish.springbootquizapp.model.QuestionLite;
import com.hrithikvish.springbootquizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String cat, int num, String title) {

        List<Question> questions = questionDAO.getRandomQuestionsByCategory(cat, num);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);

        return new ResponseEntity<>("Quiz Created Successfully!", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionLite>> getQuiz(int id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionLite> questionForQuiz = new ArrayList<>();

        for(Question q : questionFromDB) {
            questionForQuiz.add(new QuestionLite(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()));
        }

        return new ResponseEntity<>(questionForQuiz, HttpStatus.OK);
    }
}