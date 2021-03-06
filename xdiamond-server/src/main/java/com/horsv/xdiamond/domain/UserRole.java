package com.horsv.xdiamond.domain;

import java.io.Serializable;

public class UserRole implements Serializable {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column user_roles.userId
   * @mbggenerated
   */
  private Integer userId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column user_roles.roleId
   * @mbggenerated
   */
  private Integer roleId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table user_roles
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column user_roles.userId
   * @return  the value of user_roles.userId
   * @mbggenerated
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column user_roles.userId
   * @param userId  the value for user_roles.userId
   * @mbggenerated
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column user_roles.roleId
   * @return  the value of user_roles.roleId
   * @mbggenerated
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column user_roles.roleId
   * @param roleId  the value for user_roles.roleId
   * @mbggenerated
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
}