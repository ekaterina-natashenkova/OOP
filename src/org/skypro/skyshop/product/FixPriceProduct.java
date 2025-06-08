package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final double FIX_PRICE_PRODUCT = 50;

    public FixPriceProduct(String titleProduct) throws IllegalAccessException {
        super(titleProduct);
    }

    @Override
    public double getPriceProduct() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getTitleProduct() + ": Фиксированная цена " + FIX_PRICE_PRODUCT;
    }


}
