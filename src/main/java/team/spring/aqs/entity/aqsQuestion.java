package team.spring.aqs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class aqsQuestion {
    private String questionId;

    private String userAccount;

    private String questionIntroduce;

    private Integer questionPreviewCount;

    private Integer questionPraise;

    private Integer questionIfpublic;

    private String questionTypeId;

    private Date questionCreateTime;

    private String questionContent;
}