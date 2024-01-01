package ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException;

public class UpdateProductException extends RuntimeException {
    public UpdateProductException() {
        super("عملیات اپدیت محصول با خطا مواجه شد");
    }
}
