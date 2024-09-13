package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Entites.Question;
import com.question.services.QuestionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/question")
public class QuiestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	
	@PostMapping("/")
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable Long questionId) {
		return questionService.get(questionId);
	}
	@GetMapping("/")
	public List<Question> getQuestionList() {
		return questionService.getList();
	}
	@DeleteMapping("/{questionId}")
	public Question delete(@PathVariable Long questionId) {
		return questionService.delete(questionId);
		
	}
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsByQuizId(@PathVariable Long quizId){
		List<Question> questions = questionService.getQuestionOfQuiz(quizId);
		return questions;
		
	}
}
