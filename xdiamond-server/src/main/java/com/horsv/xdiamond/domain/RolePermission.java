package com.horsv.xdiamond.domain;

import java.io.Serializable;

public class RolePermission implements Serializable {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column role_permissions.roleId
   * @mbggenerated
   */
  private Integer roleId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column role_permissions.permissionId
   * @mbggenerated
   */
  private Integer permissionId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table role_permissions
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column role_permissions.roleId
   * @return  the value of role_permissions.roleId
   * @mbggenerated
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column role_permissions.roleId
   * @param roleId  the value for role_permissions.roleId
   * @mbggenerated
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column role_permissions.permissionId
   * @return  the value of role_permissions.permissionId
   * @mbggenerated
   */
  public Integer getPermissionId() {
    return permissionId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column role_permissions.permissionId
   * @param permissionId  the value for role_permissions.permissionId
   * @mbggenerated
   */
  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }
}