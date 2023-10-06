package com.microservices.service;

import com.microservices.dto.request.UserRequest;
import com.microservices.dto.response.UserResponse;
import com.microservices.exception.UserException;

import java.util.List;

public interface UserService {
    public UserResponse saveUser(UserRequest request) throws UserException;

    public UserResponse getUserById(String id) throws UserException;

    public List<UserResponse> getAllUsers() throws UserException;
}


