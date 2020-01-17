package xpffly.util.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xpengfei
 * @Date: 2020/1/17 13:14
 * @Description：日期工具类测试类
 */
public class DateTimeUtilTest {
    private static Logger logger = LoggerFactory.getLogger(DateTimeUtilTest.class);

    @Test
    public void getNowDateTest(){
        String nowDate = DateTimeUtil.getNowDate();


        logger.info("当前日期，nowDate={}",nowDate);
    }
}
