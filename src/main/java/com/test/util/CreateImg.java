package com.test.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

/**
 * 生成验证码
 * 
 * @author 王南北
 * @date 2018年4月27日
 */
public class CreateImg {

	public void getImg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		BufferedImage bfi = new BufferedImage(200, 50, BufferedImage.TYPE_INT_BGR);
		Graphics g = bfi.getGraphics();
		g.fillRect(0, 0, 200, 50);
		// 生成验证码的范围
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

		Random r = new Random();
		int index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(ch.length);
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			Font f = new Font("宋体", 30, 50);
			g.setFont(f);
			g.drawString(ch[index] + "", (i * 50) + 2, 43);
			sb.append(ch[index]);
		}

		// 添加噪点
		int area = (int) (0.02 * 200 * 50);
		for (int i = 0; i < area; i++) {
			int x = (int) (Math.random() * 200);
			int y = (int) (Math.random() * 50);
			bfi.setRGB(x, y, (int) Math.random() * 255);
		}

		// 生成干扰线
		for (int i = 0; i < 6; i++) {
			int xstart = (int) (Math.random()*200);
			int ystart = (int) (Math.random()*50);
			int xend = (int) (Math.random()*200);
			int yend = (int) (Math.random()*50);
			g.setColor(interLine(1,255));
			g.drawLine(xstart, ystart, xend, yend); 
		}
		HttpSession session = request.getSession();		
		session.setAttribute("verificationCode", sb.toString());
		ImageIO.write(bfi, "JPG", response.getOutputStream());
		

	}
	
	
	public static Color interLine(int low , int high){
		if(low > 255){
			low = 255;
		}
		if(high > 255){
			high = 255;
		}
		if(low < 0){
			low = 0;
		}
		if(high < 0){
			high = 0;
		}
		
		int i = high - low;
		int r = low + (int) (Math.random()*i);
		int g = low + (int) (Math.random()*i);
		int b = low + (int) (Math.random()*i);
		return new Color(r,g,b);
		
	}
}
