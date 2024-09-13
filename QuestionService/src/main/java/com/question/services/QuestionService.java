package com.question.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.Entites.Question;

@Service
public interface QuestionService {
	
	Question create(Question question);
	
	List<Question> getList();
	
	Question get(Long id);
	
	Question delete(Long id);
	
	List<Question> getQuestionOfQuiz(Long Id);

}
