/**
 * 〈一句话功能简述〉<br>
 * 〈当前线程调用共享变量的wait（）方法后只会释放当前共享变量上的锁，
 * 如果当前线程还持有其他共享变量的锁，则这些锁是不会被释放的〉
 *
 * @author lixuanfeng
 * @create 2019/1/24
 * @since 1.0.0
 */
public class Test1 {

    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("线程A获得resourceA的锁");
                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("线程A获得resourceB的锁");

                            //线程A阻塞，并释放获取到的resourceA锁
                            System.out.println("线程A释放resourceA的锁");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //休眠1秒
                    Thread.sleep(1000);
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("线程B获得resourceA的锁");
                        System.out.println("线程B尝试获得resourceB的锁");

                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("线程B获得resourceB的锁");

                            //线程B阻塞，并释放获取到的resourceA锁
                            System.out.println("线程B释放resourceA的锁");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }
}