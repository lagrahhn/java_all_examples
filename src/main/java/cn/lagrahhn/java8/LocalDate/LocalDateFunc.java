package cn.lagrahhn.java8.LocalDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class LocalDateFunc {

    public void plus() {
        LocalDate date = LocalDate.now();
        System.out.println("当前时间:" + date);
        System.out.println("增加一天:" + date.plusDays(1));
        System.out.println("增加一个月:" + date.plusMonths(1));
        System.out.println("增加一年:" + date.plusYears(1));
    }

    public void calculate() {
        LocalDate today = LocalDate.now();
        System.out.println("今天是:" + today);
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("这个月的第一天是:" + firstDayOfThisMonth);

        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println("这个月的第二天：" + secondDayOfThisMonth);

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天：" + lastDayOfThisMonth);

        // 取下一天：
        LocalDate nextDay = lastDayOfThisMonth.plusDays(1);
        System.out.println("plusDays(1)加一天后为：" + nextDay);

        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("2015年1月第一个周一" + firstMondayOf2015);
    }

    /**
     * 将字符串解析为LocalDate
     * 例如：2020-01-01
     * 转换后为：2020-01-01
     */
    public void parseString() {
        LocalDate date = LocalDate.parse("2020-01-01");
        System.out.println(date);
    }

    /**
     * 仅含年月日
     */
    public void today() {
        System.out.println("当前时间(年月日):" + LocalDate.now());
    }

}
