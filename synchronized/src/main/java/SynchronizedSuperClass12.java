/**
 * 可重入粒度测试，调用父类的方法
 *
 * @author buqingshuo
 * @date 2019/10/5
 */
public class SynchronizedSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }

}

class TestClass extends SynchronizedSuperClass12 {
    @Override
    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }
}
