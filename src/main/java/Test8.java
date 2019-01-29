/**
 * 〈一句话功能简述〉<br>
 * 〈多线程---Java指令重排序会出现的问题〉
 *
 *
 * @author lixuanfeng
 * @create 2019/1/29
 * @since 1.0.0
 */
public class Test8 {

    public static class ReadThread extends Thread{

        public void run(){

            while(!Thread.currentThread().isInterrupted()){
                if (ready){//(1)
                    System.out.println(num+num);//2
                }
                System.out.println("read thread....");
            }
        }

    }

    public static class WriteThread extends Thread{
        public void run(){
            num = 2;//(3)
            ready = true;//(4)
            System.out.println("WriteThread set over....");
        }
    }

    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }
    /**
     * 功能描述: <br>
     * 〈总结〉
     *  使用volatile修饰ready就可以避免重排序和内存可见性问题
     *
     *  写volatile变量时，可以确保volatile写之前的操作不会被编译器重排序到
     *  volatile写之后。度volatile变量时，可以确保volatile度之后的操作不
     *  会被编译器重排序到volatile度之前。
     */
}