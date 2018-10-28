package org.threads;


import java.util.concurrent.Semaphore;

public class PrintNaturalNumbers {

    public static void main(String[] args){
       // printNaturalNumbers(100,7);
        printEvenOddNumbers(20);
    }

    public static void printNaturalNumbers(int M,int N){
        Semaphore semaphore = new Semaphore(1);
        for(int i=0;i<N;i++){
            String name = String.valueOf(i+1);
            new Thread(new NaturalNumberThread(name,semaphore,N,M)).start();
        }
    }

    public static void printEvenOddNumbers(int N){
        Semaphore semaphore = new Semaphore(1);
        new Thread(new PrintOddEven("odd",semaphore,N)).start();
        new Thread(new PrintOddEven("even",semaphore,N)).start();
    }
}