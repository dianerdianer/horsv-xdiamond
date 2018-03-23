package com.horsv.xdiamond.web.api.controller;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.horsv.xdiamond.domain.User;
import com.horsv.xdiamond.service.GroupService;
import com.horsv.xdiamond.web.RestResult;
import com.horsv.xdiamond.domain.Group;
import com.horsv.xdiamond.domain.UserGroup;
import com.horsv.xdiamond.service.UserGroupService;
import com.horsv.xdiamond.service.UserService;
import com.horsv.xdiamond.web.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class AuthenticateController {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

  @Autowired
  CustomRealm customRealm;

  @Autowired
  UserService userService;

  @Autowired
  GroupService groupService;

  @Autowired
  UserGroupService userGroupService;

  /**
   * 获取到当前用户的授权信息
   * 
   * @return
   */
  @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
  @Timed
  public ResponseEntity<RestResult> authenticate() {
    Map<String, Object> authc = new HashMap<String, Object>();
    Map<String, Object> authz = new HashMap<String, Object>();

    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      Object principal = subject.getPrincipal();
      authc.put("principal", principal);

      PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
      AuthorizationInfo authorizationInfo = customRealm.authorizationInfo(principals);

      authz.put("roles", authorizationInfo.getRoles());
      authz.put("permissions", authorizationInfo.getStringPermissions());

      // 查询出用户所在的组，及在组里的access
      User user = userService.query(principal.toString());
      List<UserGroup> userGroups = userGroupService.selectByUserId(user.getId());
      List<Object> groupInfos = Lists.newLinkedList();
      for (UserGroup userGroup : userGroups) {
        Group group = groupService.select(userGroup.getGroupId());
        Map<String, Object> groupInfo = Maps.newLinkedHashMap();
        groupInfo.put("groupId", group.getId());
        groupInfo.put("groupName", group.getName());
        groupInfo.put("access", userGroup.getAccess());
        groupInfos.add(groupInfo);
      }
      authz.put("userGroups", groupInfos);
    }

    Map<String, Object> result = new HashMap<String, Object>();
    result.put("authc", authc);
    result.put("authz", authz);
    return RestResult.success().withResult("info", result).build();
  }

}
