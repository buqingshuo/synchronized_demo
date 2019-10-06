/**
 * @author buqingshuo
 * @date 2019/10/5
 */
public class SynchronizedOtherMethod11 {

    public static void main(String[] args) {
        SynchronizedOtherMethod11 synchronizedOtherMethod11 = new SynchronizedOtherMethod11();
        synchronizedOtherMethod11.method1();
    }

    private synchronized void method1() {
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("我是method2");
    }
}
