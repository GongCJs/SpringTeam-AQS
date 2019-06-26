package team.spring.aqs.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class aqsAnswer {
    private String answerId;

    private String userAccount;

    private String questionId;

    private String answerSubId;

    private Date answerCreateTime;

    private String answerContent;

    
}