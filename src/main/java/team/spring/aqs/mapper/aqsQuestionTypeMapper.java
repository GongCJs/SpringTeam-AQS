package team.spring.aqs.mapper;

import java.util.List;

import team.spring.aqs.entity.AqsQuestionType;

public interface aqsQuestionTypeMapper {
    int deleteByPrimaryKey(String quesitonTypeId);

    int insert(AqsQuestionType record);

    int insertSelective(AqsQuestionType record);

    AqsQuestionType selectByPrimaryKey(String quesitonTypeId);

    int updateByPrimaryKeySelective(AqsQuestionType record);

    int updateByPrimaryKey(AqsQuestionType record);
    
    List<AqsQuestionType> findObjectsTypes();
}