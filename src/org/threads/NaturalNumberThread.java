package org.threads;

import java.util.concurrent.Semaphore;

class NaturalNumberThread implements Runnable{

    static int num = 1;
    static boolean flag = true;
    static int current = 1;

    String threadName;
    Semaphore semaphore;
    int M,N;

    NaturalNumberThread(String threadName,Semaphore semaphore,int noOfThreads,int max){
        this.threadName = threadName;
        this.semaphore = semaphore;
        this.M = max;
        this.N = noOfThreads;
    }

    public void run(){
        while(flag){
            try{
                semaphore.acquire();
                if(num>M){
                    flag = false;
                }
                else if(String.valueOf(current).equalsIgnoreCase(threadName)){
                    System.out.println("Thread-"+threadName + "::"+num);
                    num++;
                    if(current==N){
                        current = 1;
                    }else{
                        current+=1;
                    }
                }


                semaphore.release();

            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}