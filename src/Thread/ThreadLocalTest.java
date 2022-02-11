package Thread;

public class ThreadLocalTest {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    static class ADDThread extends Thread{
        @Override
        public void run() {
            Integer integer = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"----初始值----"+integer);

            integer +=100;
            System.out.println(Thread.currentThread().getName()+"----线程 操作int+100 ----");

            threadLocal.set(integer);
            System.out.println(Thread.currentThread().getName()+"----调用set存放新的integer到threadlocal，保存修改");

            System.out.println(Thread.currentThread().getName()+"----当前线程的副本值"+threadLocal.get());

        }
    }

    static class SubThread extends Thread{
        @Override
        public void run() {
            Integer integer = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"----初始值----"+integer);
        }
    }
    public static void main(String[] args) {
        new ADDThread().start();
        new SubThread().start();
    }
}
