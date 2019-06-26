package team.spring.aqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.spring.aqs.service.QuestionService;
import team.spring.aqs.vo.JsonResult;

@Controller
@RequestMapping("/type")
public class QuestionTypeController {
	@Autowired
	QuestionService questionserice;
	
	
	@RequestMapping("/doFindObjectsTypes")
	@ResponseBody
	public JsonResult dofindObjectsTypes() {
		return new JsonResult(questionserice.findObjectsTypes());
	}
	
	
	@RequestMapping("/doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(String id) {
		return new JsonResult(questionserice.findObjects(id));
	}
	
}
