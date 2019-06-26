package team.spring.aqs.mapper;

import team.spring.aqs.entity.aqsUserRoles;

public interface aqsUserRolesMapper {
    int deleteByPrimaryKey(String urId);

    int insert(aqsUserRoles record);

    int insertSelective(aqsUserRoles record);

    aqsUserRoles selectByPrimaryKey(String urId);

    int updateByPrimaryKeySelective(aqsUserRoles record);

    int updateByPrimaryKey(aqsUserRoles record);
}