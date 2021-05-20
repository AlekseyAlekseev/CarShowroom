package ru.netology;

public class Main {
    public static void main(String[] args) throws IllegalThreadStateException {


        Customer customer = new Customer();
        CarShop carShop = new CarShop();
        ThreadGroup customerGroup = new ThreadGroup("customerGroup");

        Thread customer1 = new Thread(customerGroup, customer, "Покупатель1");
        Thread customer2 = new Thread(customerGroup, customer, "Покупатель2");
        Thread customer3 = new Thread(customerGroup, customer, "Покупатель3");

        Thread carShopSell = new Thread(null, carShop::sellCar, "Автосалон");
        Thread carShopGet = new Thread(null, carShop::getCar, "Автосалон");


        /**
         * Покупатели
         */
        customer1.start();
        customer2.start();
        customer3.start();

        /**
         * Автосалон
         */
        carShopSell.start();
        carShopGet.start();

    }
}
