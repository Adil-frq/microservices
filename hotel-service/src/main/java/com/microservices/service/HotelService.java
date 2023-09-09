package com.microservices.service;

import com.microservices.dto.request.HotelRequest;
import com.microservices.dto.response.HotelResponse;
import com.microservices.exception.HotelException;

import java.util.List;

public interface HotelService {
    public HotelResponse saveHotel(HotelRequest request) throws HotelException;
    public HotelResponse getHotelById(String id) throws HotelException;
    public List<HotelResponse> getAllHotel() throws HotelException;
}
