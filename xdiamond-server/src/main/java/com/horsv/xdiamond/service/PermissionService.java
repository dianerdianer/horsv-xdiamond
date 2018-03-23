package com.horsv.xdiamond.service;

import com.horsv.xdiamond.domain.Permission;
import com.horsv.xdiamond.domain.PermissionExample;
import com.horsv.xdiamond.persistence.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

  @Autowired
  PermissionMapper permissionMapper;

  public List<Permission> list() {
    PermissionExample permissionExample = new PermissionExample();
    return permissionMapper.selectByExample(permissionExample);
  }

  public void insert(Permission permission) {
    permissionMapper.insert(permission);
  }

  public void delete(int id) {
    permissionMapper.deleteByPrimaryKey(id);
  }

  public void patch(Permission permission) {
    permissionMapper.updateByPrimaryKeySelective(permission);
  }

}
