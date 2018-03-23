package com.horsv.xdiamond.web.api.controller;

import com.codahale.metrics.annotation.Timed;
import com.horsv.xdiamond.domain.User;
import com.horsv.xdiamond.service.UserService;
import com.horsv.xdiamond.web.RestResult;
import com.horsv.xdiamond.web.shiro.PasswordUtil;
import com.horsv.xdiamond.web.shiro.PermissionHelper;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api")
@Transactional
public class UserController {

  @Autowired
  UserService userService;

  /**
   * GET /users -> get all users.
   */
  @RequestMapping(value = "/users", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Timed
  public ResponseEntity<RestResult> getAll() {
    // 获取所有用户，这个只要登陆就有权限，因为在管理组，向组里增加用户时要用到
    List<User> users = userService.list();

    return RestResult.success().withResult("users", users).build();
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<RestResult> create(@Valid @RequestBody User user) {
    // 新增加用户需要Admin权限
    PermissionHelper.checkAdmin();
    userService.insert(user);
    return RestResult.success().withResult("message", "创建user成功").build();
  }

  @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<RestResult> delete(@PathVariable Integer userId) {
    // 删除用户需要Admin权限
    PermissionHelper.checkAdmin();
    userService.delete(userId);
    return RestResult.success().withResult("message", "删除userId成功").build();
  }

  @RequestMapping(value = "/users", method = RequestMethod.PATCH)
  public Object update(@Valid @RequestBody User user) {
    // 修改用户需要Admin权限
    PermissionHelper.checkAdmin();

    // 如果是修改密码，则要计算salt值
    if (user.getPassword() != null) {
      Pair<String, String> saltAndSaltedPassword =
          PasswordUtil.generateSaltedPassword(user.getPassword());
      user.setPasswordSalt(saltAndSaltedPassword.getLeft());
      user.setPassword(saltAndSaltedPassword.getRight());
    }
    userService.patch(user);
    return RestResult.success().withResult("message", "更新user成功").build();
  }
}
