package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {

        // Создание продуктов
        Product product1 = new SimpleProduct("чай", 200);
        Product product2 = new SimpleProduct("кофе", 450);
        Product product3 = new DiscountedProduct("вода", 100, 10);
        Product product4 = new DiscountedProduct("сок", 150, 20);
        Product product5 = new FixPriceProduct("молоко");
        Product product6 = new FixPriceProduct("кефир");

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
        // п.4 // Получение стоимости корзины с несколькими товарами. // ** Получение количества специальных товаров.
        basket.getCostBasket();
        basket.getCountSpecialProduct();

        // Проверка корзины
        // п.5.6. // Поиск товара, который есть в корзине. // Поиск товара, которого нет в корзине.
        System.out.println(basket.faindTitleProductBasket("чай"));
        System.out.println(basket.faindTitleProductBasket("кефир"));

        // Очистка корзины
        // п.7.8.9.10 //Очистка корзины. // Печать содержимого пустой корзины. // Получение стоимости пустой корзины. // Поиск товара по имени в пустой корзине.
        basket.clearBasket();
        basket.printBasket();
        System.out.println(basket.getCostBasket());
        System.out.println(basket.faindTitleProductBasket("чай"));
    }

}