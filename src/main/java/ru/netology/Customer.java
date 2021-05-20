package ru.netology;

public class Customer implements Runnable{

    CarShop carShop = new CarShop();


    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " пришел в автосалон");
                Thread.sleep(3000);
                carShop.sellCar();
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
