//import org.junit.Test;

//import java.util.logging.Logger;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author lixuanfeng
 * @create 2019/1/21
 * @since 1.0.0
 */

public class MyTest {

    @Test
    public void testLoger(){

        final Logger logger = Logger.getLogger("TestErrOut");
        logger.debug(" This is debug!!!");
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.fatal(" This is fatal!!!");

    }

}