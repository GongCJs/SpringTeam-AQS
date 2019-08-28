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
public class AqsRoles {
    private String roleId;

    private String roleName;

    private String roleNote;

    private Date roleCreatedTime;

    private Date roleModifiedTime;

    private String roleCreatedUser;

    private String roleModifiedUser;

}