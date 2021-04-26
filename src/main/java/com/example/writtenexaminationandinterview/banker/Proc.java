package com.example.writtenexaminationandinterview.banker;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/26 3:40 下午
 */
//进程类
public class Proc {

    char name;
    //    需求的最大资源向量
    int max_res[];
    //    拥有的资源向量
    int alloc_res[];
    //    还需要的资源向量
    int need_res[];
    //    记录检查是否完成
    boolean finish_status = false;

    public Proc(char name, int[] max_res, int[] alloc_res, int[] need_res) {
        this.name = name;
        this.max_res = max_res;
        this.alloc_res = alloc_res;
        this.need_res = need_res;
        this.finish_status = false;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int[] getMax_res() {
        return max_res;
    }

    public void setMax_res(int[] max_res) {
        this.max_res = max_res;
    }

    public int[] getAlloc_res() {
        return alloc_res;
    }

    public void setAlloc_res(int[] alloc_res) {
        this.alloc_res = alloc_res;
    }

    public int[] getNeed_res() {
        return need_res;
    }

    public void setNeed_res(int[] need_res) {
        this.need_res = need_res;
    }

    public boolean isFinish_status() {
        return finish_status;
    }

    public void setFinish_status(boolean finish_status) {
        this.finish_status = finish_status;
    }

}
