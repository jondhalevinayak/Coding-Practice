package com.local.coding_practice.Test;

public class ThreadMain extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("in Thread");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadMain();
        t.start();
        t.join();
        System.out.println("in main Thread");
    }
}
