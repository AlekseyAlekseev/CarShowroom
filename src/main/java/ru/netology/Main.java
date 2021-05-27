package ru.netology;

public class Main {

    // Время нового визита покупателя
    private final static int buyerVisitTime = 7000;
    // Номер нового потока
    private static int nameCounter = 3;

    public static void main(String[] args) {


        CarShowroom carShowroom = new CarShowroom();
        ThreadGroup customerGroup = new ThreadGroup("customerGroup");

        new Thread(customerGroup, new Consumer(carShowroom), "Покупатель1").start();
        new Thread(customerGroup, new Consumer(carShowroom), "Покупатель2").start();
        new Thread(customerGroup, new Consumer(carShowroom), "Покупатель3").start();

        Thread producer = new Thread(null, new Producer(carShowroom), "BMW");
        producer.setDaemon(true);
        producer.start();


        while (true) {
            if (carShowroom.getSales() < CarShowroom.SALES_PLAN) {
                try {
                    Thread.sleep(buyerVisitTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                new Thread(null, new Consumer(carShowroom), "Покупатель " + ++nameCounter).start();
            } else {
                break;
            }
        }
    }
}
