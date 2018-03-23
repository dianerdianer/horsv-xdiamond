package com.horsv.xdiamond.domain;

import java.io.Serializable;

public class Project implements Serializable {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.id
   * @mbggenerated
   */
  private Integer id;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.groupId
   * @mbggenerated
   */
  private String groupId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.artifactId
   * @mbggenerated
   */
  private String artifactId;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.version
   * @mbggenerated
   */
  private String version;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.ownerGroup
   * @mbggenerated
   */
  private Integer ownerGroup;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.description
   * @mbggenerated
   */
  private String description;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.bPublic
   * @mbggenerated
   */
  private Boolean bPublic;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column project.bAllowDependency
   * @mbggenerated
   */
  private Boolean bAllowDependency;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table project
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.id
   * @return  the value of project.id
   * @mbggenerated
   */
  public Integer getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.id
   * @param id  the value for project.id
   * @mbggenerated
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.groupId
   * @return  the value of project.groupId
   * @mbggenerated
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.groupId
   * @param groupId  the value for project.groupId
   * @mbggenerated
   */
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.artifactId
   * @return  the value of project.artifactId
   * @mbggenerated
   */
  public String getArtifactId() {
    return artifactId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.artifactId
   * @param artifactId  the value for project.artifactId
   * @mbggenerated
   */
  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.version
   * @return  the value of project.version
   * @mbggenerated
   */
  public String getVersion() {
    return version;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.version
   * @param version  the value for project.version
   * @mbggenerated
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.ownerGroup
   * @return  the value of project.ownerGroup
   * @mbggenerated
   */
  public Integer getOwnerGroup() {
    return ownerGroup;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.ownerGroup
   * @param ownerGroup  the value for project.ownerGroup
   * @mbggenerated
   */
  public void setOwnerGroup(Integer ownerGroup) {
    this.ownerGroup = ownerGroup;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.description
   * @return  the value of project.description
   * @mbggenerated
   */
  public String getDescription() {
    return description;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.description
   * @param description  the value for project.description
   * @mbggenerated
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.bPublic
   * @return  the value of project.bPublic
   * @mbggenerated
   */
  public Boolean getbPublic() {
    return bPublic;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.bPublic
   * @param bPublic  the value for project.bPublic
   * @mbggenerated
   */
  public void setbPublic(Boolean bPublic) {
    this.bPublic = bPublic;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column project.bAllowDependency
   * @return  the value of project.bAllowDependency
   * @mbggenerated
   */
  public Boolean getbAllowDependency() {
    return bAllowDependency;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column project.bAllowDependency
   * @param bAllowDependency  the value for project.bAllowDependency
   * @mbggenerated
   */
  public void setbAllowDependency(Boolean bAllowDependency) {
    this.bAllowDependency = bAllowDependency;
  }
}