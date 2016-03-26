package com.group.renshi.action.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.group.renshi.cache.StorePathCache;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明
 * 	文件上传Controller
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: FileUploadController.java,v 0.1 2015-5-25 下午3:13:45 Exp $
 */
@Controller
@RequestMapping("/common")
@Scope("prototype")
public class FileUploadController extends BaseController {

	/**
	 * AJAX文件上传处理方法
	 * 
	 * @param storePath
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxFileUpload", method = RequestMethod.POST)
	@ResponseBody
	public void ajaxFileUpload(@RequestParam("storePath") String storePath,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取上传的文件列表
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

		// 根据key获取真实保存的路径
		String realPath = StorePathCache.getInstance().getStorePathByKey(storePath);

		if (null == realPath || "".equals(realPath)) {
			throw new ApplicationException("存储的路径为空");
		}

		// 设置文件的保存路径
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		List<String> fileNameList = new ArrayList<String>();
		// 循环文件列表
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 文件对象
			MultipartFile mf = entity.getValue();
			// 获取文件真实的文件名、文件后缀
			String realFileName = mf.getOriginalFilename();
			String fileFixed = realFileName.substring(realFileName.lastIndexOf("."));

			// 随机生成不重复的文件名
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String fileName = simpleDateFormat.format(date);

			File uploadFile = new File(realPath + fileName + fileFixed);

			// 拷贝文件
			try {
				FileCopyUtils.copy(mf.getBytes(), uploadFile);
			} catch (IOException e) {
				throw new ApplicationException("文件复制出错", e);
			}

			fileNameList.add(realPath + fileName + fileFixed);
			fileNameList.add(realFileName);
		}

		responseHtmlResult(response, fileNameList);
	}
}
