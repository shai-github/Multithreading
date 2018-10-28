package org.threads;

import java.util.concurrent.Semaphore;

public class PrintOddEven implements Runnable{

    static int num =1;
    static boolean flag = true;
    static String current = "odd";

    String threadName;
    Semaphore semaphore;
    int max;

    PrintOddEven(String threadName,Semaphore semaphore,int max){
        this.threadName = threadName;
        this.semaphore = semaphore;
        this.max = max;
    }

     public void run(){
        while(flag){
            try{
                semaphore.acquire();
                if(num>max){
                    flag= false;
                }else if(current.equalsIgnoreCase("odd") && threadName.equalsIgnoreCase("odd")){
                    System.out.println("Thread-"+threadName+":"+num);
                    num++;
                    current="even";
                }else if(current.equalsIgnoreCase("even") && threadName.equalsIgnoreCase("even")){
                    System.out.println("Thread-"+threadName+":"+num);
                    num++;
                    current="odd";
                }

                semaphore.release();

            }catch(InterruptedException ie){
                ie.printStackTrace();
            }

        }

    }

}
