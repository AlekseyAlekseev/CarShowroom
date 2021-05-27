package ru.netology;

public class Main {
    public static void main(String[] args) {

        CarShowroom carShowroom = new CarShowroom();
        ThreadGroup customerGroup = new ThreadGroup("customerGroup");

        Runnable shopping = carShowroom::carSale;
        Runnable carProduction = carShowroom::createCar;

        Thread customer1 = new Thread(customerGroup, shopping, "Покупатель1");
        Thread customer2 = new Thread(customerGroup, shopping, "Покупатель2");
        Thread customer3 = new Thread(customerGroup, shopping, "Покупатель3");
        Thread factory1 = new Thread(null, carProduction, "BMW");


        customer1.start();
        customer2.start();
        customer3.start();
        factory1.start();
    }
}
