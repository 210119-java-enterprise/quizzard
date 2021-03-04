package com.revature.quizzard.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "flashcards")
public class Flashcard {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne @JoinColumn
    private User creator;

    public Flashcard() {
        super();
    }

    public Flashcard(String question, String answer) {
        this.id = 0;
        this.question = (question != null) ? question : "";
        this.answer = (answer != null) ? answer : "";
        this.category = Category.OTHER;
    }

    public Flashcard(String question, String answer, Category category) {
        this(question, answer);
        this.category = (category != null) ? category : Category.OTHER;
    }

    public Flashcard(int id, String question, String answer, Category category) {
        this(question, answer);
        this.id = id;
        this.category = (category != null) ? category : Category.OTHER;
    }

    public Flashcard(int id, String question, String answer, Category category, User creator) {
        this(id, question, answer, category);
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if (question == null) return;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (answer == null) return;
        this.answer = answer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) return;
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return id == flashcard.id &&
                Objects.equals(question, flashcard.question) &&
                Objects.equals(answer, flashcard.answer) &&
                category == flashcard.category &&
                Objects.equals(creator, flashcard.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, category, creator);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category=" + category +
                ", creator=" + creator +
                '}';
    }

}
