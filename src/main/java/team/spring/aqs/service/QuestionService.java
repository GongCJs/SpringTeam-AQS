package team.spring.aqs.service;

import java.util.List;

import team.spring.aqs.entity.aqsQuestion;
import team.spring.aqs.entity.aqsQuestionType;

public interface QuestionService {

	List<aqsQuestion> findObjects(String id);

	List<aqsQuestionType> findObjectsTypes();
	
}
