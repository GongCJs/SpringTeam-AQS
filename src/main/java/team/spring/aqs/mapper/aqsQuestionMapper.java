package team.spring.aqs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


import team.spring.aqs.entity.aqsQuestion;

@Mapper
public interface aqsQuestionMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(aqsQuestion record);

    int insertSelective(aqsQuestion record);

    aqsQuestion selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(aqsQuestion record);

    int updateByPrimaryKeyWithBLOBs(aqsQuestion record);

    int updateByPrimaryKey(aqsQuestion record);

    
    List<aqsQuestion> findObjects(String id);

    
    List<aqsQuestion> findQuestionByType(@Param("questionTypeId")String questionTypeId,@Param("type")Integer type);

	List<aqsQuestion> findQuestionBySearch(String search);
	
	
	@Update("UPDATE aqs_question SET question_preview_count = question_preview_count+1 WHERE question_id = #{questionId}")
	Integer addQuestionPreviewCount(@Param("questionId")String questionId);
	

}