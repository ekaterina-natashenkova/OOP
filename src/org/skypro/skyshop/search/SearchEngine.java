package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.SearchComparator;

import java.util.Set;
import java.util.TreeSet; // почему тут вместо отдельно прописанных импортов коллекций появляется одна строка и символ * ???

public class SearchEngine {

//Метод search — принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву Searchable в виде массива из 5 элементов.
//Метод add() — добавляет новый объект типа Searchable в массив поискового движка.
// Замена объекта Searchable[] на List и соответствующая корректировка методов для работы с новой сущностью // замена на Мар // замена на Set

//Для тестирования:
//Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
//Создайте несколько объектов типа Article и добавьте их в Search Engine
//Продемонстрируйте функциональность поиска с помощью объекта SearchEngine: вызовите метод search несколько раз с разными строками поиска.

    private Set<Searchable> searchableObjects;
    private int count;

    public SearchEngine() {
        this.searchableObjects = new TreeSet<>();
        count = 0;
    }

    public void add(Searchable object) {
        searchableObjects.add(object);
        System.out.println("Продукт добавлен в поиск");
        count++;
    }

    public Set<Searchable> search(String searchObject) throws BestResultNotFound {
        Set<Searchable> resultsSearch = new TreeSet<>(new SearchComparator());
        for (Searchable object : searchableObjects) {
            if (object != null && object.getSearchTerm().contains(searchObject)) {
                resultsSearch.add(object);
            }
        }
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