package com.medianet.fishingCompetiton.models;


import jakarta.persistence.*;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fish_count")
    private int fishCount;
    @Column(name="total_weight")
    private float totalWeight;

    private int score;
    private int ranking;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="round_id")
    private Round round;

    public Record(User user, Round round) {
        this.user = user;
        this.round = round;
        this.score=0;
        this.fishCount=0;
        this.ranking=0;
        this.totalWeight=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        this.fishCount = fishCount;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
