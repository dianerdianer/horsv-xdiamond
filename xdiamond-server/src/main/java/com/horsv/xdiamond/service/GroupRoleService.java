package com.horsv.xdiamond.service;

import com.horsv.xdiamond.domain.Role;
import com.horsv.xdiamond.persistence.GroupRoleMapper;
import com.horsv.xdiamond.persistence.RoleMapper;
import com.horsv.xdiamond.domain.Group;
import com.horsv.xdiamond.domain.GroupRole;
import com.horsv.xdiamond.domain.GroupRoleExample;
import com.horsv.xdiamond.persistence.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GroupRoleService {

  @Autowired
  GroupRoleMapper groupRoleMapper;

  @Autowired
  RoleMapper roleMapper;
  @Autowired
  GroupMapper groupMapper;

  public int insert(int roleId, int groupId) {
    GroupRole record = new GroupRole();
    record.setRoleId(roleId);
    record.setGroupId(groupId);
    return groupRoleMapper.insert(record);
  }

  public int delete(int roleId, int groupId) {
    return groupRoleMapper.deleteByPrimaryKey(groupId, roleId);
  }

  public List<Role> getRoles(int groupId) {
    List<Role> result = new LinkedList<Role>();
    GroupRoleExample example = new GroupRoleExample();
    example.createCriteria().andGroupIdEqualTo(groupId);
    List<GroupRole> groupRoleList = groupRoleMapper.selectByExample(example);
    for (GroupRole groupRole : groupRoleList) {
      Integer roleId = groupRole.getRoleId();
      result.add(roleMapper.selectByPrimaryKey(roleId));
    }
    return result;
  }

  public List<Group> getGroups(int roleId) {
    List<Group> result = new LinkedList<Group>();
    GroupRoleExample example = new GroupRoleExample();
    example.createCriteria().andRoleIdEqualTo(roleId);
    List<GroupRole> groupRoleList = groupRoleMapper.selectByExample(example);
    for (GroupRole groupRole : groupRoleList) {
      Integer groupId = groupRole.getGroupId();
      result.add(groupMapper.selectByPrimaryKey(groupId));
    }
    return result;
  }

}
