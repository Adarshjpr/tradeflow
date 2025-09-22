package Centric.Database.project.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import Centric.Database.project.exception.custom.emailNotExsit;
import Centric.Database.project.exception.custom.studentExist;

@ControllerAdvice
public class globalException {


    @ExceptionHandler(studentExist.class)
    public ResponseEntity <?> handleStudEntity(studentExist ex){

 Map <String , Object>  messMap = new HashMap<>();
  messMap.put("error ", ex.getMessage());
  messMap.put("status", 302);

        return ResponseEntity.status(HttpStatus.FOUND).body(messMap);
    }

      @ExceptionHandler(emailNotExsit.class)
    public ResponseEntity <?> handleStudEntity(emailNotExsit ex){

 Map <String , Object>  messMap = new HashMap<>();
  messMap.put("error ", ex.getMessage());
  messMap.put("status", 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messMap);
    }


@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<Map<String, Object>> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {

    Map<String, Object> messMap = new HashMap<>();
    messMap.put("error", ex.getMessage());
    messMap.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
    messMap.put("timestamp", LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(messMap);
}

}
