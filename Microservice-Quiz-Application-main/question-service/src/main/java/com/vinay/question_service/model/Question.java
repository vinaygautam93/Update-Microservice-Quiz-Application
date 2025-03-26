package com.vinay.question_service.model;

import jakarta.persistence.*;

@Entity // Marks this class as a JPA entity
@Table(name = "question") // Maps this entity to the "question" table in the database
public class Question {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
    private Integer id; // Unique identifier for each question

    private String questionTitle; // The text of the question
    private String option1; // First answer option
    private String option2; // Second answer option
    private String option3; // Third answer option
    private String option4; // Fourth answer option
    private String rightAnswer; // Correct answer for the question
    private String difficultylevel; // Difficulty level of the question
    private String category; // Category of the question

    // No-argument constructor
    public Question() {
    }

    // Parameterized constructor
    public Question(Integer id, String questionTitle, String option1, String option2, String option3, String option4, String rightAnswer, String difficultylevel, String category) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.difficultylevel = difficultylevel;
        this.category = category;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
