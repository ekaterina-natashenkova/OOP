package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {

    private String titleProduct;
    private int priceProduct;

    public Product(String titleProduct, int priceProduct) {
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return titleProduct + ": " + priceProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return priceProduct == product.priceProduct && Objects.equals(titleProduct, product.titleProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleProduct, priceProduct);
    }

}