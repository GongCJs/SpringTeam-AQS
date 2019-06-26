package team.spring.aqs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.aqsQuestion;
import team.spring.aqs.entity.aqsQuestionType;
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
	public List<aqsQuestionType> findObjectsTypes() {
		List<aqsQuestionType> qt = questionTypeDao.findObjectsTypes();
		return qt;
	}
	
	
	@Override
	public List<aqsQuestion> findObjects(String id) {
		if(id==null) {
			throw new ServiceException("无相关类型问题");
		}
		List<aqsQuestion> list = quesionDao.findObjects(id);
		return list;
	}
	

}
