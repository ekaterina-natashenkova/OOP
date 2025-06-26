package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {

    private String titleArticle;
    private String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }


    @Override
    public String getSearchTerm() {
        return getTitleArticle();
    }

    @Override
    public String getTypeContent() {
        return ARTICLE;
    }


    @Override
    public String toString() {
        return titleArticle + " - " + textArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleArticle);
    }


}
