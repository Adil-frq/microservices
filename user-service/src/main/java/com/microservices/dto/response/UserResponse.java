package com.microservices.dto.response;

import com.microservices.model.Hotel;
import com.microservices.model.Ratings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse {
    private String userId;
    private String name;
    private String email;
    private String about;
    private List<Ratings> ratings;
    private List<Hotel> hotels;



}
