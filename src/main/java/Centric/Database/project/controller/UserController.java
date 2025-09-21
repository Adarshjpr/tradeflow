package Centric.Database.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Centric.Database.project.Dto.UserDto;
import Centric.Database.project.service.implService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
@PostMapping()
    public ResponseEntity<UserDto> userPost( @RequestBody UserDto userDto){


        
        return userService.createUser(userDto) ;
    }





}
