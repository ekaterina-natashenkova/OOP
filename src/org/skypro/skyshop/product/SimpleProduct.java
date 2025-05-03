package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private double priceProduct;

    public SimpleProduct(String titleProduct, double priceProduct) {
        super(titleProduct);
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