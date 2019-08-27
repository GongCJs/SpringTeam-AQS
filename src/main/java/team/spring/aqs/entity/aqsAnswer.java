package team.spring.aqs.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class aqsAnswer {
    private String answerId;

    private String userAccount;

    private String questionId;

    private String answerSubId;

    private Date answerCreateTime;

    private String answerContent;

    
}