package com.vinay.question_service.dao;

import com.vinay.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    // Method to fetch questions based on category
    List<Question> findByCategory(String category);

    // Custom query to get a random set of question IDs for a given category
    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
