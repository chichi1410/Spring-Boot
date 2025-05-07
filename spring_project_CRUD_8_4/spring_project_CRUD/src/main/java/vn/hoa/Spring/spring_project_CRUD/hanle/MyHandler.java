package vn.hoa.Spring.spring_project_CRUD.hanle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> checkALL(Exception ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value() , ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
