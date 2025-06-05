package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

public class SearchEngine {

//Поле Searchable[] — массив всех элементов, по которым можно искать. Размерность массива нужно передавать через конструктор класса SearchEngine
//Метод search — принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву Searchable в виде массива из 5 элементов.
//Метод add() — добавляет новый объект типа Searchable в массив поискового движка.
// Замена объекта Searchable[] на List и соответствующая корректировка методов для работы с новой сущностью // замена на Мар

//Для тестирования:
//Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
//Создайте несколько объектов типа Article и добавьте их в Search Engine
//Продемонстрируйте функциональность поиска с помощью объекта SearchEngine: вызовите метод search несколько раз с разными строками поиска.

    private Map<String, Searchable> searchableObjects;
    private int count;

    public SearchEngine() {
        this.searchableObjects = new TreeMap<>();
        count = 0;
    }

    public void add(Searchable object) {
        Map<String, Searchable> searchableObjects = new TreeMap<>();
        searchableObjects.put(object.getSearchTerm(), object);
        System.out.println("Продукт добавлен в поиск");
        count++;
    }

    public Map<String, Searchable> search(String searchObject) throws BestResultNotFound {
        Map<String, Searchable> resultsSearch = new TreeMap<>();
        for (Map.Entry<String, Searchable> object : searchableObjects.entrySet()) {
            String key = object.getKey();
            Searchable value = object.getValue();
            if (object != null && searchableObjects.containsKey(searchObject)) {
                resultsSearch.put(key, value);
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
        for (Map.Entry<String, Searchable> object : searchableObjects.entrySet()) {
            if (object != null) {
                int maxFound = maxReplay(String.valueOf(object.getValue()), searchElements);
                if (maxFound > found) {
                    String stringSearch = String.valueOf(object.getValue()).toLowerCase();
                    String substring = searchElements.toLowerCase();
                    maxFound = maxReplay(stringSearch, substring);
                    found = maxFound;
                    bestResultSearch = (Searchable) object;
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
        for (Map.Entry<String, Searchable> searchables : searchableObjects.entrySet()) {
            System.out.println(searchables);
        }
    }

}