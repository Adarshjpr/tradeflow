package Centric.Database.project.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import Centric.Database.project.exception.custom.studentExist;

@ControllerAdvice
public class globalException {


    @ExceptionHandler(studentExist.class)
    public ResponseEntity <?> handleStudEntity(studentExist ex){

 Map <String , Object>  messMap = new HashMap<>();
  messMap.put("error ", ex.getMessage());
  messMap.put("status", 404);

        return ResponseEntity.status(HttpStatus.FOUND).body(messMap);
    }

}
