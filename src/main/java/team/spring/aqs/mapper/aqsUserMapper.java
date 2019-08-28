package team.spring.aqs.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.spring.aqs.entity.AqsUser;

@Mapper
public interface aqsUserMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(AqsUser record);

    int insertSelective(AqsUser record);

    AqsUser selectByPrimaryKey(String userAccount);

    int updateByPrimaryKeySelective(AqsUser record);

    int updateByPrimaryKey(AqsUser record);

	AqsUser doFindUserByUsername(String username);

	int saveUser(AqsUser user);
    
}