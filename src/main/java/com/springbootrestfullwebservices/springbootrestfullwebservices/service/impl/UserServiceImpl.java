package com.springbootrestfullwebservices.springbootrestfullwebservices.service.impl;

import com.springbootrestfullwebservices.springbootrestfullwebservices.dto.UserDto;
import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.User;
import com.springbootrestfullwebservices.springbootrestfullwebservices.exception.EmailAlreadyExistsException;
import com.springbootrestfullwebservices.springbootrestfullwebservices.exception.ResourceNotFoundException;
import com.springbootrestfullwebservices.springbootrestfullwebservices.repository.UserRepository;
import com.springbootrestfullwebservices.springbootrestfullwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    @Override
    public User createUser(UserDto userdto) {


        Optional<User> byMail = userRepository.findByMail(userdto.getMail());
        System.out.println(byMail.toString());
        if(byMail.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists for user");

        }

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        // convert UserDto into User JpaEntity
        User user =modelMapper.map(userdto,User.class);
        user.setId(uuid);
        return userRepository.save(user);
    }

    @Override
    public UserDto updateUser(UUID id,UserDto userdto) {
        //conver dto to entity
        User user = modelMapper.map(userdto, User.class);
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAddress(user.getAddress());
        return modelMapper.map(userRepository.save(existingUser),UserDto.class);
    }

    @Override
    public UserDto getUser(UUID userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user)-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepository.deleteById(userId);
    }
}
