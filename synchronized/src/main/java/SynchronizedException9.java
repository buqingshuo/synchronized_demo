/**
 * 方法抛出异常后，会释放锁。展示不抛出异常前和抛出异常后的对比：一旦抛出了异常，第二个线程会立刻进入同步方法，意味着锁已经释放。
 *
 * @author buqingshuo
 * @date 2019/10/4
 */
public class SynchronizedException9 implements Runnable {

    private static SynchronizedException9 instance = new SynchronizedException9();

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
        System.out.println("我是抛出异常的加锁方法1，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    private synchronized void method2() {
        System.out.println("我是不抛出异常的加锁方法2，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
