package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

public class FindOrderByProductIdException extends RuntimeException {

    public FindOrderByProductIdException() {
        super("سفارشی برای این محصول ثبت نشده است");
    }
}
