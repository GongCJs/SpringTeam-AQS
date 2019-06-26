package team.spring.aqs.service.Impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.aqsQuestion;
import team.spring.aqs.entity.aqsUser;
import team.spring.aqs.exception.ServiceException;
import team.spring.aqs.mapper.aqsQuestionMapper;
import team.spring.aqs.service.AQSQuestionService;

@Service
public class AQSQuestionServiceImpl implements AQSQuestionService {
	@Autowired
	aqsQuestionMapper quemapper;
	
	@RequiresUser
	@Override
	public int insert(aqsQuestion record) {
		Subject sub = SecurityUtils.getSubject(); 
		aqsUser userinfo = (aqsUser)sub.getPrincipal();
		record.setUserAccount(userinfo.getUserAccount());
		int insert = quemapper.insertSelective(record);
		if(insert == 0) {
			throw new ServiceException("添加失败");
		}
		return insert;
	}

	@Override
	public aqsQuestion selectByPrimaryKey(String questionId) {
		aqsQuestion selectByPrimaryKey = quemapper.selectByPrimaryKey(questionId);
		if(selectByPrimaryKey == null) {
			throw new ServiceException("系统中没有该数据");
		}
		return selectByPrimaryKey;
	}

	@Override
	public List<aqsQuestion> findQuestionByType(String questionTypeId,Integer type) {
		List<aqsQuestion> findQuestionByType = quemapper.findQuestionByType(questionTypeId,type);
		return findQuestionByType;
	}

	@Override
	public List<aqsQuestion> findQuestionBySearch(String search) {
		if(search==null || search=="") {
			return quemapper.findQuestionByType(null,1);
		}else {
			List<aqsQuestion> findQuestionByType = quemapper.findQuestionBySearch(search);
			return findQuestionByType;
		}
	}
	
	@Override
	public Integer addQuestionPreviewCount(String questionId) {
		Integer addQuestionPreviewCount = quemapper.addQuestionPreviewCount(questionId);
		return addQuestionPreviewCount;
	}
	
}
