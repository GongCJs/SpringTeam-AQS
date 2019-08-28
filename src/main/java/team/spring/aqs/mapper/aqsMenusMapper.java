package team.spring.aqs.mapper;

import team.spring.aqs.entity.AqsMenus;

public interface aqsMenusMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(AqsMenus record);

    int insertSelective(AqsMenus record);

    AqsMenus selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(AqsMenus record);

    int updateByPrimaryKey(AqsMenus record);
}