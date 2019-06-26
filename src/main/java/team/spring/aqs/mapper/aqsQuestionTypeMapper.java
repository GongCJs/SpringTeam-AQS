package team.spring.aqs.mapper;

import java.util.List;

import team.spring.aqs.entity.aqsQuestionType;

public interface aqsQuestionTypeMapper {
    int deleteByPrimaryKey(String quesitonTypeId);

    int insert(aqsQuestionType record);

    int insertSelective(aqsQuestionType record);

    aqsQuestionType selectByPrimaryKey(String quesitonTypeId);

    int updateByPrimaryKeySelective(aqsQuestionType record);

    int updateByPrimaryKey(aqsQuestionType record);
    
    List<aqsQuestionType> findObjectsTypes();
}