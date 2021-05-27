package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {

    // Время на покупку
    private final int SELL_TIME = 2000;

    // План продаж
    private final int SALES_PLAN = 10;

    // Время на создание авто
    private final int CREATE_AUTO = 1000;

    List<Car> cars = new ArrayList<>();


    public List<Car> getCars() {
        return cars;
    }


    public synchronized void createCar() {
        try {
            while (getCars().size() < SALES_PLAN) {
                Thread.sleep(CREATE_AUTO);
                getCars().add(new Car());
                System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
                notify();
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }


    /**
     * Покупка автомобиля и проверка его наличия
     */
    public synchronized void carSale() {
        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
        try {
            while (getCars().size() == 0) {
                System.out.println("Автосалон: Запрошенного автомобиля нет в наличии");
                wait();
            }
            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
            getCars().remove(0);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
