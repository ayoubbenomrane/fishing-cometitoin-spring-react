package com.medianet.fishingCompetiton.models;


import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "round")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date date;
    private String place;
    private Time duration;

    public Round(String name, Date date, String place, Time duration) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.duration = duration;
    }

    @OneToMany(mappedBy ="round")
    private List<Record> records;


}
