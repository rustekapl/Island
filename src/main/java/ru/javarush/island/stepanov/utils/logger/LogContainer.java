package ru.javarush.island.stepanov.utils.logger;

import java.util.concurrent.locks.ReentrantLock;

public class LogContainer {

    private final StringBuilder logContainer = new StringBuilder();
    private final ReentrantLock lock = new ReentrantLock();

    public LogContainer() {
    }

    public void writeLog(String message){
        this.lock.lock();
        try{
            logContainer.append(message);
            logContainer.append("\n");
        } finally {
            this.lock.unlock();
        }
    }

    public String getLog(){
        this.lock.lock();
        try{
            return logContainer.toString();
        } finally {
            this.lock.unlock();
        }
    }
}
