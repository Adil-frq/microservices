package com.microservices.service.impl;

import com.microservices.dto.request.RatingRequest;
import com.microservices.dto.response.RatingResponse;
import com.microservices.entity.Rating;
import com.microservices.exception.RatingException;
import com.microservices.repository.RatingRepository;
import com.microservices.service.RatingService;
import com.microservices.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public RatingResponse saveRating(RatingRequest request) throws RatingException {

        Rating rating = Convertor.dtoToEntity(request);
        rating.setRatingId(UUID.randomUUID().toString());
        Rating savedRating = ratingRepository.save(rating);
        return Convertor.entityToDto(savedRating);
    }

    @Override
    public RatingResponse getRatingByRatingId(String ratingId) throws RatingException {
        Optional<Rating> rating = ratingRepository.findByRatingId(ratingId);
        rating.orElseThrow(()->new RatingException("Record not found by  given rating id "+ratingId));
        return Convertor.entityToDto(rating.get());
    }

    @Override
    public RatingResponse getRatingByHotelId(String hotelId) throws RatingException {
        Optional<Rating> rating = ratingRepository.findRatingByHotelId(hotelId);
        rating.orElseThrow(()->new RatingException("Record not found by given hotel id "+hotelId));
        return Convertor.entityToDto(rating.get());
    }

    @Override
    public List<RatingResponse> getRatingByUserId(String userId) throws RatingException {
        Optional<List<Rating>> rating = ratingRepository.findRatingByUserId(userId);
        rating.orElseThrow(()->new RatingException("Record not found by given hotel id "+userId));
        List<RatingResponse> ratingResponses = Convertor.entityToDto(rating.get());
        return ratingResponses;
    }

    @Override
    public List<RatingResponse> getAllRating() throws RatingException {
        List<Rating> ratings = ratingRepository.findAll();
        if(ratings.isEmpty())
            throw new RatingException("No record found");
        return Convertor.entityToDto(ratings);
    }
}
