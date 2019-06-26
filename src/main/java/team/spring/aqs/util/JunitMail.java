package team.spring.aqs.util;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author GongCJ
 *
 */
public class JunitMail {
	
	private String defaultSenderAddress = "gongcj023@qq.com";
	private String defaultSenderAccount = "gongcj023@qq.com";
	private String defaultSenderPassword = "tciyozbsindubiaj";
	private String defaultSendTitle = "SpringTeam邮件验证码";
	private String code = createVerificationCode(6);
	private String defalutSendContent =
					"欢迎使用<a href=http://www.gcjlearn.cn:8888/>CGB-Spring</a>团队编写的问答系统。"
					+ "本次验证码为：<a href=#>" + code + "</a>，";/*
																				 * + "验证码30分钟内有效。";
																				 */
	
	/**
	 * 
	 * @param recipientAddress 收件人地址
	 */
	public String sendMail(
			String recipientAddress) {
		
		return this.sendMail(recipientAddress, this.defaultSendTitle, this.defalutSendContent);
	}
	
	
	/**
	 * 
	 * @param recipientAddress 收件人地址
	 * @param sendTitle 邮件主题
	 * @param sendContent 邮件内容
	 */
	public String sendMail(
			String recipientAddress,
			String sendTitle,
			String sendContent) {
		
		return this.sendMail(this.defaultSenderAddress, recipientAddress, this.defaultSenderAccount, this.defaultSenderPassword, sendTitle, sendContent);
		
	}
	
	/**
	 * 
	 * @param senderAddress 发件人地址
	 * @param recipientAddress 收件人地址
	 * @param senderAccount 发件人账户名
	 * @param senderPassword 发件人账户密码
	 * @param sendTitle 邮件主题
	 * @param sendContent 邮件内容
	 */
	public String sendMail(
			String senderAddress, 
			String recipientAddress,
			String senderAccount,
			String senderPassword,
			String sendTitle,
			String sendContent) {
		
		return this.sendMailDo(
				senderAddress, 
				recipientAddress,
				senderAccount,
				senderPassword,
				sendTitle,
				sendContent
			);
	}
	
	
	//发送邮件
	
	private String sendMailDo(
			String senderAddress, 
			String recipientAddress,
			String senderAccount,
			String senderPassword,
			String sendTitle,
			String sendContent
			) {
		
		try {
		
			//1、连接邮件服务器的参数配置
			Properties props = new Properties();
			//设置用户的认证方式
			props.setProperty("mail.smtp.auth", "true");
			//设置传输协议
			props.setProperty("mail.transport.protocol", "smtp");
			//设置发件人的SMTP服务器地址
			props.setProperty("mail.smtp.host", "smtp.qq.com");
			//2、创建定义整个应用程序所需的环境信息的 Session 对象
			Session session = Session.getInstance(props);
			//设置调试信息在控制台打印出来
			session.setDebug(true);

			//3、创建邮件的实例对象
			Message msg = getMimeMessage(session,sendTitle,sendContent,senderAddress,recipientAddress);
		
			//4、根据session对象获取邮件传输对象Transport
			Transport transport = session.getTransport();
			//设置发件人的账户名和密码
			transport.connect(senderAccount, senderPassword);
			//发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
			transport.sendMessage(msg,msg.getAllRecipients());
			
			//如果只想发送给指定的人，可以如下写法
			//transport.sendMessage(msg, new Address[]{new InternetAddress("1607708431@qq.com")});
			
			//5、关闭邮件连接
			transport.close();
			
		}catch(Exception e) {
			return "0";
		}
		return code;
	}
	
	
	
	
	public static MimeMessage getMimeMessage(
			Session session, 
			String sendTitle,
			String sendContent,
			String senderAddress,
			String recipientAddress) throws Exception{
		//创建一封邮件的实例对象
		MimeMessage msg = new MimeMessage(session);
		//设置发件人地址
		msg.setFrom(new InternetAddress(senderAddress));
		/**
		 * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
		 * MimeMessage.RecipientType.TO:发送
		 * MimeMessage.RecipientType.CC：抄送
		 * MimeMessage.RecipientType.BCC：密送
		 */
		msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
		//设置邮件主题
		msg.setSubject(sendTitle,"UTF-8");
		//设置邮件正文
		msg.setContent(sendContent, "text/html;charset=UTF-8");
		//设置邮件的发送时间,默认立即发送
		msg.setSentDate(new Date());
		//结束

		return msg;
	}
	
	
	//生成随机码
	private String createVerificationCode(int codeLength) {
		String verificationCode = "";
		char[] code = new char[] {
				'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z'
		};
		for (int i = 0; i < codeLength; i++) {
			verificationCode += code[new Random().nextInt(62)];
		}
		return verificationCode;
	}
	
}
