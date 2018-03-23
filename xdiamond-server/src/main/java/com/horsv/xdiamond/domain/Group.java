package com.horsv.xdiamond.domain;

import java.io.Serializable;

public class Group implements Serializable {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column group.id
   * @mbggenerated
   */
  private Integer id;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column group.name
   * @mbggenerated
   */
  private String name;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column group.description
   * @mbggenerated
   */
  private String description;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table group
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column group.id
   * @return  the value of group.id
   * @mbggenerated
   */
  public Integer getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column group.id
   * @param id  the value for group.id
   * @mbggenerated
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column group.name
   * @return  the value of group.name
   * @mbggenerated
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column group.name
   * @param name  the value for group.name
   * @mbggenerated
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column group.description
   * @return  the value of group.description
   * @mbggenerated
   */
  public String getDescription() {
    return description;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column group.description
   * @param description  the value for group.description
   * @mbggenerated
   */
  public void setDescription(String description) {
    this.description = description;
  }
}