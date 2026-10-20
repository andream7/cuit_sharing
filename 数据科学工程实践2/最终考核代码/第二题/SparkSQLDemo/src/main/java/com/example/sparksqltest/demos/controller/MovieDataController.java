package com.example.sparksqltest.demos.controller;

import com.example.sparksqltest.demos.dao.MovieRating;
import com.example.sparksqltest.demos.service.MovieDataProcessor;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

@RequestMapping("/api/movies")

public class MovieDataController {

    @Autowired
    private MovieDataProcessor movieDataProcessor;

    @Autowired
    private SparkSession sparkSession;

    @GetMapping("/ratings")
    public List<MovieRating> getMovieRatings() {
        return movieDataProcessor.processMovieData(sparkSession);
    }

}
