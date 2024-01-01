package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

public class AddOrderException extends RuntimeException {

    public AddOrderException() {
        super("عملیات افزودن سفارش با خطا مواجه شد");
    }
}
