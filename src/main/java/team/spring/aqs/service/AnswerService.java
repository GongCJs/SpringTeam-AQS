package team.spring.aqs.service;

import java.util.List;
import team.spring.aqs.entity.AqsAnswer;

public interface AnswerService {
	int addAnswer(AqsAnswer answer);
	List<AqsAnswer> findAnswerByQuestionid(String questionId);
}
