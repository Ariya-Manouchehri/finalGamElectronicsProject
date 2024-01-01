package ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException;

public class DeleteProductException extends RuntimeException {

    public DeleteProductException() {
        super("عملیات حذف محصول با خطا مواجه شد");
    }
}
