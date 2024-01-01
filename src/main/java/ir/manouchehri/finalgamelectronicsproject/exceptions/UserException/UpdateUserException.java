package ir.manouchehri.finalgamelectronicsproject.exceptions.UserException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UpdateUserException extends RuntimeException {
    public UpdateUserException() {
        super("عملیات اپدیت کاربر با خطا مواجه شد");
    }
}
