package com.take.project.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bucket {

    private long id;
    private Film film;
    private String dateTime;
    private int qty;
    private double price;
}
