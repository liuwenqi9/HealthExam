package com.health.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 生成BigDecimal随机数
 * @author JSY
 * @date 7月9日
 */
public class FormatConversionUtil {

	
	public  static BigDecimal createNum(BigDecimal a,BigDecimal b) {
		double  c=	a.subtract(b).doubleValue();
		System.out.println("工具类---差值:"+c);
		double bb=b.doubleValue();
		System.out.println("工具类---测试bb:"+bb);
		double boundedDouble = bb + new Random().nextDouble() * c;
			System.out.println("工具类---生成的随机数"+boundedDouble);
			BigDecimal cc=new BigDecimal(boundedDouble);
			BigDecimal dd=	cc.setScale(1,BigDecimal.ROUND_DOWN);
			System.out.println("工具类----转成big的cc:"+cc);
			System.out.println("工具类----保留一位小数:"+dd);
		
		return dd;
		
	}
}
