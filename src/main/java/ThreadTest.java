/**
 * 〈一句话功能简述〉<br>
 * 〈继承Thread类〉
 *
 * @author lixuanfeng
 * @create 2019/1/24
 * @since 1.0.0
 */
public class ThreadTest {

    //继承Thread类并重run方法
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello.....");
        }

        public static void main(String[] args) {
            //创建线程
            MyThread thread = new MyThread();
            //启动线程
            thread.start();
        }
    }
}