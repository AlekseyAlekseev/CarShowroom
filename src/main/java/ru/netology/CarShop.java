package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private final int ARRIVAL_TIME = 5000;
    private final int SEARCH_TIME = 3000;
    private final int SELL_TIME = 1000;

    private final List<Car> cars = new ArrayList<>();


    public List<Car> getCars() {
        return cars;
    }

    public synchronized void getCar() {
        try {
            System.out.println("Уведомление: В автосалон поступает автомобиль...");
            Thread.sleep(ARRIVAL_TIME);
            getCars().add(new Car("BMW"));
            System.out.println("Автосалон: Автомобиль доступен к продаже");
            notify();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            Thread.sleep(SEARCH_TIME);
            while (getCars().size() == 0) {
                System.out.println("Автосалон: Запрошенного автомобиля нет в наличии");
                wait();
            }
            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return getCars().remove(0);
    }
}
