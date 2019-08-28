package team.spring.aqs.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.spring.aqs.entity.AqsQuestion;
import team.spring.aqs.service.AQSQuestionService;
import team.spring.aqs.util.UuidUtils;
import team.spring.aqs.vo.JsonResult;

@Controller
@RequestMapping("question/")
public class QuestionController {
	@Autowired
	AQSQuestionService queService;
	
	@RequestMapping("addQuestion.do")
	@ResponseBody
	public JsonResult addQuestion(
			String questionIntroduce,
			String questionContent,
			String questionTypeId,
			Integer questionIfpublic
		)
	{
		AqsQuestion record = new AqsQuestion();
		record.setQuestionContent(questionContent);
		record.setQuestionIntroduce(questionIntroduce);
		record.setQuestionTypeId(questionTypeId);
		record.setQuestionIfpublic(questionIfpublic);
		record.setQuestionPraise(0);
		record.setQuestionPreviewCount(0);
		record.setQuestionCreateTime(new Date());
		record.setQuestionId(UuidUtils.CreateUUID());
		System.out.println(record);
		int insert = queService.insert(record);
		return new JsonResult(1,"发表成功：" +insert);
	}
	
	@RequestMapping("doFindQuestionByType")
	@ResponseBody
	public JsonResult findQuestionByType(String questionTypeId,Integer type) {
		List<AqsQuestion> findQuestionByType = queService.findQuestionByType(questionTypeId,type);
		return new JsonResult(findQuestionByType);
	}

	@RequestMapping("search")
	@ResponseBody
	public JsonResult search(String search) {
		List<AqsQuestion> findQuestionByType = queService.findQuestionBySearch(search);
		return new JsonResult(findQuestionByType);
	}
	
	
	@RequestMapping("findQuestion.do")
	@ResponseBody
	public JsonResult findQuestion(String questionId) throws Exception {
		AqsQuestion result = queService.selectByPrimaryKey(questionId);
		queService.addQuestionPreviewCount(questionId);
		return new JsonResult(result);
	}
}
