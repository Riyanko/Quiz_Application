package com.rio.quiz_app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Question{
	/*@SequenceGenerator(
			name="question_sequence",
			sequenceName="question_sequence",
			allocationSize=1)*/
	@GeneratedValue(strategy= GenerationType.IDENTITY)//, generator = "question_sequence")
	@Id
	private Integer id;//ALTER TABLE Question MODIFY id INTEGER NOT NULL AUTO_INCREMENT;
	//@Column(name="question_title")
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	//@Column(name="right_answer")
	private String rightAnswer;
	//@Column(name="difficulty_level")
	private String difficultyLevel;
	private String category;
}
