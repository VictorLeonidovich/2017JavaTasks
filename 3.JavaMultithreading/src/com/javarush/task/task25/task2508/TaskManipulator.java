package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String name;

    @Override
    public void run() {
        try {
            while (!this.thread.isInterrupted()) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);


            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this);
        //this.name = threadName;
        this.thread.setName(threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}
