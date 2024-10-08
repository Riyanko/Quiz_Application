package com.rio.quiz_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rio.quiz_app.controller.exceptionhandling.QuestionNotFoundException;
import com.rio.quiz_app.dao.QuestionRepository;
import com.rio.quiz_app.entity.Question;

@Service
public class ServiceQuestionImpl implements ServiceQuestion{
	@Autowired
	QuestionRepository questionRepo;
	
	@Override
	public List<Question> getAllQuestions() {
		List<Question> findAllques = questionRepo.findAll();
		return findAllques;
	}

	@Override
	public List<Question> getByCategory(String category) {
		List<Question> questions=questionRepo.findByCategory(category);
		return questions;
	}

	@Override
	public void addNewQuestion(Question question) {
		questionRepo.save(question);
	}

	@Override
	public void deleteQuestion(int id) {
		questionRepo.
		findById(id)
		.orElseThrow(()->new QuestionNotFoundException("Question with "+id+" does'nt exists!!"));
		questionRepo.deleteById(id);
		
	}

	@Override
	public Question updateQuestion(Question question) {
		int id=question.getId();
		questionRepo
				.findById(id)
				.orElseThrow(()->new QuestionNotFoundException("Question with "+id+" does'nt exists!!"));
		Question questionUpdated=questionRepo.save(question);
		return questionUpdated;
	}

	

}
