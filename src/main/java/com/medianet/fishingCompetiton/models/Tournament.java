package com.medianet.fishingCompetiton.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Column(name ="registration_deadline")
    private Time registrationDeadLine;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @OneToMany(mappedBy = "tournament")
    List<Registration> registrations;

    @OneToMany(mappedBy = "tournament")
    List<Registration> round;


    public Tournament(String name, String description, Time registrationDeadLine, Date startDate, Date finishDate) {
        this.name = name;
        this.description = description;
        this.registrationDeadLine = registrationDeadLine;
        this.startDate = startDate;
        this.finishDate = finishDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getRegistrationDeadLine() {
        return registrationDeadLine;
    }

    public void setRegistrationDeadLine(Time registrationDeadLine) {
        this.registrationDeadLine = registrationDeadLine;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
