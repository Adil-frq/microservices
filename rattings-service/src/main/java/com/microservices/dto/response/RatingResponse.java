package com.microservices.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingResponse {
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rating;
    private String feedback;
}
