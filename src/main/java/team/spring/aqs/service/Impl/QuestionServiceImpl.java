package team.spring.aqs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.AqsQuestion;
import team.spring.aqs.entity.AqsQuestionType;
import team.spring.aqs.exception.ServiceException;
import team.spring.aqs.mapper.aqsQuestionMapper;
import team.spring.aqs.mapper.aqsQuestionTypeMapper;
import team.spring.aqs.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	aqsQuestionMapper quesionDao;
	@Autowired
	aqsQuestionTypeMapper questionTypeDao;
	
	@Override
	public List<AqsQuestionType> findObjectsTypes() {
		List<AqsQuestionType> qt = questionTypeDao.findObjectsTypes();
		return qt;
	}
	
	
	@Override
	public List<AqsQuestion> findObjects(String id) {
		if(id==null) {
			throw new ServiceException("无相关类型问题");
		}
		List<AqsQuestion> list = quesionDao.findObjects(id);
		return list;
	}
	

}
