package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private double basePriceProduct;
    private double percantPriceProduct;

    public DiscountedProduct(String titleProduct, double basePriceProduct, double percantPriceProduct) throws IllegalAccessException {
        super(titleProduct);
        if (basePriceProduct <= 0.0) {
            throw new IllegalAccessException("Введена некорректная цена продукта");  //  - должно быть строго больше 0
        }
        if (percantPriceProduct < 0.0 || percantPriceProduct > 100.0) {
            throw new IllegalAccessException("Введена некорректная скидка на продукт");  //  - должно быть в диапазоне 0-100 включительно
        }
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