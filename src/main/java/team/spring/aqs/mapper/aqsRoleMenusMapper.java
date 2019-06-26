package team.spring.aqs.mapper;

import team.spring.aqs.entity.aqsRoleMenus;

public interface aqsRoleMenusMapper {
    int deleteByPrimaryKey(String rmId);

    int insert(aqsRoleMenus record);

    int insertSelective(aqsRoleMenus record);

    aqsRoleMenus selectByPrimaryKey(String rmId);

    int updateByPrimaryKeySelective(aqsRoleMenus record);

    int updateByPrimaryKey(aqsRoleMenus record);
}