# java8time
java8的时间类，LocalDate、LocalTime、LocalDateTime  
还有处理他们的类Period、Duration  
格式化类DateTimeFormatter  
简单使用 https://juejin.cn/post/7024389549652443172

Android 简单处理 发布时间与当前时间差
```
val tv_time6 = findViewById<TextView>(R.id.tv_time6)
val end = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())
val start = LocalDateTime.ofInstant(Instant.ofEpochMilli(1635303465000L), ZoneId.systemDefault())
val duration = Duration.between(start, end)

//Long
// time <1小时内             显示  分钟 前
// 1小时<  time  < 24h       显示  小时 前
// time > 24h               显示  昨天：几时 几分
// time >  48h              显示  月-日
if(duration.toMinutes()<60){
    tv_time6.text = "${duration.toMinutes()}分钟前"
}else if(duration.toMinutes()>60 && duration.toHours()<24){
    tv_time6.text = "${duration.toHours()}小时前"
}else if(duration.toHours() in 24..48){
    tv_time6.text = "昨天 ${start.hour}:${start.minute} "
}else{
    tv_time6.text = "${start.toLocalDate().monthValue}-${start.dayOfMonth} "
}
```
