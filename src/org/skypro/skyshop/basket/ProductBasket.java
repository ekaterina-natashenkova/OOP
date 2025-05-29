package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> basket;

    public ProductBasket() {
        this.basket = new LinkedList<>();
    }

    // Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void addProduct(Product product) {
        basket.add(product);
        System.out.println("Продукт добавлен в корзину"); // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ
    }

    // Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public double getCostBasket() {
        Iterator<Product> iterator = basket.iterator();
        double costBasket = 0;
        while (iterator.hasNext()) {
            Product element = iterator.next();
            costBasket += element.getPriceProduct();
        }
        return costBasket; // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ (с итератором)
    }

    // Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    //<имя продукта>: <стоимость> / Итого: <общая стоимость корзины> / Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void printBasket() {
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            System.out.println(element);
        }
        System.out.println("Итого: " + getCostBasket()); // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ (с итератором)
    }

    // вызов метода подсчета количества товаров специального типа, с выводом сообщения в консоль в заданном виде
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void getCountSpecialProduct() {
        int countSpecialProduct = 0;
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
        }
        countSpecialProduct++;
        System.out.println("Специальных товаров: " + countSpecialProduct); // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ (с итератором)
    }

    // Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public boolean faindTitleProductBasket(String titleProduct) {
        if (basket.contains(titleProduct)) {
            System.out.println("В корзине есть искомый продукт");
            return true;
        }
        return false; // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ
    }

    // Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void clearBasket() {
        basket.clear();
        System.out.println("Корзина очищена"); // ИСПРАВЛЕНО ДЛЯ КОЛЛЕКЦИИ
    }

    // Метод удаления продукта по имени из корзины
    public List<Product> removeProduct(String name) {
        List<Product> removedProduct = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getTitleProduct().equals(name)) {
                removedProduct.add(product);
                iterator.remove();
            }
        }
        if (removedProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProduct;
    }

}