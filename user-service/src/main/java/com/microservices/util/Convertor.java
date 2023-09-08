package com.microservices.util;

import com.microservices.dto.request.UserRequest;
import com.microservices.dto.request.UserResponse;
import com.microservices.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    public static UserResponse entityToDto(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .about(user.getAbout())
                .email(user.getEmail())
                .build();
    }


    public static User dtoToEntity(UserRequest request) {
        return User.builder()
                .userId(request.getUserId())
                .name(request.getName())
                .email(request.getEmail())
                .about(request.getAbout())
                .build();
    }

    public static List<UserResponse> entityToDto(List<User> users){
       return users.stream()
               .map(user-> entityToDto(user))
               .collect(Collectors.toList());
    }
}
