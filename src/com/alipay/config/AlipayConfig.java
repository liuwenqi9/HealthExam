package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091400507613";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC8ySB0heBA1FP+G4UONYIFBGtw92S9U6p+jKhenkFxdEL6AS+jOycO0KUDLh1dLM7VJ3ku6GH66ioL7c+wToX82UuoEEpYsjLTjLvOPeEjCwBjXAlf8YNJYqcGyLoYQTCSP2FN9pFVCTQjpIXb4X5zXz4T+Vplw5+wnnKzmH3N35w8FHUqGISbMjKD8E1sb1FCfdl4F1xGoEEXz6I7RGUd5aXWnVJBIkeHf+l46gu3gaYvPkqQGJexA+x5mV5myCP51LfkIOXZHNMjf4jT3GveCxKH6RWKZ4zuThER+/IHD8EMovXijaWNnKsaxhnjkfQdfas7S9+oQ645UOhxhpeVAgMBAAECggEAdntYJilba/SWXlWRNTC50EJM2BI8JGKdD11h0jhKZFUOL++MoUpfofmqhotrnG2hxb9HW/w2eg56ow/2l/VAPEd4JxtKPc5g/cpGmBLX+HFQJgu+Snu95NHIeAaEXPKU9ERY4mBMJ+1lzrTT2gL0pJ3yzQBjDpku4N8gp7ydwBVwmdeKIWTqDQd6a7rQkQoYaPOCU1CPuQfRmHmHKrlw7iL8NoGw6Un3LkYbRxDnobIiTp3gCGYhONGzk1KndcAYWYLTTSTnzCfOllA10OoKHBm+5xK1zQ/zTtJvDWZtvvf9Sg5pebENJ58LHZft20T/auf68qEL2nWipo5yZMnVYQKBgQDy9ZfwTci8UOhPgNY/nc7SNTK/BICQqrYHQghrJcGoUgKG87S9ddiuVBZwE+WatOVmoKS2VMICRXo/CM7YLXdSsC4OweuSOFiBqSiOerWIvm0mo2+VhBaoA2aBGXhgu2/4DBxWCtuIsSHUyflCWO2RkxuzW87kpnVmfQJC3Wp4fQKBgQDG6yeBXPSfZ6zVV8ct58Fhlk8ybwo8+Da3FdjxgqnoSUhwcVuxGd3QcZaQUqL+cOUoCCQwpuzwiKRLj8Kok/PceYZqS9CHcuLJU6ikdlfre0Kb4K4suuaxB4YwPX3gvhRI4WH8jHNJ2birDgQlUM2iKCWFglbxSciSdb0cZlfe+QKBgQDWewaxhglibU5X+RWqPWa6XWo6BQB2Na3SBHIoHMG0FQnUFsqEwscRRnw0Xuw/wdgN3Fzr9TD8DleX0+++GY0P+yX9syWCBKnldO6vsRYW7HyxMnCsHlpd4fqYl2KUioOTByXws08Qgcaq8c5Qyu6Wp7Y5hR/E7EoRuuPHIW3/hQKBgCFKSZpEzEvBNhOeVR9BogOK/EYcf0Ik6ENLzLree0D8wrrOveGtyomP+Pq+Wbjre+5vLl9WEGFQ/O4IaTN9T1qem/g+J/ADMiEvdxHPHHe0cTlVKNEjlmgaMkLwh5iNNyfbUGLLvp+laFp4RglYtJFm1qC5Z4OKLZ8VRUjzd9FBAoGBAJPnZqLETQwYczQ9RyiCDkRXZ8DrKimqywZx4Qh2frYWZ14Y6sRhNWrGunxjkqRKjmiqaOtD4qetR7lkHAA0qpjeVl3nLzan4XiNvupM7nuh8MAXxEkPgujBzCOYckxe0FNRtIazL6QG2p0uUdT3JJOPSPjZwwKZrGt/BLEO4mQ1";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoDXox3Z91t/9E+Bj/zG9RDr4t6hrEgybMcZ2iNpdUHxYjKOymvozL3nrSRt/2MqLGA25u39PjqttdI3Gew+3yoXhvhhufuHVVMRMeVoEOQyLfS0CW0LftLwj3tMw85WHZc0RMQdKiGyJD2f14rlkPuRZUjCdnEU7XplHtDSZOERCD/vg9tWy/R/9Mly1A8MCr4hsHbt4/7FmwIncaewTTsHuYPq60nlzuocjj839gtNg5GKMSQvw/UQFVzT+LG0q/T1iPZWp41kJk5NQ+Y7gHnYEVXG30Hr9GT/QzC8v7ou3v3XEzPnPGvdw0dCa9Fj7LQ+sNYNUHrkOigrfvywqpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8580/HealthExamSystem/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8580/HealthExamSystem/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

