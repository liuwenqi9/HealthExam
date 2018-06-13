package com.health.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	private static final char[] chars = {'0', '1', '2', '3', '4', '5', '6',
										 '7', '8', '9', 'A', 'B', 'C', 'D',
										 'E', 'F', 'G', 'H', 'I', 'J', 'K',
										 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
										 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
										 'Z'};
	private static final int SIZE = 4;
	private static final int LINES = 5;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 40;
	private static final int FONT_SIZE = 30;
	/*
	 * 获得随机颜色
	 */
	private static Color getRandomColor() {
		Random random = new Random();
		Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		return color;
	}
	/*
	 * 生成验证码图片，封装于Map中。其中Map的key值为验证码，value值为验证码的图片
	 */
	public static Map<String, BufferedImage> creatImage() {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_BGR);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Random random = new Random();
		//画出随机字符
		for (int i = 1; i <= SIZE; i++) {
			int r = random.nextInt(chars.length);
			graphics.setColor(getRandomColor());
			graphics.setFont(new Font(null, Font.BOLD, FONT_SIZE));
			graphics.drawString(chars[r] + "", (i - 1) * WIDTH / SIZE,
					HEIGHT / 2 + 10);
			stringBuffer.append(chars[r]);//追加四次保存到StringBuffer
		}
		//绘制干扰线
		for (int i = 1; i <= LINES; i++) {
			graphics.setColor(getRandomColor());
			graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), 
					random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String,BufferedImage>();
		map.put(stringBuffer.toString(), bufferedImage);
		return map;
	}
	/*
	 * 将图片转化为输入流
	 */
	public static InputStream getInputStream(BufferedImage bufferedImage)
			throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(byteArrayOutputStream);
		jpegImageEncoder.encode(bufferedImage);
		byte[] imageBytes = byteArrayOutputStream.toByteArray();
		InputStream inputStream = new ByteArrayInputStream(imageBytes);
		return inputStream;
	}

}
