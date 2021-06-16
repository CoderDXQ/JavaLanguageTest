package com.example.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:27 下午
 */
public class Meal {
    //    存放各种食物
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

//    计算花费
    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item : " + item.name());
            System.out.println(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }


}
