package com.question.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.Entites.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getList() {
		return questionRepository.findAll();
	}

	@Override
	public Question get(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
	}

	@Override
	public Question delete(Long id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Question not found"));
		questionRepository.deleteById(id);
		return question;
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long Id) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(Id);
	}

}
