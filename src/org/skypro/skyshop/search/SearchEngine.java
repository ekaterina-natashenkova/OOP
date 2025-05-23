package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

public class SearchEngine {

//Поле Searchable[] — массив всех элементов, по которым можно искать. Размерность массива нужно передавать через конструктор класса SearchEngine
//Метод search — принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву Searchable в виде массива из 5 элементов.
//Метод add() — добавляет новый объект типа Searchable в массив поискового движка.

//Для тестирования:
//Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
//Создайте несколько объектов типа Article и добавьте их в Search Engine
//Продемонстрируйте функциональность поиска с помощью объекта SearchEngine: вызовите метод search несколько раз с разными строками поиска.

    private final Searchable[] searchableObjects;
    private int count;

    public SearchEngine(int size) {
        searchableObjects = new Searchable[size];
        count = 0;
    }

    public void add(Searchable object) {
        if (count < searchableObjects.length) {
            searchableObjects[count] = object;
            count++;
        }
    }

    public Searchable[] search(String searchObject) {
        Searchable[] resultsSearch = new Searchable[5];
        int resultCount = 0;
        for (Searchable object : searchableObjects) {
            if (object != null && object.getSearchTerm().contains(searchObject)) {
                if (resultCount < 5) {
                    resultsSearch[resultCount] = object;
                    resultCount++;
                } else {
                    break;
                }
            }
        }
        return resultsSearch;
    }

    // поиск самого подходящего элемента к поисковой строке
    public Searchable[] searchElement(String searchElements) throws BestResultNotFound {
        Searchable[] bestResultSearch = new Searchable[1];
        int found = 0;
        for (Searchable object : searchableObjects) {
            if (object != null) {
                int maxFound = maxReplay(object.getSearchTerm(), searchElements);
                if (maxFound > found) {
                    String stringSearch = object.getSearchTerm().toLowerCase();
                    String substring = searchElements.toLowerCase();
                    maxFound = maxReplay(stringSearch, substring);
                    found = maxFound;
                    bestResultSearch[found] = object;
                } else {
                    throw new BestResultNotFound("Нет соответствующего запросу элемента"); // почему объект null ?! Searchable[] заполнен объектами
                }
            }
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
        for (int i = 0; i < searchableObjects.length; i++) {
            if (searchableObjects[i] != null) {
                System.out.println(searchableObjects[i]);
            }
        }
    }

}
