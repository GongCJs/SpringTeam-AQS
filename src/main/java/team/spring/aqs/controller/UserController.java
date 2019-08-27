package team.spring.aqs.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team.spring.aqs.entity.aqsUser;
import team.spring.aqs.service.UserService;
import team.spring.aqs.util.JunitMail;
import team.spring.aqs.vo.JsonResult;


@Controller
@RequestMapping("/user")
public class UserController {
	String code;
	@Autowired
	UserService userservice;
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return new JsonResult("登录成功");
	}
	
	//发送邮件
		@RequestMapping("/getVerificationCode")
		@ResponseBody
		public JsonResult getVerificationCode(String email) {
			JunitMail jm = new JunitMail();
			String sendMail = jm.sendMail(email);
			code = sendMail.toLowerCase();
			if(sendMail.equals("0")) {
				return new JsonResult(0,"邮件发送失败");
			}
			return new JsonResult(1,"邮件发送成功");
		}
		
		//验证输入验证码是否合法
		@RequestMapping("/verificationCodeEques")
		@ResponseBody
		public JsonResult verificationCodeEques(String code) {
			code = code.toLowerCase();
			if(code.equals(this.code)) {
				return new JsonResult(1,"验证码正确");
			}else {
				return new JsonResult(0,"验证码错误");
			}
		}
		
		@RequestMapping("/doSaveUser")
		@ResponseBody
		public JsonResult doSaveUser(String mail,String name,String password) {
			aqsUser user = new aqsUser();
			user.setUserAccount(mail);
			user.setUserNickname(name);
			user.setUserPassword(password);
			user.setUserCreateTime(new Date());
			user.setUserValid("1");
			user.setUserIntroduce("null");
			return new JsonResult(userservice.saveUser(user));
		}
		
}
