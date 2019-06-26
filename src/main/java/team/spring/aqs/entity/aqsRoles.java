package team.spring.aqs.entity;

import java.util.Date;

public class aqsRoles {
    private String roleId;

    private String roleName;

    private String roleNote;

    private Date roleCreatedTime;

    private Date roleModifiedTime;

    private String roleCreatedUser;

    private String roleModifiedUser;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleNote() {
        return roleNote;
    }

    public void setRoleNote(String roleNote) {
        this.roleNote = roleNote == null ? null : roleNote.trim();
    }

    public Date getRoleCreatedTime() {
        return roleCreatedTime;
    }

    public void setRoleCreatedTime(Date roleCreatedTime) {
        this.roleCreatedTime = roleCreatedTime;
    }

    public Date getRoleModifiedTime() {
        return roleModifiedTime;
    }

    public void setRoleModifiedTime(Date roleModifiedTime) {
        this.roleModifiedTime = roleModifiedTime;
    }

    public String getRoleCreatedUser() {
        return roleCreatedUser;
    }

    public void setRoleCreatedUser(String roleCreatedUser) {
        this.roleCreatedUser = roleCreatedUser == null ? null : roleCreatedUser.trim();
    }

    public String getRoleModifiedUser() {
        return roleModifiedUser;
    }

    public void setRoleModifiedUser(String roleModifiedUser) {
        this.roleModifiedUser = roleModifiedUser == null ? null : roleModifiedUser.trim();
    }
}