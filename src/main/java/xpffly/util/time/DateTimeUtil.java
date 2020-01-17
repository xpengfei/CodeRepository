package xpffly.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xpengfei
 * @Date: 2020/1/17 9:00
 * @Description：日期工具类
 */
public class DateTimeUtil {

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm
     */
    private static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 日期时间格式yyyyMMddHHmmss
     */
    private static final String YYYYMMDD_HHMMSS = "yyyyMMddHHmmss";

    /**
     * 日期格式：yyyy-MM-dd
     */
    private static final String YYYY_MM_DD = "yyyy-MM-dd";


    /**
     * 时间格式HH:mm:ss
     */
    private static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 获取当前日期
     *
     * @return yyyy-mm-dd
     */
    public static String getNowDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return HH:mm:ss
     */
    public static String getNowTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HH_MM_SS);
        return simpleDateFormat.format(date);
    }
}
