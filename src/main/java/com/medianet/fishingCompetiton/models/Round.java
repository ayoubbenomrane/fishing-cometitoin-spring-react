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
    @ManyToOne
    @JoinColumn(name="tournament_id")
    Tournament tournament;
    @OneToMany(mappedBy ="round")
    private List<Record> records;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
