package com.springbootrestfullwebservices.springbootrestfullwebservices.service;

import com.springbootrestfullwebservices.springbootrestfullwebservices.dto.UserDto;
import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public User createUser(UserDto userdto);

    public UserDto updateUser(UUID id,UserDto userdto);

    UserDto getUser(UUID userId);

    List<UserDto> getAllUsers();

    void deleteUser(UUID id);
}
