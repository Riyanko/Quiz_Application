package com.rio.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rio.quiz_app.entity.Question;
import com.rio.quiz_app.entity.Responsequiz;
import com.rio.quiz_app.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	
	@PostMapping("/create")
	public ResponseEntity<String> CreateQuiz(@RequestParam String category,@RequestParam int nQues,@RequestParam String title){
		return quizService.createQuiz(category,nQues,title);
	}
	
	@GetMapping("/getQuiz/{id}")
	public List<Question> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public String SubmitQuiz(@PathVariable Integer id,@RequestBody List<Responsequiz> responsequiz ) {
		float result=quizService.calculateResult(id,responsequiz);
		return result+"% Scored";
	}
}
