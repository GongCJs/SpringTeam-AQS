package team.spring.aqs.service.Impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.aqs.entity.AqsUser;
import team.spring.aqs.exception.ServiceException;
import team.spring.aqs.mapper.aqsUserMapper;
import team.spring.aqs.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	aqsUserMapper userdao;
	@Override
	public int saveUser(AqsUser user) {
		if(user.getUserAccount()==null||user.getUserAccount()=="") {
			throw new ServiceException("邮箱不能为空");
		}
		if(user.getUserNickname()==null||user.getUserNickname()=="") {
			throw new ServiceException("昵称不能为空");
		}
		if(user.getUserPassword()==null||user.getUserPassword()=="") {
			throw new ServiceException("密码不能为空");
		}
		String salt = UUID.randomUUID().toString();
	    user.setUserSale(salt);
	    SimpleHash sHash = new SimpleHash("MD5", user.getUserPassword(), salt);
	    user.setUserPassword(sHash.toHex());
		return userdao.saveUser(user);
	}
	
	
}
