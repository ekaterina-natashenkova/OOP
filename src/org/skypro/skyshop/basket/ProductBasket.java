package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] basket = new Product[5];

    // Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                System.out.println("Продукт добавлен в корзину");
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public double getCostBasket() {
        double costBasket = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                costBasket += basket[i].getPriceProduct();
            }
        }
        return costBasket;
    }

    // Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    //<имя продукта>: <стоимость> / Итого: <общая стоимость корзины> / Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
    public void printBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                System.out.println("в корзине пусто");
                return;
            } else {
                System.out.println(basket[i]);
            }
        }
        System.out.println("Итого: " + getCostBasket());
    }

    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean faindTitleProductBasket(String titleProduct) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && basket[i].getTitleProduct().equals(titleProduct)) {
                return true;
            }
        }
        return false;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
                System.out.println("Корзина очищена");
                return;
            }
        }
    }

}