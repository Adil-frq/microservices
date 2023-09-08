package com.microservices.service;

import com.microservices.dto.request.HotelRequest;
import com.microservices.dto.response.HotelResponse;
import com.microservices.exception.HotelException;

import java.util.List;

public class HotelServiceImpl implements HotelService{
    @Override
    public HotelResponse saveHotel(HotelRequest request) throws HotelException {
        return null;
    }

    @Override
    public HotelResponse getHotelById(String id) throws HotelException {
        return null;
    }

    @Override
    public List<HotelResponse> getAllHotel() throws HotelException {
        return null;
    }
}
