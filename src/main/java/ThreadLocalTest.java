/**
 * 〈一句话功能简述〉<br>
 * 〈ThreadLocal的使用〉
 *
 * @author lixuanfeng
 * @create 2019/1/28
 * @since 1.0.0
 */
public class ThreadLocalTest {

    //(1) 创建localVariable变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    //（2）print函数
    static void print(String str) {
        //1.1 打印当前线程本地内存中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        //1.2 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    //(3) 创建线程one
    public static void main1(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //3.1 设置线程one中的本地变量localVariable的值
                localVariable.set("threadOne local variable");
                //3.2 调用打印函数
                print("threadOne");
                //3.3 打印本地变量值
                System.out.println("threadOne remove after" + ":" +localVariable.get());

            }
        });

        //(4) 创建线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                //4.1 设置线程two中的本地变量localVariable的值
                localVariable.set("threadTwo local variable");
                //4.2 调用打印函数
                print("threadTwo");
                //4.3 打印本地变量值
                System.out.println("threadTwo remove after" + ":" +localVariable.get());

            }
        });

        threadOne.start();
        threadTwo.start();
    }


    /**
     * 功能描述: <br>
     * 〈ThreadLocal不支持继承〉
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("thread:" + threadLocal.get());
            }
        });

        thread.start();

        System.out.println("main:" + threadLocal.get());
    }
}