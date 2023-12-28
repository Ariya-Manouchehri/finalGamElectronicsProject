package ir.manouchehri.finalgamelectronicsproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UpdateUserException extends RuntimeException {
    public UpdateUserException() {
        super("عملیات اپدیت با خطا مواجه شد");
    }
}
