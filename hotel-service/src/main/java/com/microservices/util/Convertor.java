package com.microservices.util;

import com.microservices.dto.request.HotelRequest;
import com.microservices.dto.response.HotelResponse;
import com.microservices.entity.Hotel;
import org.apache.coyote.Response;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    public static Hotel dtoToEntity(HotelRequest request) {
        return Hotel.builder()
                .id(request.getId())
                .name(request.getName())
                .location(request.getLocation())
                .about(request.getAbout())
                .build();
    }

    public static HotelResponse entityToDto(Hotel hotel) {
        return HotelResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .about(hotel.getAbout())
                .location(hotel.getLocation())
                .build();
    }

    public static List<HotelResponse> entityToDto(List<Hotel> hotels) {
        return hotels.stream()
                .map(Convertor::entityToDto)
                .collect(Collectors.toList());
    }
}
