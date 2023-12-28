package ir.manouchehri.finalgamelectronicsproject.exceptions;

public class DeleteUserException extends RuntimeException {

    public DeleteUserException() {
        super("عملیات حذف کاربر با خطا مواجه شد");
    }
}
