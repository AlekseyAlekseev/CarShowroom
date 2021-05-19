package ru.netology;

public class Customer implements Runnable {

    private final int TIME_ENTRY_CARSHOP = 5000;


    @Override
    public void run() {
        try {
            Thread.currentThread().setName("Покупатель");
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(TIME_ENTRY_CARSHOP);
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            }
        } catch (InterruptedException err) {
            System.out.println(Thread.currentThread().getName() + " расстроен, машины в наличии не оказалось");
        }
    }
}
