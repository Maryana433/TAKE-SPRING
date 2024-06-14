package com.take.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "bucket")
@Entity
@Setter
@Getter
public class BucketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private FilmEntity film;

    @Column
    private LocalDateTime dateTime;

    @Column
    private int qty;

}
