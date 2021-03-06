package com.horsv.xdiamond.web.api.controller;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.horsv.xdiamond.domain.Dependency;
import com.horsv.xdiamond.domain.Project;
import com.horsv.xdiamond.service.DependencyService;
import com.horsv.xdiamond.service.ProjectService;
import com.horsv.xdiamond.web.RestResult;
import com.horsv.xdiamond.web.shiro.PermissionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
@Transactional
public class DependencyController {

  @Autowired
  DependencyService dependencyService;
  @Autowired
  ProjectService projectService;

  @RequestMapping(value = "/dependencies/all", method = RequestMethod.GET)
  @Timed
  public Object list() {
    // 这里的权限检查在shiro-web配置文件里
    List<Dependency> dependencies = dependencyService.list();
    return RestResult.success().withResult("dependencies", dependencies).build();
  }

  @RequestMapping(value = "/projects/{projectId}/dependencies", method = RequestMethod.GET)
  @Timed
  public Object list(@PathVariable Integer projectId) {
    List<Dependency> dependencies = dependencyService.list(projectId);
    // 过滤掉没有read权限的Dependency
    List<Dependency> result = Lists.newLinkedList();
    for (Dependency dependency : dependencies) {
      if (PermissionHelper.hasDependencyRead(dependency.getId())) {
        result.add(dependency);
      }
    }
    return RestResult.success().withResult("dependencies", result)
        .withResult("projectId", projectId).build();
  }

  @RequestMapping(value = "/dependencies", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public Object create(@Valid @RequestBody Dependency dependency) {
    // 增加依赖时，检查是否有Project的Dependency的权限
    PermissionHelper.checkDependencyCreate(dependency.getProjectId());

    Project project = projectService.select(dependency.getDependencyProjectId());
    if (project == null) {
      return RestResult.fail().withErrorMessage("project don not exist!");
    }
    if (!project.getbAllowDependency()) {
      return RestResult.fail().withErrorMessage("project don not allow dependency!!");
    }
    dependencyService.insert(dependency);
    return RestResult.success().withResult("message", "创建dependency成功").build();
  }

  @RequestMapping(value = "/dependencies/{dependencyId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Object delete(@PathVariable Integer dependencyId) {
    // 删除依赖时，检查权限
    PermissionHelper.checkDependencyDelete(dependencyId);

    dependencyService.delete(dependencyId);
    return RestResult.success().withResult("message", "删除dependencyId成功").build();
  }

  @RequestMapping(value = "/dependencies", method = RequestMethod.PATCH)
  public Object update(@Valid @RequestBody Dependency dependency) {
    // 更新依赖时，检查权限
    PermissionHelper.checkDependencyWrite(dependency.getId());

    dependencyService.patch(dependency);
    return RestResult.success().withResult("message", "更新dependency成功").build();
  }
}
