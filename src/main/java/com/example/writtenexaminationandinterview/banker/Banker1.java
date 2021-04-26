package com.example.writtenexaminationandinterview.banker;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/26 7:59 下午
 */
//REFERENCE：https://skecis.top/2019/11/08/%E9%93%B6%E8%A1%8C%E5%AE%B6%E7%AE%97%E6%B3%95/
public class Banker1 {
    //        进程数量
    int pcb_nums;
    //        资源种类数量
    int res_nums;

    //        进程数组
    Proc pcbs[];

    //        最大需求资源向量
    int max[];

    //        拥有资源数量
    int alloc[];

    //        还需要的资源数量
    int need[];

    //        可用资源数量
    int ava[];

    //        安全序列数组
    char safe_seq[];

    //        安全序列 标记整个系统是不是安全
    boolean safe_status;

    //    判断某次是否回收了资源  如果回收了资源说明有重建检测所有资源的必要否则就会发生死锁
    boolean has_recycle;


    public void bank_init() {
        // A sample
		/*   Max    Alloc  Need   Avai
		 - a 7 5 3, 0 1 0, 7 4 3, 3 3 2
		 - b 3 2 2, 2 0 0, 1 2 2
		 - c 9 0 2, 3 0 2, 6 0 0
		 - d 2 2 2, 2 1 1, 0 1 1
		 - e 4 3 3, 0 0 2, 4 3 1
		 */

        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.println("一共几个进程：");
        pcb_nums = in.nextInt();
        System.out.println("一共几种资源：");
        res_nums = in.nextInt();

//        创建进程数组
        pcbs = new Proc[pcb_nums];
//        可用资源数组
        ava = new int[res_nums];
//        安全序列
        safe_seq = new char[pcb_nums];

//        初始化每个进程的信息
        for (int i = 0; i < pcbs.length; i++) {

//            运行时需要的最大资源数
            max = new int[res_nums];
//            拥有的资源数量
            alloc = new int[res_nums];
//            需要的资源数量
            need = new int[res_nums];
            System.out.println("---------------------------------------");
            System.out.println("输入第" + (i + 1) + "个进程信息(名字-最大资源-拥有资源)");
            System.out.println("名字：");
            char name = in.next().charAt(0);

            System.out.println("最大资源：");
            for (int j = 0; j < res_nums; j++) {
                max[j] = in.nextInt();
            }

            System.out.println("拥有资源：");
            for (int j = 0; j < res_nums; j++) {
                alloc[j] = in.nextInt();
            }

//            计算还需要的资源
            for (int j = 0; j < res_nums; j++) {
                need[j] = max[j] - alloc[j];
            }

//            初始化每个进程
            pcbs[i] = new Proc(name, max, alloc, need);

        }

        System.out.println("------可用资源————————");
        for (int j = 0; j < res_nums; j++) {
            ava[j] = in.nextInt();
        }


    }

    public void algori() {

        int safe_count = 0;

//        不是所有线程达到安全状态就循环检查
        while (safe_count != pcb_nums) {

            has_recycle = false;

//            检查每一个进程
            for (int i = 0; i < pcb_nums; i++) {

                if (pcbs[i].finish_status == false) {//判断这个进程是否可以顺利执行 初始是false

//                    对同一个进程检查每一种资源
                    for (int j = 0; j < res_nums; j++) {
                        int now_res = pcbs[i].getNeed_res()[j];
                        if (now_res <= ava[j]) {
                            pcbs[i].finish_status = true;
                        } else {
                            pcbs[i].finish_status = false;
                            break;
                        }
                    }

//                    该进程可以顺利执行(所有资源都能满足需求)  那么执行完毕后就回收
                    if (pcbs[i].finish_status) {

//                        进行了回收 有继续进入下次while循环的必要
                        has_recycle = true;

                        for (int j = 0; j < res_nums; j++) {
                            ava[j] += pcbs[i].getNeed_res()[j];
                        }
//                        依次添加安全队列
                        safe_seq[safe_count] = pcbs[i].getName();
//                        安全线程数
                        safe_count++;
                    }

                }

            }

            /**
             //            评估整个系统是不是安全的
             for (int i = 0; i < pcb_nums; i++) {

             if (pcbs[i].finish_status) {
             safe_status = true;
             break;
             } else {
             safe_status = false;
             }

             }

             //            能执行这一个说明一个线程都不能执行  死锁
             if (!safe_status) {
             break;
             }
             **/

//            本次没有回收资源  没有进行下次进入while循环的必要
            if (has_recycle == false) {
                break;
            }

        }


//        检查是不是所有的进程都可以顺利执行完毕  否则的话就会发生死锁
        safe_status = true;

        for (int i = 0; i < pcb_nums; i++) {

            if (!pcbs[i].finish_status) {
                safe_status = false;
                break;
            }

        }


        if (safe_status) {
            System.out.println("该系统安全，安全序列为: ");
            for (int i = 0; i < pcb_nums; i++) {
                System.out.print(safe_seq[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("该系统不安全！");
        }

    }


    public static void main(String[] args) {

        Banker1 test = new Banker1();
        test.bank_init();
        test.algori();

    }


}
