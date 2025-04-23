package vn.hoa.spring7_8_pathvaliables.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.hoa.spring7_8_pathvaliables.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    // bat loi tat ca then return sutudentexception
//    @ExceptionHandler
//    public
//    ResponseEntity<ErrorResponse> batLoi(StudentException SE){
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), SE.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }

    // bat tat ca cac loi
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> batLoi(Exception SE){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), SE.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
