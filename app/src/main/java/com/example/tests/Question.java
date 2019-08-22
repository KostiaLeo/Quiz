package com.example.tests;

public class Question {

    private String[][] question_and_answer;
    private String[][] vars;

    public Question(String[][] question_and_answer, String[][] vars) {
        this.question_and_answer = question_and_answer;
        this.vars = vars;
    }

    public String[] questions() {
        String[] questions = new String[question_and_answer[0].length];
        for (int i = 0; i < question_and_answer[0].length; i++) {
            questions[i] = question_and_answer[0][i];
        }
        return questions;
    }

    public String[] correctAnswers() {
        String[] correctAnswers = new String[question_and_answer[1].length];
        for (int i = 0; i < question_and_answer[0].length; i++) {
            correctAnswers[i] = question_and_answer[1][i];
        }
        return correctAnswers;
    }

    public String[][] variants() {
        String[][] var = new String[vars.length][vars[0].length];
        for (int i = 0; i < vars.length; i++) {
            for (int j = 0; j < vars[0].length; j++) {
                var[i][j] = vars[i][j];
            }
        }
        return var;
    }

    public String getQuestions(int peep) {
        String question = questions()[peep];
        return question;
    }

    public String getVariant1(int peep) {
        String variant1 = variants()[peep][0];
        return variant1;
    }

    public String getVariant2(int peep) {
        String variant2 = variants()[peep][1];
        return variant2;
    }

    public String getVariant3(int peep) {
        String variant3 = variants()[peep][2];
        return variant3;
    }

    public String getVariant4(int peep) {
        String variant4 = variants()[peep][3];
        return variant4;
    }

    public String getCorrectAnswer(int peep) {
        String correctAnswer = correctAnswers()[peep];
        return correctAnswer;
    }
}