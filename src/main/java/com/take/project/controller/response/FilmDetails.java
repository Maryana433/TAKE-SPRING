package com.take.project.controller.response;

import lombok.Data;

@Data
public class FilmDetails {
    private long id;
    private String title;
    private int yearOfProduction;
    private double cost;
    private String category;
    private String plot;
}
