package com.medianet.fishingCompetiton.models;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "participation")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime time;

    private boolean confirmation;

    @ManyToOne
    @JoinColumn(name="tournament_id")
    Tournament tournament;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    public Registration( Tournament tournament, User user) {
        this.time = LocalDateTime.now();
        this.confirmation = false;
        this.tournament = tournament;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
