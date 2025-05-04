package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {

    private String titleProduct;

    public Product(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public abstract double getPriceProduct();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return titleProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(titleProduct, product.titleProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleProduct);
    }

}