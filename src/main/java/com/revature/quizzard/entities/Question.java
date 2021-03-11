package com.revature.quizzard.entities;

import javax.persistence.*;

@Entity @Table(name = "questions")
public class Question {

    @Id @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Embedded
    private Answers questionAnswers;

    public Question() {
        super();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Answers getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Answers questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    @Embeddable
    public static class Answers {

        @Column(name = "answer_a")
        private String answerA;

        @Column(name = "answer_b")
        private String answerB;

        @Column(name = "answer_c")
        private String answerC;

        @Column(name = "answer_d")
        private String answerD;

        public String getAnswerA() {
            return answerA;
        }

        public void setAnswerA(String answerA) {
            this.answerA = answerA;
        }

        public String getAnswerB() {
            return answerB;
        }

        public void setAnswerB(String answerB) {
            this.answerB = answerB;
        }

        public String getAnswerC() {
            return answerC;
        }

        public void setAnswerC(String answerC) {
            this.answerC = answerC;
        }

        public String getAnswerD() {
            return answerD;
        }

        public void setAnswerD(String answerD) {
            this.answerD = answerD;
        }
    }

}
