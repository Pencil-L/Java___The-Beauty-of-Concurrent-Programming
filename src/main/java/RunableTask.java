/**
 * 〈一句话功能简述〉<br>
 * 〈实现Runable接口〉
 *
 * @author lixuanfeng
 * @create 2019/1/24
 * @since 1.0.0
 */
public class RunableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("I am a child thread");
    }

    public static void main(String[] args) throws InterruptedException{
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
