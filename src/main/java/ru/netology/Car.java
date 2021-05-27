package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Car implements Runnable {
    public Car () {
    }

    // План продаж
    private final int SALES_PLAN = 10;

    // Время на создание авто
    private final int CREATE_AUTO = 1000;

    List<Car> cars = new ArrayList<>();


    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void run() {
        try {
            while (getCars().size() < SALES_PLAN) {
                Thread.sleep(CREATE_AUTO);
                getCars().add(new Car());
                System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
