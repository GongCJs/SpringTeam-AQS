package team.spring.aqs.mapper;

import team.spring.aqs.entity.aqsMenus;

public interface aqsMenusMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(aqsMenus record);

    int insertSelective(aqsMenus record);

    aqsMenus selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(aqsMenus record);

    int updateByPrimaryKey(aqsMenus record);
}