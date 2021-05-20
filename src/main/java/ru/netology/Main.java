package ru.netology;

public class Main {
    public static void main(String[] args) throws IllegalThreadStateException {

        CarShop carShop = new CarShop();

        Thread carShopSell1 = new Thread(null, carShop::sellCar, "Покупатель1");
        Thread carShopSell2 = new Thread(null, carShop::sellCar, "Покупатель2");
        Thread carShopSell3 = new Thread(null, carShop::sellCar, "Покупатель3");
        Thread carShopGet = new Thread(null, carShop::getCar);


        carShopSell1.start();
        carShopSell2.start();
        carShopSell3.start();
        carShopGet.start();


    }
}
