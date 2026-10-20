package com.example.demo.demos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
public class DataController {

    private final ConcurrentLinkedQueue<Double> ratingsQueue = new ConcurrentLinkedQueue<>();

    @PostMapping("/publishData")
    public ResponseEntity<?> publishData(@RequestBody String dataJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            RatingData data = mapper.readValue(dataJson, RatingData.class);

            ratingsQueue.add(data.getRating());
            System.out.println("Received Rating: " + data.getRating());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error in processing data: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getData")
    public ResponseEntity<List<Double>> getData() {
        return ResponseEntity.ok(new ArrayList<>(ratingsQueue));
    }
}


class RatingData {
    private double rating;

    // Getter 和 Setter 方法
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
