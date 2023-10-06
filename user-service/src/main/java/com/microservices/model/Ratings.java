package com.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ratings {
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rating;

    private String feedback;
}
