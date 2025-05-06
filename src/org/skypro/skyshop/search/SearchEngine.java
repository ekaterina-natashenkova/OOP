package org.skypro.skyshop.search;

public class SearchEngine {

    private int size;
    private Searchable[] searchEngine;

    public SearchEngine(int size) {
        this.size = size;
        this.searchEngine = new Searchable[size];
    }

    public int getSize() {
        return size;
    }

    public Searchable[] getSearchEngine() {
        return searchEngine;
    }

    public Searchable[] search(String search) {
        int quantity = 0;
        Searchable[] searchResult = new Searchable[5];
        for (int i = 0; i < getSearchEngine().length && quantity < 5; i++) {
            if (searchEngine[i].getSearchTerm().contains(search)) {
                searchResult[quantity] = searchEngine[i];
                System.out.println("найден элемент: " + searchResult[quantity]);
                quantity++;
            }
        }
        return searchResult;
    }

    public void add(Searchable object) {
        for (int i = 0; i < getSize(); i++) {
            searchEngine[i] = object;
            System.out.println("Добавлен объект " + searchEngine[i].getTypeContent() + ": " + searchEngine[i] + " добавлен в поиск");
            return;
        }
    }
}
