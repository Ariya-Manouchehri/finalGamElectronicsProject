package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

public class UpdateOrderException extends RuntimeException {
    public UpdateOrderException() {
        super("عملیات اپدیت سفارش با خطا مواجه شد");
    }
}
