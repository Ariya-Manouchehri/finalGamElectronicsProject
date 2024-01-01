package ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException;

public class DeleteOrderException extends RuntimeException {

    public DeleteOrderException() {
        super("عملیات حذف سفارش با خطا مواجه شد");
    }
}
