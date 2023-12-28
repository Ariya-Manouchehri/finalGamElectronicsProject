package ir.manouchehri.finalgamelectronicsproject.exceptions;

public class FindUserException extends RuntimeException {

    public FindUserException() {
        super("کاربر مورد نظر یافت نشد");
    }
}
