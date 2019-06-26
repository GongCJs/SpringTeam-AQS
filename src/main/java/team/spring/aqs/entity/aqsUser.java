package team.spring.aqs.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class aqsUser {
    private String userAccount;

    private String userNickname;

    private String userPassword;

    private String userSale;

    private String userValid;

    private String userIntroduce;

    private Date userCreateTime;


    
}