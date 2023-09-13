package com.microservices.util;

import com.microservices.dto.request.RatingRequest;
import com.microservices.dto.response.RatingResponse;
import com.microservices.entity.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static RatingResponse entityToDto(Rating rating) {
        return RatingResponse.builder()
                .ratingId(rating.getRatingId())
                .userId(rating.getUserId())
                .hotelId(rating.getHotelId())
                .feedback(rating.getFeedback())
                .rating(rating.getRating())
                .build();
    }

    public static Rating dtoToEntity(RatingRequest request) {
        return Rating.builder()
                .userId(request.getUserId())
                .hotelId(request.getHotelId())
                .feedback(request.getFeedback())
                .rating(request.getRating())
                .build();
    }

    public static List<RatingResponse> entityToDto(List<Rating> ratings) {
        return ratings.stream()
                .map(Convertor::entityToDto)
                .collect(Collectors.toList());
    }
}
