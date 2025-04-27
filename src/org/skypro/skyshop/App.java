package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        // Создание продуктов
        Product product1 = new Product("чай", 200);
        Product product2 = new Product("кофе", 450);
        Product product3 = new Product("вода", 70);
        Product product4 = new Product("сок", 150);
        Product product5 = new Product("молоко", 120);
        Product product6 = new Product("кефир", 130);

        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Добавление продуктов в корзину
        // п.1.2. // Добавление продукта в корзину.// Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        // Содержимое корзины
        // п.3 // Печать содержимого корзины с несколькими товарами.
        basket.printBasket();

        // Общая стоимость корзины
        // п.4 // Получение стоимости корзины с несколькими товарами.
        basket.getCostBasket();
        System.out.println(basket.getCostBasket());

        // Проверка корзины
        // п.5.6. // Поиск товара, который есть в корзине. // Поиск товара, которого нет в корзине.
        basket.faindTitleProductBasket("чай");
        basket.faindTitleProductBasket("кефир");

        // Очистка корзины
        // п.7.8.9.10 //Очистка корзины. // Печать содержимого пустой корзины. // Получение стоимости пустой корзины. // Поиск товара по имени в пустой корзине.
        basket.clearBasket();
        basket.printBasket();
        basket.getCostBasket();
        basket.faindTitleProductBasket("чай");
    }

}