package com.springbootrestfullwebservices.springbootrestfullwebservices.controller;

import com.springbootrestfullwebservices.springbootrestfullwebservices.dto.UserDto;
import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.User;
import com.springbootrestfullwebservices.springbootrestfullwebservices.exception.ErrorDetails;
import com.springbootrestfullwebservices.springbootrestfullwebservices.exception.ResourceNotFoundException;
import com.springbootrestfullwebservices.springbootrestfullwebservices.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping("{userid}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userid") UUID userId){
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userdto){
        System.out.println(userdto);
        // conver userDTO into user entity
        User savedUser = userService.createUser(userdto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") UUID id,@RequestBody @Valid UserDto userdto){
        UserDto updatedUser = userService.updateUser(id,userdto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //Spring boot rest api that handles HTTP DELETE request

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable("id") UUID userID){
        userService.deleteUser(userID);
        System.out.println("studentID "+userID);
        return "Student deleted successfully"+userID;
    }


//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> HandleResouceNotFoundException(ResourceNotFoundException exception,
//                                                                       WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//                return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }


}
