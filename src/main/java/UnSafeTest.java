import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 〈一句话功能简述〉<br>
 * 〈Unsale类〉
 *
 * @author lixuanfeng
 * @create 2019/1/29
 * @since 1.0.0
 */
public class UnSafeTest {

    /**
     * 功能描述: <br>
     * 〈静态变量初始化异常代码〉
     * @Author:lixuanfeng
     * @Date: 2019/1/29 2:52 PM
     */
/*
    //获取Unsafe的实例(2.2.1)
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类UnSafeTest中的偏移值(2.2.2)
    static final long stateOffset;

    //变量(2.2.3)
    private volatile long state = 0;

    static {
        //获取state变量在类UnSafeTest中的偏移值(2.2.4)
        try {
            stateOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        //创建实例，并且设置state值为1(2.2.5)
        UnSafeTest test = new UnSafeTest();

        boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);

    }

*/
    /**
     * 功能描述: <br>
     * 〈利用反射规避异常〉
     *
     * @since: 1.1.0
     * @Author:lixuanfeng
     * @Date: 2019/1/29 2:53 PM
     */
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {

        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存值
            field.setAccessible(true);

            //获取该变量的值
            unsafe = (Unsafe) field.get(null);

            //获取state在UnSafeTest中的偏移量
            stateOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        UnSafeTest test = new UnSafeTest();

        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);

    }
}