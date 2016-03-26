package com.group.renshi.action.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.ResponseMessage;
import com.group.webFramework.uitl.SessionControl;

/**
 * 总体说明 
 * 	验证码
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CheckCodeController.java,v 0.1 2015-5-27 下午7:05:46 Exp $
 */
@Controller
@RequestMapping("/common")
@Scope("prototype")
public class CheckCodeController extends BaseController {

	/**
	 * 生成验证码
	 * 
	 * @param response
	 */
	@RequestMapping(value = "createCode", method = RequestMethod.GET)
	public void createCode(HttpServletResponse response) {
		// 设置不缓存图片  
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);

		// 指定生成的响应图片,一定不能缺少这句话,否则错误.  
		response.setContentType("image/jpeg");
		// 指定生成验证码的宽度和高度  
		int width = 92, height = 37;
		// 创建BufferedImage对象,其作用相当于一图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 创建Graphics对象,其作用相当于画笔
		Graphics g = image.getGraphics();
		// 创建Grapchics2D对象
		Graphics2D g2d = (Graphics2D) g;

		Random random = new Random();
		// 定义字体样式
		Font mfont = new Font("楷体", Font.BOLD, 25);

		g.setColor(getRandColor(200, 250));
		// 绘制背景
		g.fillRect(0, 0, width, height);
		// 设置字体
		g.setFont(mfont);
		g.setColor(getRandColor(180, 200));

		// 绘制100条颜色和位置全部为随机产生的线条,该线条为2f  
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); //定制线条样式  
			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line); //绘制直线  
		}
		// 输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。  
		String sRand = "";
		String ctmp = "";
		int itmp = 0;
		// 制定输出的验证码为四位  
		for (int i = 0; i < 4; i++) {
			switch (random.nextInt(3)) {
			case 1: // 生成A-Z的字母  
				itmp = random.nextInt(26) + 65;
				ctmp = String.valueOf((char) itmp);
				break;
			/*case 2: // 生成汉字  
				String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
						"d", "e", "f" };
				// 生成第一位区码  
				int r1 = random.nextInt(3) + 11;
				String str_r1 = rBase[r1];
				// 生成第二位区码  
				int r2;
				if (r1 == 13) {
					r2 = random.nextInt(7);
				} else {
					r2 = random.nextInt(16);
				}
				String str_r2 = rBase[r2];
				// 生成第一位位码  
				int r3 = random.nextInt(6) + 10;
				String str_r3 = rBase[r3];
				// 生成第二位位码  
				int r4;
				if (r3 == 10) {
					r4 = random.nextInt(15) + 1;
				} else if (r3 == 15) {
					r4 = random.nextInt(15);
				} else {
					r4 = random.nextInt(16);
				}
				String str_r4 = rBase[r4];
				// 将生成的机内码转换为汉字  
				byte[] bytes = new byte[2];
				// 将生成的区码保存到字节数组的第一个元素中  
				String str_12 = str_r1 + str_r2;
				int tempLow = Integer.parseInt(str_12, 16);
				bytes[0] = (byte) tempLow;
				// 将生成的位码保存到字节数组的第二个元素中  
				String str_34 = str_r3 + str_r4;
				int tempHigh = Integer.parseInt(str_34, 16);
				bytes[1] = (byte) tempHigh;
				ctmp = new String(bytes);
				break;*/
			default:
				itmp = random.nextInt(10) + 48;
				ctmp = String.valueOf((char) itmp);
				break;
			}
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110),
					random.nextInt(110));
			g.setColor(color);
			// 将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示  
			// 将文字旋转指定角度
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate((45) * 3.14 / 180, 15 * i + 8, 7);
			// 缩放文字
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1f)
				scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15 * i + 18, 14);
		}

		// 验证码放到session中
		SessionControl.setAttribute(request, SystemConstantType.CHECK_CODE, sRand);
		g.dispose(); // 释放g所占用的系统资源  
		try {
			// 输出图片
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			throw new ApplicationException("验证码生成异常", e);
		}
	}

	/**
	 * 该方法主要作用是获得随机生成的颜色
	 */
	private Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); //随机生成RGB颜色中的r值  
		g = s + random.nextInt(e - s); //随机生成RGB颜色中的g值  
		b = s + random.nextInt(e - s); //随机生成RGB颜色中的b值  
		return new Color(r, g, b);
	}

	/**
	 * 异步校验验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "checkCode", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage ajaxCheckCode(@RequestParam("checkCode") String checkCode) {
		// 判断是否为空
		if (null == checkCode || "".equals(checkCode)) {
			throw new ApplicationException("请填写验证码");
		}

		// 判断验证码是否过期
		Object object = SessionControl.getAttribute(request, SystemConstantType.CHECK_CODE);
		if (null == object) {
			throw new ApplicationException("验证码已经过期，请刷新页面");
		}

		String storeCheckCode = object.toString();

		Boolean flag = true;

		// 比较验证码
		if (!checkCode.trim().equalsIgnoreCase(storeCheckCode)) {
			flag = false;
		}

		return responseAjaxResult(flag);
	}
}
