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
public class AqsUser {
    private String userAccount;

    private String userNickname;

    private String userPassword;

    private String userSale;

    private String userValid;

    private String userIntroduce;

    private Date userCreateTime;
}