/**
 * 类锁的第一种形式，static方法锁
 * @author buqingshuo
 * @date 2019/10/4
 */
public class SynchronizedClassStatic4 implements Runnable {

    private static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    private static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    // 若不加static修饰符，不同的Runnable对象是可以同时调用该方法的
    private static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static形式，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
