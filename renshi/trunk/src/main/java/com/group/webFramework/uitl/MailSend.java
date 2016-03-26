package com.group.webFramework.uitl;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: MailSender.java,v 0.1 2015年5月25日 下午3:56:31 Exp $
 */
public class MailSend {

	private static Logger logger = LoggerFactory.getLogger(MailSend.class);

	@Resource
	private JavaMailSender javaMailSender;

	@Resource
	private SimpleMailMessage simpleMailMessage;

	/**
	 * 发送邮件
	 * 
	 * @param to
	 *            收件人邮箱
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 */
	public void sendMail(String to, String subject, String content) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			// 设置发件人
			messageHelper.setFrom(simpleMailMessage.getFrom());

			// 设置主题
			if (subject != null) {
				messageHelper.setSubject(subject);
			} else {
				messageHelper.setSubject(simpleMailMessage.getSubject());
			}

			// 设置收件人和内容
			messageHelper.setTo(to);
			messageHelper.setText(content, true);

			// 使用线程发送
			MailSendThread sendThread = new MailSendThread(message, javaMailSender);
			sendThread.start();

		} catch (Exception e) {
			logger.error("发送给[" + to + "]的邮件，发送异常：" + e.getMessage(), e);
		}
	}
}
