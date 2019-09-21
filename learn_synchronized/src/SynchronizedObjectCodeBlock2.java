/**
 * 对象锁示例1，代码块形式
 * @author buqingshuo
 * @date 2019/9/21
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

    private static Runnable instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() + " 拿到了lock1锁，");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1部分完成。");
        }

        synchronized (lock2){
            System.out.println(Thread.currentThread().getName() + " 拿到了lock2锁，");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2部分完成。");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        // 通过isAlive方法，直到两个线程都结束执行才执行while后的语句
        while (thread1.isAlive() || thread2.isAlive()){}
        System.out.println("finished.");
    }
}
