/**
 * 〈一句话功能简述〉<br>
 * 〈根据中断标志判断线程是否终止〉
 *
 * @author lixuanfeng
 * @create 2019/1/28
 * @since 1.0.0
 */
public class Test6 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        //启动子线程
        thread.start();

        //主线程休眠1s，以便中断前让子线程输出
        Thread.sleep(1000);

        //中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();
        System.out.println("main is over");
    }

}