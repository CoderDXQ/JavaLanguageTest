package com.example.writtenexaminationandinterview.elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/21 11:34 下午
 */

//有空需要再完善一下
public class Elevator1 {

    //    ？？？
    public static Queue<Request> currentQueue = new LinkedList<>();
    public static Queue<Request> upQueue = new LinkedList<>();
    public static Queue<Request> downQueue = new LinkedList<>();

    public enum Direction {
        UP, DOWN
    }

    public enum State {
        MOVING, STOPPED
    }

    public enum Door {
        OPEN, CLOSED
    }

    private float location = 0;
    private Direction direction = Direction.UP;
    private State state = State.STOPPED;
    private Door door = Door.CLOSED;
    private Thread processingThread;
    private Thread listeningThread;

    public class Request {

        public long time;
        public Integer floor;
        public Direction direction;

        public Request(long time, Integer floor, Direction direction) {
            this.time = time;
            this.floor = floor;
            this.direction = direction;
        }
    }

    //    ???
    public void go(int floor) {

    }

    public void call(int floor, Direction direction) {

        if (direction == Direction.UP) {
            if (floor >= location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            } else {
                upQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            }
        } else {
            if (floor < location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            } else {
                downQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            }
        }

    }

    //???
    public class Listen implements Runnable {

        @Override
        public void run() {

        }
    }

    //???
    public class Process implements Runnable {

        @Override
        public void run() {

        }
    }

    public class Worker implements Runnable {
        private Socket s;

        public Worker(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

                String line;

                while (true) {
                    if ((line = reader.readLine()) != null) {
                        String[] tokens = line.split(" ");
                        if (tokens.length == 3 && tokens[0].equals("call")) {
                            call(Integer.parseInt(tokens[1]), tokens[2].equals("up") ? Direction.UP : Direction.DOWN);
                        } else if (tokens.length == 2 && tokens[0].equals("go")) {
                            go(Integer.parseInt(tokens[1]));
                        } else {
                            s.getOutputStream().write("Wrong input".getBytes());
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {

        Elevator1 elevator = new Elevator1();
        elevator.listeningThread = new Thread(elevator.new Listen());
        elevator.listeningThread.start();
        elevator.processingThread = new Thread(elevator.new Process());
        elevator.processingThread.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
