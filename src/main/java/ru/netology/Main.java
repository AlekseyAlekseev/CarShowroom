package ru.netology;

public class Main {
    public static void main(String[] args) {

        CarShop carShop = new CarShop();

        new Thread(null, carShop::sellCar, "Покупатель").start();
        new Thread(null, carShop::receiveCar, "Продавец").start();
    }
}
