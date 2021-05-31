package com.example.jdk8.methodreferences;

import java.util.Arrays;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/31 11:30 下午
 */
public class Test {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    static class Car {

        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

    }


    public static void main(String[] args) {

        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

//        静态类的实例都是同一个
        cars.forEach(Car::collide);

        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

    }

}
