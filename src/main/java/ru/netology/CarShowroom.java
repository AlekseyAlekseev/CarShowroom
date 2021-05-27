package ru.netology;

public class CarShowroom {

    // Время на покупку
    private final static int SELL_TIME = 2000;

    // План продаж
    public final static int SALES_PLAN = 10;

    // Время на создание авто
    private final static int CREATE_AUTO = 2000;

    // Счетчик произведенных авто
    private int product = 0;

    // Счетчик проданных авто
    private int sales = 0;

    public int getSales() {
        return sales;
    }

    public int getProduct() {
        return product;
    }


    public synchronized void carSale() {
        try {
            while (product == 0) {
                wait();
            }
            Thread.sleep(SELL_TIME);
            product--;
            sales++;
            notifyAll();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    /**
     * Добавление нового автомобился в салон
     */
    public synchronized void createCar() {
        try {
            while (product > 0) {
                wait();
            }
            Thread.sleep(CREATE_AUTO);
            product++;
            System.out.println("Производитель выпустил 1 авто");
            notify();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

