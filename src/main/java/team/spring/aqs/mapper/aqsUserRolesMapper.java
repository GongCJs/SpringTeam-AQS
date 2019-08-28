package team.spring.aqs.mapper;

import team.spring.aqs.entity.AqsUserRoles;

public interface aqsUserRolesMapper {
    int deleteByPrimaryKey(String urId);

    int insert(AqsUserRoles record);

    int insertSelective(AqsUserRoles record);

    AqsUserRoles selectByPrimaryKey(String urId);

    int updateByPrimaryKeySelective(AqsUserRoles record);

    int updateByPrimaryKey(AqsUserRoles record);
}