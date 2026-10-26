package com.example.sparksqltest.demos.dao;

import java.math.BigDecimal;

public class MovieRating {
    private String genre;
    private String gender;
    private BigDecimal averageRating;
    // MovieRating类有三个属性：genre（电影类型）、gender（性别）和averageRating（平均评分）
    public MovieRating(String genre, String gender, BigDecimal averageRating) {
        this.genre = genre;
        this.gender = gender;
        this.averageRating = averageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }
}


// MovieRating类用于封装从数据库中读取的电影评分数据。