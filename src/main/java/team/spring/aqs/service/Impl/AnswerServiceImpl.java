package team.spring.aqs.service.Impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.AqsAnswer;
import team.spring.aqs.entity.AqsUser;
import team.spring.aqs.mapper.aqsAnswerMapper;
import team.spring.aqs.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	aqsAnswerMapper mapper;
	
	@RequiresUser
	@Override
	public int addAnswer(AqsAnswer answer) {
		 Subject sub = SecurityUtils.getSubject();
		 AqsUser userinfo = (AqsUser)sub.getPrincipal();
		 answer.setUserAccount(userinfo.getUserAccount());
		 int insert = mapper.insert(answer);
		return insert;
	}

	@Override
	public List<AqsAnswer> findAnswerByQuestionid(String questionId) {
		// TODO Auto-generated method stub
		List<AqsAnswer> findAnswerByQuestionid = mapper.findAnswerByQuestionid(questionId);
		return findAnswerByQuestionid;
	}
}
