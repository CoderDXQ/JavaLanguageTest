package com.example.writtenexaminationandinterview.sss;

/**
 * @author duanxiangqing
 * @date 2021/5/25
 */
//验证StringBuilder线程不安全
public class TestThredSafety {


    //    可能会出现两个结果长度不同的情况即StringBuilder的长度不到100 并且可能会报错
    public static void main(String[] args) throws InterruptedException {

        StringBuilder sbd = new StringBuilder();

        StringBuffer sbf = new StringBuffer();

        System.out.println("----------------");

        for (int i = 0; i < 10; i++) {

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sbd.append(String.valueOf(finalI));
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

//            System.out.println(sbd);

        }

        Thread.sleep(3000);


        System.out.println("_________________-");
//        System.out.println(sbd);
        System.out.println(sbd.length());
        System.out.println("_________________-");

        for (int i = 0; i < 10; i++) {

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sbf.append(String.valueOf(finalI));
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

//            System.out.println(sbf);

        }

        System.out.println("_________________-");


        Thread.sleep(3000);

//        System.out.println(sbf);
        System.out.println(sbf.length());

    }

}
