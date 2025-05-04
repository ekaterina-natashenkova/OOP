package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private double basePriceProduct;
    private double percantPriceProduct;

    public DiscountedProduct(String titleProduct, double basePriceProduct, double percantPriceProduct) {
        super(titleProduct);
        this.basePriceProduct = basePriceProduct;
        this.percantPriceProduct = percantPriceProduct;
    }

    @Override
    public double getPriceProduct() {
        return basePriceProduct - (basePriceProduct * (percantPriceProduct / 100));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getTitleProduct() + ": " + getPriceProduct() + "(" + percantPriceProduct + " %)";
    }

}