package concurrent.Mydemo;

import Stack.ArrayStack.ArrayStack;

import java.util.ArrayList;

public class MyDemo {

    static final int MAX = 10;

    static ArrayList<Object> goods = new ArrayList<>(MAX);

    public static void main(String[] args) {
        (new Producer()).start();
        (new Consumer()).start();
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (goods) {
                    if (goods.size() <= MAX) {
                        goods.add(new Object());
                        System.out.println("produce goods :" + goods.size() );
                        goods.notifyAll();
                    } else {
                        try {
                            goods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (goods) {
                    if (goods.size() > 0) {
                        goods.remove(0);
                        System.out.println("Consumer goods :" + goods.size());
                        goods.notifyAll();
                    } else {
                        try {
                            goods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
