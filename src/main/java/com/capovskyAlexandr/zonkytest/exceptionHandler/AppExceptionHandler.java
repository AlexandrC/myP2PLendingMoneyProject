package com.capovskyAlexandr.zonkytest.exceptionHandler;
import com.capovskyAlexandr.zonkytest.exceptions.CustomerIsUnderAgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomerIsUnderAgeException.class})
    public ResponseEntity<ErrorMessage> handleCustomerIsUnderAgeException(RuntimeException exception){
        ErrorMessage errorMessage = new ErrorMessage("Customer is under age",exception.getMessage()
                ,HttpStatus.FORBIDDEN.value());
        return new ResponseEntity(errorMessage,HttpStatus.FORBIDDEN);
    }

}
