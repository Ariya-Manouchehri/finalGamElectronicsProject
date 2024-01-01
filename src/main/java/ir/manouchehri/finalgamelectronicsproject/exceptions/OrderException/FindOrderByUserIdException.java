package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

public class FindOrderByUserIdException extends RuntimeException {

    public FindOrderByUserIdException() {
        super("سفارشی برای این کاربر ثبت نشده است");
    }
}
