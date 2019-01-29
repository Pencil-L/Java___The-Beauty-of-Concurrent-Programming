import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 〈一句话功能简述〉<br>
 * 〈创建任务类，类似Runable〉
 *
 * @author lixuanfeng
 * @create 2019/1/24
 * @since 1.0.0
 */
public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) throws InterruptedException {
        //创建异步任务
        FutureTask<String> futuretask = new FutureTask<>(new CallerTask());

        //启动线程
        new Thread(futuretask).start();

        try {
            //等待任务执行完成，并返回结果
            String result = futuretask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}