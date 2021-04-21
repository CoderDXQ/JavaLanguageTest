package com.example.writtenexaminationandinterview.elevator;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/21 11:25 下午
 */
//只有一部电梯的情况
public class Elevator {

    int id;
    int floor;
    int max_floor;
    String current_mode;
    ArrayList<Integer> destinations;

    public Elevator(int id, int floor, int max_floor) {
        this.id = id;
        this.floor = floor;
        this.max_floor = max_floor;
        this.destinations = new ArrayList<Integer>();
    }

    public void move() {

        if (destinations.size() == 0) {
            return;
        } else {
            while (destinations.size() != 0) {
                if (destinations.get(0) > floor && current_mode != "down") {
                    current_mode = "up";
                    floor = destinations.get(0);
                    destinations.remove(0);
                } else if (destinations.get(0) < floor && current_mode != "up") {
                    current_mode = "down";
                    floor = destinations.get(0);
                    destinations.remove(0);
                } else {
                    current_mode = "stay";
                }
            }
        }
    }

}
