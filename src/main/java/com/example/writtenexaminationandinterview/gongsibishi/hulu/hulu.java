package com.example.writtenexaminationandinterview.gongsibishi.hulu;


import java.io.*;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/21 12:20 下午
 */
public class hulu {


    // /*
//  * Click `Run` to execute the snippet below!
//  */

// /*
//  * To execute Java, please define "static void main" on a class
//  * named Solution.
//  *
//  * If you need more classes, simply define them inline.
//  */


//  // 1-2 2-3 3-1


//     public static int[] visited;

//   // 0未访问 1正在访问 2完成

//   public static boolean valid;

//  public static List<ArrayList<Integer>> edges;

//   // [0] -> [ 1, 2 ]
//   public static boolean check(List<int[]> list,int pointNum){

//     edges=new ArrayList<>();

//     visited=new int[pointNum];


//     for(int i=0;i<pointNum;i++){
//       edges.add(new ArrayList<>());
//     }
//     for(int[] info:list){

//       edges.get(info[1]).add(info[0]);

//     }

//     for(int i=0;i<pointNum;i++){
//        if(visited[i]==0){
//         dfs(i);
//        }

//     }


//     return valid;

//   }


//    public static void dfs(int u){

//      // 标记正在访问 0->1
//       visited[u]=1;

//      for(int v:edges.get(u)){

//        // 检测到环
//        if(visited[v]==1){
//          valid=false;
//          return;
//        }else if(visited[v]==0){
//          // 剪枝
//          if(valid){
//         dfs(v); }
//        }

//     }

//      // 返回时状态完成
//      visited[u]=2;


//    }

    // public static int maxOnline(List<int[]> list){

//     TreeMap<Integer,Integer> map=new TreeMap<>();


//     for(int[] ele:list){

//       // 起点
//      map.put(ele[0],map.getOrDefault(ele[0],0)+1);
//       // 终点

//       map.put(ele[1],map.getOrDefault(ele[1],0)-1);

//     }


//     Integer ans=0,num=0;

//     for(Map.Entry<Integer,Integer>entry:map.entrySet()){

//       num+=entry.getValue();
//       ans=Math.max(num,ans);

//     }

//     return ans;

//   }


    public static boolean find(String s, List<String> dict) {

        int len = s.length();

        boolean[] dp = new boolean[len + 1];

        // 边界初始化

        dp[0] = true;


        for (int i = 0; i <= len; i++) {

            for (int j = i - 1; j >= 0; j--) {


                // 起始下标 个数？

                String suffix = s.substring(j, i);
                if (dict.contains(suffix) && dp[j]) {

                    dp[i] = true;
                    break;
                }

            }


        }


        return dp[len];
    }


    public static void main(String[] args) {

        List<String> dict = new ArrayList<String>() {{
            add("hello");
            add("hulu");
        }};

        String s = "hellohuluhulu";

        System.out.println(find(s, dict));

    }
}


// [[1, 20], [2, 20], [20, 40]]


// dict["hello", "hulu"] s"hellohulu"
// dp[i+1] = dp[j]&&dict.contains(s.subString(j+1,i+1))

