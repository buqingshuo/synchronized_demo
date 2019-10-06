/**
 * 同时访问同步方法和非同步方法
 *
 * @author buqingshuo
 * @date 2019/10/4
 */
public class SynchronizedYesAndNo6 implements Runnable {

    private static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    private synchronized void method1() {
        System.out.println("我是加锁的方法，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    private void method2() {
        System.out.println("我是没加锁的方法，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
