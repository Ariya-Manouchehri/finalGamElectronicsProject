package ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException;

public class AddProductException extends RuntimeException {

    public AddProductException() {
        super("عملیات افزودن محصول با خطا مواجه شد");
    }
}
