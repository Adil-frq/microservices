package com.microservices.controller;

import com.microservices.dto.request.HotelRequest;
import com.microservices.dto.response.HotelResponse;
import com.microservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @PostMapping
    public ResponseEntity<HotelResponse> saveHotel(@RequestBody HotelRequest request) {
        HotelResponse response = hotelService.saveHotel(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotelById(@PathVariable String id) {
        HotelResponse hotel = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotels() {
        List<HotelResponse> hotels = hotelService.getAllHotel();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }
}
