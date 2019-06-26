package team.spring.aqs.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.spring.aqs.entity.aqsUser;

@Mapper
public interface aqsUserMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(aqsUser record);

    int insertSelective(aqsUser record);

    aqsUser selectByPrimaryKey(String userAccount);

    int updateByPrimaryKeySelective(aqsUser record);

    int updateByPrimaryKey(aqsUser record);

	aqsUser doFindUserByUsername(String username);

	int saveUser(aqsUser user);
    
}