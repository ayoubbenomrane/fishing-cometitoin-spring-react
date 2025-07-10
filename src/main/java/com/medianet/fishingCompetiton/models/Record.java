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

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="round_id")
    private Round round;

}
