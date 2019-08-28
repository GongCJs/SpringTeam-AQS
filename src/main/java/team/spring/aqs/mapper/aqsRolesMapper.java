package team.spring.aqs.mapper;

import team.spring.aqs.entity.AqsRoles;

public interface aqsRolesMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AqsRoles record);

    int insertSelective(AqsRoles record);

    AqsRoles selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AqsRoles record);

    int updateByPrimaryKey(AqsRoles record);
}