package testtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TestTimeUtil {

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.getYear()+1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDay());


        Calendar calendar =  Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dom = calendar.get(Calendar.DAY_OF_MONTH);
        int doy = calendar.get(Calendar.DAY_OF_YEAR);
        int dow = calendar.get(Calendar.DAY_OF_WEEK);
        int dowim = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(year+"年"+ month+"月");
        System.out.println(dom+"日");
        System.out.println(doy+"日");
        System.out.println(dow+"日");
        System.out.println(dowim);

        int hour = calendar.get(Calendar.HOUR);
        int hod = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hod+"h");

        int second = calendar.get(Calendar.SECOND);
        System.out.println(second+"s");

        System.out.println("========================");

        //LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期："+localDate.getYear()+" 年 "+localDate.getMonthValue()+" 月 "+localDate.getDayOfMonth()+"日" );
        LocalDate pluslocalDate = localDate.plusDays(1);
        System.out.println("增加一天日期是："+pluslocalDate.getYear()+" 年 "+pluslocalDate.getMonthValue()+" 月 "+pluslocalDate.getDayOfMonth()+"日" );

        //LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间："+localTime.getHour()+"h "+localTime.getSecond()+"m "+localTime.getMinute()+"s" );

        //LocalDateTime
        LocalDateTime now = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
                ZoneId.systemDefault());

        System.out.println("当前日期："+now.getYear()+" 年 "+now.getMonthValue()+" 月 "+now.getDayOfMonth()+"日" );


        //Period  时期  一段时间
        LocalDate startDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(1601175465000L), ZoneId.systemDefault()).toLocalDate();
        Period p  =  Period.between(startDate,  LocalDate.now());
        System.out.println("目标日期距离今天的时间差："+p.getYears()+" 年 "+p.getMonths()+" 个月 "+p.getDays()+" 天" );

        //Duration 期间 持续时间
        LocalDateTime end = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault());
        LocalDateTime start = LocalDateTime.ofInstant(Instant.ofEpochMilli(1601175465000L), ZoneId.systemDefault());
        Duration duration = Duration.between(start, end);

        System.out.println("开始时间到结束时间，持续了"+duration.toDays()+"天");
        System.out.println("开始时间到结束时间，持续了"+duration.toHours()+"小时");
        System.out.println("开始时间到结束时间，持续了"+duration.toMillis()/1000+"秒");


        //格式化
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime.parse("2021-10-28 00:00:00", dateTimeFormatter1);



    }
}
