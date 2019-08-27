package team.spring.aqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("kindeditor")
	public String kindeditor() {
		return "kindeditor/kindeditor";
	}
	
	//主页
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	//提问
	@RequestMapping("aqs/questionAdd")
	public String addQuestion() {
		return "aqs/question_add";
	}
	
	//回答问题
	@RequestMapping("aqs/answerQuestion")
	public String answerQuestion() {
		return "aqs/answer_question";
	}
	
	//websocket
	@RequestMapping("testWebSocket")
	public String testWebSocket() {
		return "websocket/firstWebSocket";
	}
}
