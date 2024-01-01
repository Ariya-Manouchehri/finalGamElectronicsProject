package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderException {
    @ExceptionHandler(value = AddOrderException.class)
    public ResponseEntity<Object> exception(AddOrderException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = UpdateOrderException.class)
    public ResponseEntity<Object> exception(UpdateOrderException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = DeleteOrderException.class)
    public ResponseEntity<Object> exception(DeleteOrderException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = FindOrderException.class)
    public ResponseEntity<Object> exception(FindOrderException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
}
