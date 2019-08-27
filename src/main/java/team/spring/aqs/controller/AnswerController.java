package team.spring.aqs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.spring.aqs.entity.aqsAnswer;
import team.spring.aqs.service.AnswerService;
import team.spring.aqs.util.Uuid;
import team.spring.aqs.vo.JsonResult;

@Controller
@RequestMapping("answer")
public class AnswerController {
	
	@Autowired
	AnswerService service;
	
	
	@ResponseBody
	@RequestMapping("addAnswer.do")
	public JsonResult addAnswer(String answerContent , String questionId) {
		aqsAnswer answer = new aqsAnswer();
		answer.setAnswerContent(answerContent);
		answer.setAnswerCreateTime(new Date());
		answer.setAnswerId(Uuid.CreateUUID());
		answer.setQuestionId(questionId);
		int addAnswer = service.addAnswer(answer);
		return new JsonResult(1,"评论成功："+addAnswer);
	}
	
	@ResponseBody
	@RequestMapping("findAnswerByQuestionid.do")
	public JsonResult findAnswerByQuestionid(String questionId) {
		List<aqsAnswer> findAnswerByQuestionid = service.findAnswerByQuestionid(questionId);
		return new JsonResult(findAnswerByQuestionid);
	}
}
