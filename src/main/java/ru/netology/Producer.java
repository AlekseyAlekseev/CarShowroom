package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Producer {

    //private final CarShowroom carShowroom;

    private int count = 0;
    private final int SALES_PLAN = 10;

    private final int CREATE_AUTO = 3000;

    List<Car> cars = new ArrayList<>();

//    public Producer(CarShowroom carShowroom) {
//        this.carShowroom = carShowroom;
//    }

    public List<Car> getCars() {
        return cars;
    }

    /**
     * Производим автомобиль
     */
    public synchronized void carRelease() {
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
     * Проверяем есть ли автомобиль в наличии
     */
    public synchronized Car carSale() {
        try {
            while (getCars().size() == 0) {
                System.out.println("Автосалон: Запрошенного автомобиля нет в наличии");
                wait();
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return getCars().remove(0);
    }

}
