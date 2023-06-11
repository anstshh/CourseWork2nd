package com.example.coursework2.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.coursework2.Exception.IncorrectAmountOfQuestions;
import com.example.coursework2.Model.Question;
import com.example.coursework2.Service.ExaminerService;
import com.example.coursework2.Service.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestions();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

}
