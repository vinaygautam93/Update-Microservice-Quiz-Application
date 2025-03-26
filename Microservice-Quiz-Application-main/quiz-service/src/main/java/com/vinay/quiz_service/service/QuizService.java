package com.vinay.quiz_service.service;

import com.vinay.quiz_service.dao.QuizDao;
import com.vinay.quiz_service.feign.QuizInterface;
import com.vinay.quiz_service.model.QuestionWrapper;
import com.vinay.quiz_service.model.Quiz;
import com.vinay.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer>questions= quizInterface.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz>quizOptional = quizDao.findById(id);

       List<Integer>questionIds=quizOptional.get().getQuestionsIds();
       return quizInterface.getQuestionsFromId(questionIds);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer>score = quizInterface.getScore(responses);

        return score;
    }
}