package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductBasket {

    private Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new TreeMap<>();
    }

    // Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    // Метод для работы с массивом Product[] basket = new Product[5] переписан, ввиду изменения структуры данных с Массива на Лист
    public void addProduct(Product product) {
        List<Product> products = basket.getOrDefault(product.getTitleProduct(), new LinkedList<>());
        products.add(product);
        basket.put(product.getTitleProduct(), products);
        System.out.println("Продукт добавлен в корзину");
    }

    // Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public double getCostBasket() {
        return basket.values().stream().flatMap(Collection::stream)
        .mapToDouble(Product::getPriceProduct)
        .sum();
    }


    // Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    //<имя продукта>: <стоимость> / Итого: <общая стоимость корзины> / Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
    // Альтернативный вариант печати корзины для Map<k,v> - basket.values().forEach(lst -> lst.forEach(System.out::println));
    public void printBasket() {
        Stream<Product> products = basket.values().stream().flatMap(Collection::stream);
        products.forEach(System.out::println);
               System.out.println("Итого: " + getCostBasket());
    }

    // вызов метода подсчета количества товаров специального типа, с выводом сообщения в консоль в заданном виде
    public int getCountSpecialProduct() {
        long countSpecialProduct = basket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        System.out.println("Специальных товаров в корзине " + countSpecialProduct);
        return (int) countSpecialProduct;
    }

    // Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean faindTitleProductBasket(String titleProduct) {
        return basket.values().stream().flatMap(Collection::stream)
                .anyMatch(product -> product.getTitleProduct().equalsIgnoreCase(titleProduct));
    }

    // Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        basket.clear();
        System.out.println("Корзина очищена");
    }

    // Метод удаления продукта по имени из корзины // по ключу
    public List<Product> removeProduct(String nameKey) {
        List<Product> removeProduct = basket.values().stream().flatMap(List::stream)
                .filter(product -> product.getTitleProduct().equals(nameKey))
                .peek(product -> System.out.println("Продукт " + product + " готов к удалению"))
                .collect(Collectors.toList());
        basket.values().forEach(products -> products.removeIf(product -> product.getTitleProduct().equals(nameKey)));
        if (removeProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProduct;
    }

}
