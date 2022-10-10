package Interviews.informatica;

/**
 * T1, T2, T3 - Even, Odd, Prime - Array of numbers
 */


public class EvenOddPrimeInterleaveThread {


    private static boolean isPrime(int i){
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Numbers();
        Thread t2 = new Numbers();
        Thread t3 = new Numbers();
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

class Numbers extends Thread{

    private int num;

    public void run(){
        if (num < 10) {
            if (num % 2 == 0) {
                System.out.println("Number is even : " + num + " and thread name " + this.getThreadGroup().getName());
                num++;
            } else if (num % 2 != 0) {
                System.out.println("Number is odd : " + num + " and thread name " + this.getThreadGroup().getName());
                num++;
            } else if (isPrime(num)) {
                System.out.println("Number is prime : " + num + " and thread name " + this.getThreadGroup().getName());
                num++;
            }
        }
    }

    private boolean isPrime(int n){
        return false;
    }

}
