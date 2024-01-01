package ir.manouchehri.finalgamelectronicsproject.exceptions.UserException;

public class DeleteUserException extends RuntimeException {

    public DeleteUserException() {
        super("عملیات حذف کاربر با خطا مواجه شد");
    }
}
