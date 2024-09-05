package com.rio.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rio.quiz_app.controller.exceptionhandling.CategoryNotFoundException;
import com.rio.quiz_app.entity.Question;
import com.rio.quiz_app.service.ServiceQuestion;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	ServiceQuestion questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		List<Question> allQuestions = questionService.getAllQuestions();
		if(allQuestions==null) {
			throw new RuntimeException("No questions found");
		}
		return ResponseEntity.ok(allQuestions);
	}
	
	@GetMapping("/category/{category}")
	public List<Question> findByCategory(@PathVariable String category){
		
		List<Question> CategoryList = questionService.getByCategory(category);
		if(CategoryList.isEmpty()) {
			throw new CategoryNotFoundException("Questions of "+category+" Category not available!!");
		}
		return CategoryList;
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addNewQuestion(@RequestBody Question question) {
		questionService.addNewQuestion(question);
		return new ResponseEntity<>( "Added Successfully",HttpStatus.CREATED);
	}
}
