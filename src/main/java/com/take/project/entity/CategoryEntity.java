package com.take.project.entity;

import com.take.project.model.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_name")
    @Enumerated(EnumType.STRING)
    private Category categoryName;

    @OneToMany(mappedBy = "category")
    private List<FilmEntity> films;
}
