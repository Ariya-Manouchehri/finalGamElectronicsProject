package ir.manouchehri.finalgamelectronicsproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {
    @ExceptionHandler(value = AddUserException.class)
    public ResponseEntity<Object> exception(AddUserException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = UpdateUserException.class)
    public ResponseEntity<Object> exception(UpdateUserException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = DeleteUserException.class)
    public ResponseEntity<Object> exception(DeleteUserException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = FindUserException.class)
    public ResponseEntity<Object> exception(FindUserException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
}
