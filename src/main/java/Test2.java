/**
 * 〈一句话功能简述〉<br>
 * 〈当一个线程调用共享对象的wait（）方法被阻塞挂起后，如果其他线程中断了该线程，
 * 则线程会抛出InterruptedException异常并返回〉
 *
 * @author lixuanfeng
 * @create 2019/1/24
 * @since 1.0.0
 */
public class Test2 {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("----begin----");
                    //阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("----end----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }

}