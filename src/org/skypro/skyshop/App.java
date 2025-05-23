package org.skypro.skyshop;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        try {
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

            //создание статей о ранее созданных продуктах
            Searchable article1 = new Article("виды чая", "о пользе и вреде различных видов чая, при определенной температуре заваривания");
            Searchable article2 = new Article("кофе для здоровья", "о пользе и вреде кофе, при высоком и низком давлении");
            Searchable article3 = new Article("все о воде", "о необходимости потребления достаточного количества воды в течении дня для людей разного возраста");
            Searchable article4 = new Article("про сок", "о пользе и вреде свежевыжатого сока и сокосодержащих напитков");
            Searchable article5 = new Article("о молоке", "о качестве современного пакетированного молока, представленного в магазинах");
            Searchable article6 = new Article("кефир - мифы и реальность", "о кефире, как о разновидности кисломолочной продукции");

            //создание дополнительных продуктов
            Searchable product7 = new DiscountedProduct("чай черный", 200, 30);
            Searchable product8 = new DiscountedProduct("чай зеленый", 200, 35);
            Searchable product9 = new DiscountedProduct("чай фруктовый", 200, 20);
            Searchable product10 = new FixPriceProduct("сок яблочный");
            Searchable product11 = new FixPriceProduct("сок персиковый");
            Searchable product12 = new FixPriceProduct("сок томатный");

            // Создание объекта SearchEngine для заполнения его товарами и статьями о них - увеличила размер массива поисковика с 20 на 25
            SearchEngine searchableObjects = new SearchEngine(25);

            // Добавление объектов в SearchEngine
            searchableObjects.add(product1);
            searchableObjects.add(product2);
            searchableObjects.add(product3);
            searchableObjects.add(product4);
            searchableObjects.add(product5);
            searchableObjects.add(product6);
            searchableObjects.add(product7);
            searchableObjects.add(product8);
            searchableObjects.add(product9);
            searchableObjects.add(product10);
            searchableObjects.add(product11);
            searchableObjects.add(product12);
            searchableObjects.add(article1);
            searchableObjects.add(article2);
            searchableObjects.add(article3);
            searchableObjects.add(article4);
            searchableObjects.add(article5);
            searchableObjects.add(article6);

            // поиск объектов...
            Searchable[] searchResult = searchableObjects.search("чай");
            System.out.println(Arrays.toString(searchResult));

            Searchable[] searchResult2 = searchableObjects.search("кофе");
            System.out.println(Arrays.toString(searchResult2));

            Searchable[] searchResult3 = searchableObjects.search("сок");
            System.out.println(Arrays.toString(searchResult3));

            Searchable[] searchResult4 = searchableObjects.search("мясо");
            System.out.println(Arrays.toString(searchResult4));

            Searchable[] searchResult5 = searchableObjects.search("морс"); // не ищет, т.к. продукт в поисковик добавляется позже
            System.out.println(Arrays.toString(searchResult5));


            //создание дополнительных продуктов для проверки исключений
            Searchable product13 = new SimpleProduct("морс", 100);
            Searchable product14 = new DiscountedProduct("морс клюквенный", 200, 50);

            //продукты с ошибками ввода - все 3 ошибки сразу не отлавливаются - только первую выводит
            Searchable product15 = new SimpleProduct("м", 100); // ошибка названия - ничего не введено
            Searchable product16 = new DiscountedProduct("морс брусничный", 10, 35); // ошибка цены - 0
            Searchable product17 = new DiscountedProduct("морс смородиновый", 200, 10); // ошибка скидки - 101

            // Добавление дополнительных объектов в SearchEngine
            searchableObjects.add(product13);
            searchableObjects.add(product14);
            searchableObjects.add(product15);
            searchableObjects.add(product16);
            searchableObjects.add(product17);

            Searchable[] searchResult6 = searchableObjects.search("морс"); // тестовый поиск после добавления новых продуктов
            System.out.println(Arrays.toString(searchResult6));

            //тестовая печать содержимое поисковика
            searchableObjects.printSearchEngine();

            // поиск подстроки...
            Searchable[] bestResultSearch1 = searchableObjects.searchElement("мол");
            System.out.println(Arrays.toString(bestResultSearch1));

            Searchable[] bestResultSearch2 = searchableObjects.searchElement("мел");
            System.out.println(Arrays.toString(bestResultSearch2));

        } catch (IllegalAccessException exceptions) {
            System.out.println(exceptions.getMessage());

        } catch (BestResultNotFound exceptions) {
            System.out.println(exceptions.getMessage());

        } finally {
            System.out.println("Проверка завершена");
        }

    }

}