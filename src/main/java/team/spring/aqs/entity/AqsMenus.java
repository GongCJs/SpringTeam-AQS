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
public class AqsMenus {
    private String menuId;

    private String menuName;

    private String menuUrl;

    private Integer menuType;

    private Integer menuSort;

    private String menuNote;

    private String menuParentId;

    private String menuPermission;

    private Date menuCreatedTime;

    private Date menuModifiedTime;

    private String menuCreatedUser;

    private String menuModifiedUser;

}