package team.spring.aqs.mapper;

import team.spring.aqs.entity.aqsRoles;

public interface aqsRolesMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(aqsRoles record);

    int insertSelective(aqsRoles record);

    aqsRoles selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(aqsRoles record);

    int updateByPrimaryKey(aqsRoles record);
}