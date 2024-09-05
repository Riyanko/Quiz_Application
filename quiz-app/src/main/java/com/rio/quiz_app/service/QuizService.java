package com.rio.quiz_app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rio.quiz_app.dao.QuizDao;
import com.rio.quiz_app.entity.Question;

public interface QuizService {

	ResponseEntity<String> createQuiz(String category, int nQues, String title);
	List<Question> getQuizQuestions(int id);
	
}
