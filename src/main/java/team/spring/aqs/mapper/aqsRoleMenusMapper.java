package team.spring.aqs.mapper;

import team.spring.aqs.entity.AqsRoleMenus;

public interface aqsRoleMenusMapper {
    int deleteByPrimaryKey(String rmId);

    int insert(AqsRoleMenus record);

    int insertSelective(AqsRoleMenus record);

    AqsRoleMenus selectByPrimaryKey(String rmId);

    int updateByPrimaryKeySelective(AqsRoleMenus record);

    int updateByPrimaryKey(AqsRoleMenus record);
}