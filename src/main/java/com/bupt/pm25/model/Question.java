package com.bupt.pm25.model;

import java.util.List;

/**
 * Created by katiemi on 2018/1/22.
 */
public class Question {
   private String question;
    private List<String> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
