package com.microservices.service;

import com.microservices.dto.request.RatingRequest;
import com.microservices.dto.response.RatingResponse;
import com.microservices.exception.RatingException;

import java.util.List;

public interface RatingService {
    public RatingResponse saveRating(RatingRequest request) throws RatingException;

    public RatingResponse getRatingByRatingId(String ratingId) throws RatingException;

    public RatingResponse getRatingByHotelId(String ratingId) throws RatingException;

    public RatingResponse getRatingByUserId(String ratingId) throws RatingException;

    public List<RatingResponse> getAllRating() throws RatingException;

}
