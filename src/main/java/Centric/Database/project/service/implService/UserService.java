package Centric.Database.project.service.implService;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Centric.Database.project.Dto.UserDto;
import Centric.Database.project.exception.custom.studentExist;
import Centric.Database.project.model.User;
import Centric.Database.project.repository.UserRepositoy;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoy userRepositoy;

     public ResponseEntity<UserDto>  createUser(UserDto userDto){

User  valuedUser = new User();

// Throw exception if user already exists
    userRepositoy.findByEmail(userDto.getEmail())
        .ifPresent(u -> { throw new studentExist(userDto.getEmail()); });


   

 User saveUser = User.builder().name(userDto.getName()).email(userDto.getEmail()).build();

  userRepositoy.save(saveUser);


  UserDto  dtoValue =  new UserDto(valuedUser.getId(), valuedUser.getName(), valuedUser.getEmail());
 
   
return  ResponseEntity.ok(dtoValue);




        
     }


}
