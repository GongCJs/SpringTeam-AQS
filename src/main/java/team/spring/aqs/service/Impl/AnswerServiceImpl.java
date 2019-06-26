package team.spring.aqs.service.Impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.aqsAnswer;
import team.spring.aqs.entity.aqsUser;
import team.spring.aqs.mapper.aqsAnswerMapper;
import team.spring.aqs.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	aqsAnswerMapper mapper;
	
	@RequiresUser
	@Override
	public int addAnswer(aqsAnswer answer) {
		 Subject sub = SecurityUtils.getSubject();
		 aqsUser userinfo = (aqsUser)sub.getPrincipal();
		 answer.setUserAccount(userinfo.getUserAccount());
		 int insert = mapper.insert(answer);
		return insert;
	}

	@Override
	public List<aqsAnswer> findAnswerByQuestionid(String questionId) {
		// TODO Auto-generated method stub
		List<aqsAnswer> findAnswerByQuestionid = mapper.findAnswerByQuestionid(questionId);
		return findAnswerByQuestionid;
	}

}
