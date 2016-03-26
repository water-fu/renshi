package com.group.webFramework.uitl;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MailSendThread.java,v 0.1 2015-6-2 下午5:26:17 Exp $
 */
public class MailSendThread extends Thread {

	private static Logger logger = LoggerFactory.getLogger(MailSendThread.class);

	private Message message;

	private JavaMailSender javaMailSender;

	/**
	 * 
	 */
	public MailSendThread(Message message, JavaMailSender javaMailSender) {
		this.message = message;
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void run() {
		try {
			javaMailSender.send((MimeMessage) message);
		} catch (Exception e) {
			logger.error("发送给的邮件，发送异常：" + e.getMessage(), e);
		}
	}
}
