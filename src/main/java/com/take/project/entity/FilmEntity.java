package com.take.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity(name = "film")
@Data
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column(name = "year_production")
    private int yearOfProduction;

    @Column
    private String plot;

    @Column
    private double cost;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private CategoryEntity category;
}
