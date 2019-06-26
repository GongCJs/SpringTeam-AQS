package team.spring.aqs.service;

import java.util.List;

import team.spring.aqs.entity.aqsQuestion;

public interface AQSQuestionService {
	int insert(aqsQuestion record);
	
	List<aqsQuestion> findQuestionByType(String questionTypeId,Integer type);
	
	aqsQuestion selectByPrimaryKey(String questionId);

	List<aqsQuestion> findQuestionBySearch(String search);
	
	Integer addQuestionPreviewCount(String questionId);
}
