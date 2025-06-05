package org.skypro.skyshop.search;

import org.skypro.skyshop.article.Article;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {

    // ВОПРОС ??? принципиальная разница в том как сортировать через Integer.compare() или Integer.valueOf(),
    // т.е. int searchCompare = Integer.valueOf(s2.getSearchTerm())-Integer.valueOf(s1.getSearchTerm());
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int searchCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
        if(searchCompare == 0){
        return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
        return searchCompare;
    }

}
