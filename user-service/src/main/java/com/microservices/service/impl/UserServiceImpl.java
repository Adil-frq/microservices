package com.microservices.service.impl;

import com.microservices.dto.request.UserRequest;
import com.microservices.dto.request.UserResponse;
import com.microservices.entity.User;
import com.microservices.exception.UserException;
import com.microservices.repository.UserRepository;
import com.microservices.service.UserService;
import com.microservices.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

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
        user.orElseThrow(() -> new UserException("User is not found by this id " + id));
        return Convertor.entityToDto(user.get());
    }

    @Override
    public List<UserResponse> getAllUsers() throws UserException {
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            throw new UserException("NO record found in database");
        return Convertor.entityToDto(users);
    }
}
