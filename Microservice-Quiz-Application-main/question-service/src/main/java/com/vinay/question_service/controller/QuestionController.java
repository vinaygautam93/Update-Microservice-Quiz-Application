package com.vinay.question_service.controller;

import com.vinay.question_service.model.Question;
import com.vinay.question_service.model.QuestionWrapper;
import com.vinay.question_service.model.Response;
import com.vinay.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller to handle HTTP requests
@RequestMapping("question") // Base URL for all endpoints in this controller
public class QuestionController {

    @Autowired
    QuestionService questionService; // Injecting QuestionService to handle business logic

    @GetMapping("allQuestions") // API to fetch all questions
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}") // API to fetch questions by category
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add") // API to add a new question
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @GetMapping("generate") // API to generate a quiz based on category and number of questions
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions") // API to fetch questions by their IDs
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore") // API to calculate the score based on user responses
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }
}
