package com.group.renshi.action.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group.webFramework.common.BaseController;
import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ImageShowController.java,v 0.1 2015-5-28 下午2:23:03 Exp $
 */
@Controller
@RequestMapping("/common")
@Scope("prototype")
public class ImageShowController extends BaseController {

	/**
	 * 图片显示
	 * 
	 * @param url
	 * @param response
	 */
	@RequestMapping(value = "showImage", method = RequestMethod.GET)
	public void showImage(@RequestParam("imageUrl") String url, HttpServletResponse response) {
		try {
			String imgFixed = url.substring(url.lastIndexOf(".") + 1);

			BufferedImage img = ImageIO.read(new File(url));
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/" + imgFixed);

			// 得到向客户端输出二进制数据的对象
			ServletOutputStream toClient = response.getOutputStream();
			ImageIO.write(img, imgFixed, toClient);
			toClient.close();
		} catch (Exception e) {
			throw new ApplicationException("显示图片异常", e);
		}
	}

	/**
	 * 图片视频
	 * 
	 * @param url
	 * @param response
	 */
	@RequestMapping(value = "showVideo", method = RequestMethod.GET)
	public void showVideo(@RequestParam("videoUrl") String url, HttpServletResponse response) {
		try {
			response.reset();
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			ServletOutputStream out = response.getOutputStream();

			byte[] bytes = new byte[0xffff];
			InputStream is = new FileInputStream(new File(url));
			int b = 0;
			while ((b = is.read(bytes, 0, 0xffff)) > 0) {
				out.write(bytes, 0, b);
			}
			is.close();
			out.flush();

		} catch (Exception e) {
			throw new ApplicationException("导出文件异常");
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param fileName
	 * @param url
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "downFile", method = RequestMethod.GET)
	public void downFile(HttpServletResponse response, @RequestParam("fileName") String fileName,
			@RequestParam("fileUrl") String url) throws ApplicationException {
		try {
			response.reset();
			response.setContentType("application/octet-stream;  charset=UTF-8");
			response.setHeader("Location", fileName);
			response.setHeader("Content-Disposition",
					"attachment; filename=" + new String(fileName.getBytes("GBK"), "ISO-8859-1")); // filename应该是编码后的(UTF-8)

			//            response.setContentType("application/x-download");
			//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			ServletOutputStream out = response.getOutputStream();

			byte[] bytes = new byte[0xffff];
			InputStream is = new FileInputStream(new File(url));
			int b = 0;
			while ((b = is.read(bytes, 0, 0xffff)) > 0) {
				out.write(bytes, 0, b);
			}
			is.close();
			out.flush();

		} catch (Exception e) {
			throw new ApplicationException("导出文件异常");
		}
	}
}
