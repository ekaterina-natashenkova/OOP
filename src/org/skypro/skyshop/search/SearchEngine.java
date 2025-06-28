package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;
import java.lang.Comparable;
import java.util.HashSet;
import java.util.Set; // почему нельзя импортировать только Set, ведь он по иерархии "выше" чем HashSet и TreeSet, но при импорте только Set то код не компилируется
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public class SearchEngine {

//Для тестирования:
//Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
//Создайте несколько объектов типа Article и добавьте их в Search Engine
//Продемонстрируйте функциональность поиска с помощью объекта SearchEngine: вызовите метод search несколько раз с разными строками поиска.

    private Set<Searchable> searchableObjects;
    private int count;

    public SearchEngine() {
        this.searchableObjects = new HashSet<>();
        count = 0;
    }

    public void add(Searchable object) {
        Set<Searchable> searchableObjects = new HashSet<>();
        searchableObjects.add(object);
        System.out.println("Продукт добавлен в поиск");
        count++;
    }

    public Set<Searchable> search(String searchObject) throws BestResultNotFound {
        Set<Searchable> resultsSearch = searchableObjects.stream()
                .filter(object -> searchableObjects.iterator().equals(searchObject))
                .collect(Collectors.toCollection(() -> new TreeSet<>((s1, s2) -> { // компаратор хочется как-то "ужать"...
                    int searchCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
                    if (searchCompare == 0) {
                        return s1.getSearchTerm().compareTo(s2.getSearchTerm());
                    }
                    return searchCompare;
                })));
        if (resultsSearch.isEmpty()) {
            throw new BestResultNotFound("Нет соответствующих запросу элементов");
        }
        return resultsSearch;
    }

    // поиск самого подходящего элемента к поисковой строке
    public Searchable searchElement(String searchElements) throws BestResultNotFound {
        Searchable bestResultSearch = null;
        int found = 0;
        for (Searchable object : searchableObjects) {
            if (object != null) {
                int maxFound = maxReplay(object.getSearchTerm(), searchElements);
                if (maxFound > found) {
                    String stringSearch = object.getSearchTerm().toLowerCase();
                    String substring = searchElements.toLowerCase();
                    maxFound = maxReplay(stringSearch, substring);
                    found = maxFound;
                    bestResultSearch = object;
                }
            }
        }
        if (found == 0) {
            throw new BestResultNotFound("Нет соответствующего запросу элемента");
        }
        return bestResultSearch;
    }

    private int maxReplay(String stringSearch, String substring) {
        int maxFound = 0;
        int index = 0;
        int indexSubstring = stringSearch.indexOf(substring, index);
        while (indexSubstring != -1) {
            maxFound++;
            index = indexSubstring + substring.length();
            indexSubstring = stringSearch.indexOf(substring, index);
        }
        return maxFound;
    }

    //тестовая печать содержимого поисковика
    public void printSearchEngine() {
        for (Searchable searchable : searchableObjects) {
            System.out.println(searchable);
        }
    }

}