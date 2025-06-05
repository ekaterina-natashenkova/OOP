package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductBasket {

    private Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new TreeMap<>();
    }

    // Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист / на Map
    public void addProduct(Product product) {
        List<Product> products = basket.getOrDefault(product.getTitleProduct(), new LinkedList<>());
        products.add(product);
        basket.put(product.getTitleProduct(), products);
        System.out.println("Продукт добавлен в корзину");
    }

    // Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public double getCostBasket() {
        double costBasket = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                costBasket += product.getPriceProduct();
            }
        }
        return costBasket;
    }

    // Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    //<имя продукта>: <стоимость> / Итого: <общая стоимость корзины> / Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    // ВОПРОС ??? Будет ли работать печать корзины, если вместо 2-х циклов написать: "list.forEach(System.out::println);" ???
    // ВОПРОС ??? И еще нашла вариант печати списка через стрим, так же вместо 2-х циклов - "list.stream().forEach(System.out::println);" ???
    public void printBasket() {
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + getCostBasket());
    }

    // вызов метода подсчета количества товаров специального типа, с выводом сообщения в консоль в заданном виде
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public int getCountSpecialProduct() {
        int countSpecialProduct = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    countSpecialProduct++;
                }
            }

        }
        System.out.println("Специальных товаров в корзине " + countSpecialProduct);
        return countSpecialProduct;
    }

    // Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public boolean faindTitleProductBasket(String titleProduct) {
        for (List<Product> products : basket.values()) {
            if (products.contains(titleProduct)) {
                System.out.println("В корзине есть искомый продукт");
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void clearBasket() {
        basket.clear();
        System.out.println("Корзина очищена");
    }

    // Метод удаления продукта по имени из корзины // по ключу
    public List<Product> removeProduct(String nameKey) {
        List<Product> removeProduct = new LinkedList<>();
        Iterator<Map.Entry<String, List<Product>>> iterator = basket.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> product = iterator.next();
            List<Product> tempProduct = product.getValue();
            if (tempProduct.listIterator().equals(nameKey)) {
                System.out.printf("Продукт " + tempProduct.listIterator() + " готов к удалению");
                removeProduct.add((Product) tempProduct);
                iterator.remove();
            }
        }
        if (removeProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProduct;
    }


}
