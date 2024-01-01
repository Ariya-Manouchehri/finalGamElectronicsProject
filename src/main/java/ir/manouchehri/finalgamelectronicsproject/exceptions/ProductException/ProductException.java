package ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException;

import ir.manouchehri.finalgamelectronicsproject.exceptions.UserException.AddUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.UserException.DeleteUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.UserException.FindUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.UserException.UpdateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductException {
    @ExceptionHandler(value = AddProductException.class)
    public ResponseEntity<Object> exception(AddProductException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = UpdateProductException.class)
    public ResponseEntity<Object> exception(UpdateProductException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = DeleteProductException.class)
    public ResponseEntity<Object> exception(DeleteProductException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = FindProductException.class)
    public ResponseEntity<Object> exception(FindProductException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
}
