package com.example.writtenexaminationandinterview.snowflake;

/**
 * 雪花算法  用于生成全局唯一id
 * 优点：
 * 1. 所有生成的id按时间趋势递增
 * 2. 一般不会产生重复id
 * 3. 高性能高可用 容量大 不依赖数据库 完全在内存中生成
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/11 12:21 下午
 */
public class SnowFlake {

    //    下面是10位的工作机器id
    private long workerId;
    private long datacenterId;

    //    12位的序列号
    private long sequence;

    public SnowFlake(long workerId, long datacenterId, long sequence) {

        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can not be greater than %d or less than 0", maxWorkerId));
        }

        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can not be greater than %d or less than 0", maxWorkerId));
        }

        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, worker id %d", timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    //    初始时间戳
    private long twepoch = 1288834974657L;

    //    机房  机器id 长度是5位
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;

    //    最大值
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    //    序列号长度id
    private long sequenceBits = 12L;
    //    序列号最大值
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    //    工作id左移12位
    private long workerIdShift = sequenceBits;
    //    数据id左移17位
    private long datacenterIdShift = sequenceBits + workerIdBits;
    //    时间戳左移22位
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    //    上次时间戳 初始值为-1
    private long lastTimestamp = -1L;

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestampLeftShift() {
        return System.currentTimeMillis();
    }

    //    获取时间戳，并与上次时间戳相比较
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }


    public synchronized long nextId() {

        long timestamp = timeGen();

//        获取当前时间戳如果小于上次时间戳，则时间戳获取出现异常   一般是系统时间发生了回调
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards. Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }


//        获取当前时间戳如果等于上次时间戳(同一毫秒内) 则在序列号+1 否则序列号赋值为0 从0开始
        if (timestamp == lastTimestamp) {
//            与掩码进行交运算
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

//        更新上时间戳的值
        lastTimestamp = timestamp;

        /**
         * 返回结果：
         * (timestamp - twepoch) << timestampLeftShift) 表示将时间戳减去初始时间戳，再左移相应位数
         * (datacenterId << datacenterIdShift) 表示将数据id左移相应位数
         * (workerId << workerIdShift) 表示将工作id左移相应位数
         * | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1。
         * 因为个部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
         */

        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;

    }

    public static void main(String[] args) {

        SnowFlake worker = new SnowFlake(1, 1, 1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        }

    }


}
