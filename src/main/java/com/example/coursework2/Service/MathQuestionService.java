package com.example.coursework2.Service;

import com.example.coursework2.Model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questions;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);
        return questions.add(quest);

    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return questions.add(question);

    }

    @Override
    public Question remove(Question question) {
        return questions.remove(question);

    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }


    @Override
    public Question getRandomQuestion() {
        int randoms = random.nextInt(questions.getAll().size());
        int i = 0;
        for (Question question : questions.getAll()) {
            if (i == randoms) {
                return question;
            }
            i++;
        }
        return null;
    }
}