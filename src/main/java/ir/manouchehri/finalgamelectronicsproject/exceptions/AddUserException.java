package ir.manouchehri.finalgamelectronicsproject.exceptions;

public class AddUserException extends RuntimeException {

    public AddUserException() {
        super("عملیات افزودن کاربر با خطا مواجه شد");
    }
}
