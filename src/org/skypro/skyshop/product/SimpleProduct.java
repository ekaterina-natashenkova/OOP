package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private double priceProduct;

    public SimpleProduct(String titleProduct, double priceProduct) throws IllegalAccessException {
        super(titleProduct);
        if (priceProduct <= 0.0) {
            throw new IllegalAccessException("Введена некорректная цена продукта");  //  - должно быть строго больше 0
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public double getPriceProduct() {
        return priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getTitleProduct() + ": " + priceProduct;
    }

}