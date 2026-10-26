package com.example.rdddemo.controller;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final SparkSession sparkSession;

    public MovieController(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @GetMapping("/filter")
    public List<Map<String, Object>> filterMovies(@RequestParam String keyword) {
        // 读取csv文件
        Dataset<Row> movies = sparkSession.read()
                .option("header", "true")
                .csv("hdfs://192.168.88.101:8020/test/movies.csv");

        // 过滤字段
        Dataset<Row> filteredMovies = movies.filter(movies.col("title").contains(keyword));

        // 匹配数据
        List<Map<String, Object>> movieList = filteredMovies.collectAsList().stream()
                .map(row -> {
                    Map<String, Object> movieMap = new HashMap<>();
                    movieMap.put("movieId", row.getAs("movieId"));
                    movieMap.put("title", row.getAs("title"));
                    movieMap.put("genres", row.getAs("genres"));
                    return movieMap;
                })
                .collect(Collectors.toList());

        return movieList;
    }
}
