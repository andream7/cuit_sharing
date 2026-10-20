package com.example.sparksqltest.demos.service;

import com.example.sparksqltest.demos.dao.MovieRating;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;
import static org.apache.spark.sql.functions.split;

@Component
public class MovieDataProcessor {


//    @Value("${spring.datasource.url}")
//    private String databaseUrl;
//
//    @Value("${spring.datasource.username}")
//    private String databaseUser;
//
//    @Value("${spring.datasource.password}")
//    private String databasePassword;


    public List<MovieRating> processMovieData(SparkSession spark) {


        String url = "jdbc:mysql://localhost:3306/one?useSSL=false&serverTimezone=UTC";

        String user = "root";
        String password = "204526771x";

        String driver = "com.mysql.cj.jdbc.Driver";

        Dataset<Row> movieRatingsData = spark.read()
                .format("jdbc")
                .option("url", url)
                .option("dbtable", "movie_ratings")
                .option("user", user)
                .option("password", password)
                .option("driver", driver)
                .load();

        // 显示 movie_ratings 表的数据
        System.out.println("=========movie_ratings==========");
        movieRatingsData.show();


        List<MovieRating> movieRatings = movieRatingsData.collectAsList().stream()
                .map(row -> new MovieRating(
                        row.getString(row.fieldIndex("genre")),
                        row.getString(row.fieldIndex("Gender")),
                        row.getDecimal(row.fieldIndex("rating")) // 直接获取 BigDecimal 类型的评分
                ))

                .collect(Collectors.toList());

        return movieRatings;
    }

}
