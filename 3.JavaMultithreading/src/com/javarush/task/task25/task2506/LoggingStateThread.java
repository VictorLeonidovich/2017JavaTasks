package com.javarush.task.task25.task2506;

/**
 * Created by Victor on 15.09.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State threadState = target.getState();
        System.out.println(threadState);

        while (threadState != State.TERMINATED){
            if (target.getState() != threadState){
                threadState = target.getState();
                System.out.println(threadState);
            }

        }

    }
}
