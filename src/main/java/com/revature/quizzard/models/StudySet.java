package com.revature.quizzard.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "study_sets")
public class StudySet {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne @JoinColumn
    private User owner;

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "study_set_id"),
        inverseJoinColumns = @JoinColumn(name = "flashcard_id")
    )
    private List<Flashcard> studySetCards;

    public StudySet() {
        super();
    }

    public StudySet(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public StudySet(int id, String name, User owner, List<Flashcard> studySetCards) {
        this(name, owner);
        this.id = id;
        this.studySetCards = studySetCards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Flashcard> getStudySetCards() {
        return studySetCards;
    }

    public void setStudySetCards(List<Flashcard> studySetCards) {
        this.studySetCards = studySetCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudySet studySet = (StudySet) o;
        return id == studySet.id &&
                Objects.equals(name, studySet.name) &&
                Objects.equals(owner, studySet.owner) &&
                Objects.equals(studySetCards, studySet.studySetCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, studySetCards);
    }

    @Override
    public String toString() {
        return "StudySet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", studySetCards=" + studySetCards +
                '}';
    }

}
