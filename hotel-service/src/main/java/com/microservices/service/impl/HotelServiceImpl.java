package com.microservices.service.impl;

import com.microservices.dto.request.HotelRequest;
import com.microservices.dto.response.HotelResponse;
import com.microservices.entity.Hotel;
import com.microservices.exception.HotelException;
import com.microservices.repository.HotelRepository;
import com.microservices.service.HotelService;
import com.microservices.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public HotelResponse saveHotel(HotelRequest request) throws HotelException {
        Hotel hotel = Convertor.dtoToEntity(request);
        hotel.setId(UUID.randomUUID().toString());
        Hotel savedHotel = hotelRepository.save(hotel);
        return Convertor.entityToDto(savedHotel);
    }

    @Override
    public HotelResponse getHotelById(String id) throws HotelException {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        hotel.orElseThrow(()->new HotelException("No hotel found for given id "+id));
        return Convertor.entityToDto(hotel.get());
    }

    @Override
    public List<HotelResponse> getAllHotel() throws HotelException {
        List<Hotel> hotels = hotelRepository.findAll();
        return Convertor.entityToDto(hotels);
    }
}
