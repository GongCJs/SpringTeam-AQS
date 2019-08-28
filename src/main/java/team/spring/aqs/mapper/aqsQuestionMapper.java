package team.spring.aqs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


import team.spring.aqs.entity.AqsQuestion;

@Mapper
public interface aqsQuestionMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(AqsQuestion record);

    int insertSelective(AqsQuestion record);

    AqsQuestion selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(AqsQuestion record);

    int updateByPrimaryKeyWithBLOBs(AqsQuestion record);

    int updateByPrimaryKey(AqsQuestion record);

    
    List<AqsQuestion> findObjects(String id);

    
    List<AqsQuestion> findQuestionByType(@Param("questionTypeId")String questionTypeId, @Param("type")Integer type);

	List<AqsQuestion> findQuestionBySearch(String search);
	
	
	@Update("UPDATE aqs_question SET question_preview_count = question_preview_count+1 WHERE question_id = #{questionId}")
	Integer addQuestionPreviewCount(@Param("questionId")String questionId);
	

}