package com.microservices.repository;

import com.microservices.entity.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,String> {
    Optional<Rating> findByRatingId(String ratingId);

    Optional<Rating> findRatingByHotelId(String hotelId);

    Optional <List<Rating>> findRatingByUserId(String hotelId);
}
