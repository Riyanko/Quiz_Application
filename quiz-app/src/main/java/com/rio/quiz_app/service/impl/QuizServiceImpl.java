package com.rio.quiz_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rio.quiz_app.dao.QuestionRepository;
import com.rio.quiz_app.dao.QuizDao;
import com.rio.quiz_app.entity.Question;
import com.rio.quiz_app.entity.Quiz;
import com.rio.quiz_app.entity.Responsequiz;
import com.rio.quiz_app.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionRepository questionRepo;

	@Override
	public ResponseEntity<String> createQuiz(String category, int nQues, String title) {
		// TODO Auto-generated method stub
		List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,nQues);
		
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	@Override
	public List<Question> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		return questionsFromDB;
	}

	@Override
	public float calculateResult(Integer id, List<Responsequiz> responsequiz) {
		Quiz quiz=quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int size=questions.size();
		int i=0;
		int result=0;
		for(Responsequiz rq: responsequiz) {
			if(rq.getResponse().equals(questions.get(i).getRightAnswer())) {
				result++;
			}
			i++;
		}
		float percentage=(((float)result/(float)size)*100);
		return percentage;
	}
	
	
}
