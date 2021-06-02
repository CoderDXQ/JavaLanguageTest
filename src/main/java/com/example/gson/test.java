package com.example.gson;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author duanxiangqing
 * @date 2021/6/2
 */
public class test {


    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        String json=in.nextLine();

        JsonParser parser = new JsonParser();

        JsonElement je = parser.parse(json);

        JsonObject jobj = je.getAsJsonObject();

        String result = jobj.get("result").getAsString();
        System.out.println(result);

        System.out.println();

        JsonObject data = jobj.get("data").getAsJsonObject();
        JsonArray result1 = data.get("result").getAsJsonArray();

        List<String> userIds = new ArrayList<>();

//        result1.forEach(a -> {
//            JsonObject o1 = a.getAsJsonObject();
//            JsonObject o2 = o1.get("basicInfo").getAsJsonObject();
//            String o3 = o2.get("userId").getAsString();
//            System.out.println(o3);
//        });

        result1.forEach(a -> {
            userIds.add(a.getAsJsonObject().get("basicInfo").getAsJsonObject().get("userId").getAsString());
        });

        userIds.forEach(System.out::println);


        System.out.println();


    }


}
