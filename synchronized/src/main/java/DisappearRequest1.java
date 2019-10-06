/**
 * 消失的请求数
 * @author buqingshuo
 * @date 2019/9/21
 */
public class DisappearRequest1 implements Runnable {

    private static Runnable instance = new DisappearRequest1();
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        // 使用join方法可以保证线程按照我们希望的顺序执行完毕
        thread1.join();
        thread2.join();
        System.out.println("num : " + num);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            // count ++ ，看上去只是一个操作，实际上却包含了3个动作：
            // 1.读取count
            // 2.将count加1
            // 3.将count的值写入内存中
            // 不用synchronized的情况下每一步都可能出现线程同步问题
            num ++;
        }
    }
}
