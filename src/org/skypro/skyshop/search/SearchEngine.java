package org.skypro.skyshop.search;

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

    public Searchable[] search(String searchEngine) {
        Searchable[] resultsSearch = new Searchable[5];
        int resultCount = 0;
        for (Searchable object : searchableObjects) {
            if (object != null && object.getSearchTerm().contains(searchEngine)) {
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

}
