package team.spring.aqs.service;

import java.util.List;
import team.spring.aqs.entity.aqsAnswer;

public interface AnswerService {
	int addAnswer(aqsAnswer answer);
	List<aqsAnswer> findAnswerByQuestionid(String questionId);
}
