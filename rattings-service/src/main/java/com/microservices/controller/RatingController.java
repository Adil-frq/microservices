package com.microservices.controller;

import com.microservices.dto.request.RatingRequest;
import com.microservices.dto.response.RatingResponse;
import com.microservices.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<RatingResponse> saveRatings(@RequestBody RatingRequest request) {
        RatingResponse response = ratingService.saveRating(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingResponse> getRatingByRatingId(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.getRatingByRatingId(ratingId));
    }


    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<RatingResponse> getRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingResponse>> getRatingByUserId(@PathVariable String userId) {
         return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }
    @GetMapping
    public ResponseEntity<List<RatingResponse>> getAllRating() {

        return ResponseEntity.ok(ratingService.getAllRating());
    }
}
