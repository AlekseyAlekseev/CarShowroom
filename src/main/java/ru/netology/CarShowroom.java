package ru.netology;

public class CarShowroom {

    Producer producer;

    public CarShowroom(Producer producer) {
        this.producer = producer;
    }


    private final int SELL_TIME = 2000;


    /**
     * Покупка автомобиля и проверка его наличия
     */
    public void carSale() {
        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
        try {
            producer.carSale();
            Thread.sleep(SELL_TIME);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
    }
}
