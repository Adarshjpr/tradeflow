package Centric.Database.project.service.implService;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Centric.Database.project.Dto.UserDto;
import Centric.Database.project.Dto.patchUserDto;
import Centric.Database.project.exception.custom.emailNotExsit;
import Centric.Database.project.exception.custom.findByIdexception;
import Centric.Database.project.exception.custom.studentExist;
import Centric.Database.project.model.User;
import Centric.Database.project.repository.UserRepositoy;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepositoy userRepositoy;

 private  final Logger logger = LoggerFactory.getLogger(UserService.class);

    
     public ResponseEntity<UserDto>  createUser(UserDto userDto){


logger.info("  user email " + userDto.getEmail());



// Throw exception if user already exists
    userRepositoy.findByEmail(userDto.getEmail())
        .ifPresent(u -> { throw new studentExist(userDto.getEmail()); });


   

 User saveUser = User.builder().name(userDto.getName()).email(userDto.getEmail()).build();

  userRepositoy.save(saveUser);


  UserDto  dtoValue =  new UserDto(saveUser.getId(), saveUser.getName(), saveUser.getEmail());
 
   logger.debug(" student details " + dtoValue);
  
return  ResponseEntity.ok(dtoValue);




        
     }


  
 public ResponseEntity<UserDto> userSearch(String email) {
    User user = userRepositoy.findByEmail(email)
            .orElseThrow(() -> new emailNotExsit(email));

    UserDto dto = new UserDto(user.getId(), user.getName(), user.getEmail());
    logger.debug("Searched user: {}", dto);

    return ResponseEntity.ok(dto);
}



 public ResponseEntity<?> logout(Long id) {
     User user = userRepositoy.findById(id)
            .orElseThrow(() -> new findByIdexception(id));

           if (user.getId() != null) {
              userRepositoy.deleteById(id);
           }

             return ResponseEntity.ok().body( "  thanks of visiting"); 

 }



 public ResponseEntity<UserDto> patchUser(patchUserDto pUserDto , Long id) {

User userM = userRepositoy.findById(id)
            .orElseThrow(() -> new findByIdexception(id));

            //  if (userM.getId() !=null) {
            //      userM.setId(userDto.getId());
            //  }
             if (pUserDto.getName() != null) {
                 userM.setName(pUserDto.getName());
             }
             if (pUserDto.getEmail() !=null) {
                userM.setEmail(pUserDto.getEmail());
             }

             userRepositoy.save(userM);
       UserDto uDto = new UserDto(userM.getId(), userM.getName(), userM.getEmail());

             return  ResponseEntity.ok(uDto) ;

 

 }



}
