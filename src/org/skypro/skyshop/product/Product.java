package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

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
    public String getSearchTerm() {
        return getTitleProduct();
    }

    @Override
    public String getTypeContent() {
        return PRODUCT;
    }


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