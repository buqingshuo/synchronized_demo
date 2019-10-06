/**
 * 对象锁示例2，方法锁形式
 *
 * @author buqingshuo
 * @date 2019/10/4
 */
public class SynchronizedObjectMethod3 implements Runnable {

    private static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

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
        method();
    }

    private synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
