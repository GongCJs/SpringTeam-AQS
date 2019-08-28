package team.spring.aqs.service;

import java.util.List;

import team.spring.aqs.entity.AqsQuestion;
import team.spring.aqs.entity.AqsQuestionType;

public interface QuestionService {

	List<AqsQuestion> findObjects(String id);

	List<AqsQuestionType> findObjectsTypes();
	
}
