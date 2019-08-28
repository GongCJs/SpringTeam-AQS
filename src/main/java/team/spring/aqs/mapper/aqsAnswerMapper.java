package team.spring.aqs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import team.spring.aqs.entity.AqsAnswer;

public interface aqsAnswerMapper {
    int deleteByPrimaryKey(String answerId);

    int insert(AqsAnswer record);

    int insertSelective(AqsAnswer record);

    AqsAnswer selectByPrimaryKey(String answerId);

    int updateByPrimaryKeySelective(AqsAnswer record);

    int updateByPrimaryKeyWithBLOBs(AqsAnswer record);

    int updateByPrimaryKey(AqsAnswer record);
    
    @Select("SELECT * FROM aqs_answer WHERE question_id = #{questionId} order by answer_create_time desc")
    public List<AqsAnswer> findAnswerByQuestionid(@Param("questionId")String questionId);
}