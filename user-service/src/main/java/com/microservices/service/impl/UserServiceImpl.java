package com.microservices.service.impl;

import com.microservices.dto.request.UserRequest;
import com.microservices.dto.response.UserResponse;
import com.microservices.entity.User;
import com.microservices.exception.UserException;
import com.microservices.model.Hotel;
import com.microservices.model.Ratings;
import com.microservices.repository.UserRepository;
import com.microservices.service.UserService;
import com.microservices.util.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserResponse saveUser(UserRequest request) throws UserException {
        User user = Convertor.dtoToEntity(request);

        user.setUserId(UUID.randomUUID().toString());
        User savedUser = userRepository.save(user);
        return Convertor.entityToDto(savedUser);
    }

    @Override
    public UserResponse getUserById(String id) throws UserException {
        Optional<User> user = userRepository.findById(id);
        List<Ratings> ratingsList = null;
        List<Hotel> hotels = new ArrayList<>();
        user.orElseThrow(() -> new UserException("User is not found by this id " + id));
        if (user.isPresent()) {
            //call the rating service for get the ratings
            final UserResponse userResponse;
            log.info("UserServiceImpl->getUserById->Before calling the rating service");

            ResponseEntity<List<Ratings>> ratingsListResponse = restTemplate.exchange("http://localhost:8083/api/rating/user/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ratings>>() {
            });
            ratingsList = ratingsListResponse.getBody();
            log.info("UserServiceImpl->getUserById-> {}", ratingsList);
            userResponse = Convertor.entityToDto(user.get());
            userResponse.setRatings(ratingsList);

            //getting hotels by hotels id from ratings
            /*ratingsList.stream()
                    .map(rating -> {
                        System.out.println(rating.getRatingId());
                       *//* log.info("inside map");
                        ResponseEntity<Hotel> hotel = restTemplate.exchange("http://localhost:8082/api/hotel/" + rating.getHotelId(), HttpMethod.GET, null, new ParameterizedTypeReference<Hotel>() {
                        });
                        log.info("hotel under map {}",hotel.getBody());
                        userResponse.setHotel(hotel.getBody());
                        *//*
                        return null;
                    });*/
            ratingsList.forEach(rating->{
                ResponseEntity<Hotel> hotel = restTemplate.exchange("http://localhost:8082/api/hotel/" + rating.getHotelId(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Hotel>() {});
                                hotels.add(hotel.getBody());
                                userResponse.setHotels(hotels);
                    }
            );

            return userResponse;
        }
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() throws UserException {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            throw new UserException("NO record found in database");
        return Convertor.entityToDto(users);
    }
}
