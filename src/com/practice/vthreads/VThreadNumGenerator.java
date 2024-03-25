package com.practice.vthreads;

public class VThreadNumGenerator {



    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println("From virtual thread: "+ i);
                }
            }
        };
        for(int i=0;i<10;i++){
            System.out.println("Thread starting : "+i);
            new Thread(task).start();
        }
    }
}
