package team.spring.aqs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import team.spring.aqs.entity.aqsAnswer;

public interface aqsAnswerMapper {
    int deleteByPrimaryKey(String answerId);

    int insert(aqsAnswer record);

    int insertSelective(aqsAnswer record);

    aqsAnswer selectByPrimaryKey(String answerId);

    int updateByPrimaryKeySelective(aqsAnswer record);

    int updateByPrimaryKeyWithBLOBs(aqsAnswer record);

    int updateByPrimaryKey(aqsAnswer record);
    
    @Select("SELECT * FROM aqs_answer WHERE question_id = #{questionId} order by answer_create_time desc")
    public List<aqsAnswer> findAnswerByQuestionid(@Param("questionId")String questionId);
}