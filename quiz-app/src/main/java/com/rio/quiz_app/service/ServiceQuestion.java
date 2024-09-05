package com.rio.quiz_app.service;

import java.util.List;
import com.rio.quiz_app.entity.Question;

public interface ServiceQuestion {
	List<Question> getAllQuestions();
	List<Question> getByCategory(String category);
	void addNewQuestion(Question question);
	
}
