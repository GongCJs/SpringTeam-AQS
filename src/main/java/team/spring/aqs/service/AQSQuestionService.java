package team.spring.aqs.service;

import java.util.List;

import team.spring.aqs.entity.AqsQuestion;

public interface AQSQuestionService {
	int insert(AqsQuestion record);
	
	List<AqsQuestion> findQuestionByType(String questionTypeId, Integer type);
	
	AqsQuestion selectByPrimaryKey(String questionId);

	List<AqsQuestion> findQuestionBySearch(String search);
	
	Integer addQuestionPreviewCount(String questionId);
}
