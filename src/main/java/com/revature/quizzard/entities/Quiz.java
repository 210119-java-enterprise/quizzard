package com.revature.quizzard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Quiz {

    @Id @Column
    private int id;

}
