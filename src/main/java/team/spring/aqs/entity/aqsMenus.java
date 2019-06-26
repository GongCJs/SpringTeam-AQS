package team.spring.aqs.entity;

import java.util.Date;

public class aqsMenus {
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuNote() {
        return menuNote;
    }

    public void setMenuNote(String menuNote) {
        this.menuNote = menuNote == null ? null : menuNote.trim();
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId == null ? null : menuParentId.trim();
    }

    public String getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission == null ? null : menuPermission.trim();
    }

    public Date getMenuCreatedTime() {
        return menuCreatedTime;
    }

    public void setMenuCreatedTime(Date menuCreatedTime) {
        this.menuCreatedTime = menuCreatedTime;
    }

    public Date getMenuModifiedTime() {
        return menuModifiedTime;
    }

    public void setMenuModifiedTime(Date menuModifiedTime) {
        this.menuModifiedTime = menuModifiedTime;
    }

    public String getMenuCreatedUser() {
        return menuCreatedUser;
    }

    public void setMenuCreatedUser(String menuCreatedUser) {
        this.menuCreatedUser = menuCreatedUser == null ? null : menuCreatedUser.trim();
    }

    public String getMenuModifiedUser() {
        return menuModifiedUser;
    }

    public void setMenuModifiedUser(String menuModifiedUser) {
        this.menuModifiedUser = menuModifiedUser == null ? null : menuModifiedUser.trim();
    }
}