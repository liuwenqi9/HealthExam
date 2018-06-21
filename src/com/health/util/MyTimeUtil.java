package com.health.util;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.Locale; 


public class MyTimeUtil {
	
    public void getTimeNowThroughCalendar(){  
        //使用默认时区和语言环境获得一个日历。  
        Calendar    rightNow    =    Calendar.getInstance();     
        /*用Calendar的get(int field)方法返回给定日历字段的值。 
        HOUR 用于 12 小时制时钟 (0 - 11)，HOUR_OF_DAY 用于 24 小时制时钟。*/  
        Integer year = rightNow.get(Calendar.YEAR);   
        Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1  
        Integer day = rightNow.get(rightNow.DAY_OF_MONTH);  
        Integer hour12 = rightNow.get(rightNow.HOUR);   
        Integer hour24 = rightNow.get(rightNow.HOUR_OF_DAY);  
        Integer minute = rightNow.get(rightNow.MINUTE);  
        Integer second = rightNow.get(rightNow.SECOND);  
        Integer millisecond = rightNow.get(rightNow.MILLISECOND);  
        String TimeNow12 = year+"-"+month+"-"+day+" "+hour12+":"+minute+":"+second+":"+millisecond;  
        String TimeNow24 = year+"-"+month+"-"+day+" "+hour24+":"+minute+":"+second+":"+millisecond;  
        System.out.println("日历："+rightNow+"\n12小时制时钟："+TimeNow12+"\n24小时制时钟："+TimeNow24);  
   }  
      
   /** 
    * 通过Date类获取 
    */  
   public void getTimeNowThroughDate(){  
        Date date=new Date();  
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        System.out.println(format.format(date));    
       }  
     
    /** 
     */  
    public static  String getTimeNowTogether(){  
       String TimeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());  
	   return TimeNow;  
   }

}  

