package org.skypro.skyshop.search;

public interface Searchable {

    String PRODUCT = "PRODUCT";
    String ARTICLE = "ARTICLE";

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getTypeContent();
    }

}