package com.group.renshi.cache;

import java.io.IOException;
import java.util.List;

import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.ConfigParse;

/**
 * 总体说明
 * 	邮件模版缓存
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MailTemplate.java,v 0.1 2015-6-12 下午4:37:17 Exp $
 */
public class MailTemplateCache extends BaseCache {

	private static String filePrefix = "mailTemp/";

	private static String[] fileArray = new String[] { SystemConstantType.REGISTER_MAIL,
			SystemConstantType.FORGET_MAIL ,SystemConstantType.RESET_MAIL};

	private MailTemplateCache() {
		setCacheBool(true);
		setCacheName("邮件模版缓存");
	}

	/**
	 * 初始化入口
	 * 
	 * @return
	 */
	public synchronized static MailTemplateCache getInstance() {
		MailTemplateCache mailTemplate = (MailTemplateCache) BaseCache
				.getCachedInstance(MailTemplateCache.class.getSimpleName());
		if (mailTemplate == null) {
			mailTemplate = new MailTemplateCache();
			mailTemplate.doSmartLoad();
			BaseCache.setCachedInstance(MailTemplateCache.class.getSimpleName(), mailTemplate);
		}
		return mailTemplate;
	}

	/** 
	 * 初始化数据
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		try {
			for (int i = 0; i < fileArray.length; i++) {
				List<String> fileLines = ConfigParse.parstTXTFile(filePrefix + fileArray[i]);

				StringBuffer content = new StringBuffer();
				for (String fileLine : fileLines) {
					content.append(fileLine);
				}

				put(fileArray[i], content.toString());
			}
		} catch (IOException e) {
			throw new ApplicationException("邮件模版缓存解析文件异常", e);
		}
	}

}
