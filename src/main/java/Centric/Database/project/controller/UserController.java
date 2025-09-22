package Centric.Database.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Centric.Database.project.Dto.UserDto;
import Centric.Database.project.service.implService.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {


    private final UserService userService;
@PostMapping()
    public ResponseEntity<UserDto> userPost( @RequestBody UserDto userDto){
        log.info("Received request to create user: {}", userDto.getEmail());
        return userService.createUser(userDto) ;
    }

    
    
@GetMapping("/{email}")
public ResponseEntity<UserDto> getMethodName(@PathVariable String email) {
    log.info("Received request to search user by email: {}", email);
    return userService.userSearch(email);
}




}
