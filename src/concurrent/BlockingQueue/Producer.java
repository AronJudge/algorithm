package concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(1);
            Thread.sleep(200);
            blockingQueue.put(2);
            Thread.sleep(200);
            blockingQueue.put(3);
            Thread.sleep(200);
            blockingQueue.put(4);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
