package ru.netology;

public class Main {
    public static void main(String[] args) {

        CarShop carShop = new CarShop();
        Customer customer = new Customer();

        new Thread(customer).start();
    }
}
