package com.rio.quiz_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rio.quiz_app.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
}
