package cn.lagrahhn.java8.LocalTime;

import java.time.LocalTime;

public class LocalTimeFunc {
    /**
     * 包含时分秒毫秒
     */
    public void timeWithMillisecond() {
        LocalTime now = LocalTime.now();
        System.out.println("当前时间含毫秒:" + now);
    }

    /**
     * 不包含毫秒
     */
    public void timeWithoutMillisecond() {
        LocalTime now = LocalTime.now().withNano(0);
        System.out.println("当前时间不含毫秒:" + now);
    }

    /**
     * 解析时间
     */
    public void parseTime() {
        LocalTime time = LocalTime.parse("08:30:00");
        System.out.println(time);
        LocalTime zero = LocalTime.parse("00:00:00");
        System.out.println(zero);
    }
}
