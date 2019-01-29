/**
 * 〈一句话功能简述〉<br>
 * 〈当前线程为了等待一些特定条件的到来时，一般会调用sleep函数、wait函数、join函数来阻塞挂起当前线程〉
 *
 * @author lixuanfeng
 * @create 2019/1/28
 * @since 1.0.0
 */
public class Test7 {

    public static void main1(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne begin sleep for 2000 second");
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is Interrupted while sleeping");
                    return;
                }
                System.out.println("threadOne-leaving normally");
            }
        });

        //启动线程
        threadOne.start();

        //确保子线程进入休眠状态
        Thread.sleep(1000);

        //打断子线程的休眠，让子线程从sleep函数返回
        threadOne.interrupt();

        //等待子线程执行完毕
        threadOne.join();

        System.out.println("main thread is over");
    }

    /**
     * 功能描述: <br>
     * 〈interrupted()与isInterrupted()方法的不同之处〉
     *
     * @param
     * @return:
     * @since: 1.0.0
     * @Author:lixuanfeng
     * @Date: 2019/1/28 3:02 PM
     */
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }

            }
        });
        //启动线程
        threadOne.start();

        //设置中断标志
        threadOne.interrupt();

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());

        //获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");
    }
}