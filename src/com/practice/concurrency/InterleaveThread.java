package com.practice.concurrency;

class PrintSequenceRunner implements Runnable{
    public int PRINT_NUMBERS_UPTO = 10;
    static int number = 1;
    int remainder;
    static Object lock = new Object();

    PrintSequenceRunner(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}

public class InterleaveThread {
    public static void main(String[] args) {
        PrintSequenceRunner p1 = new PrintSequenceRunner(1);
        PrintSequenceRunner p2 = new PrintSequenceRunner(2);
        PrintSequenceRunner p3 = new PrintSequenceRunner(0);

        Thread t1 = new Thread(p1, "T1");
        Thread t2 = new Thread(p2, "T2");
        Thread t3 = new Thread(p3, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
