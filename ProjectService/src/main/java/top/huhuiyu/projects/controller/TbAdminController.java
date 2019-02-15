package top.huhuiyu.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbAdminModel;
import top.huhuiyu.projects.service.TbAdminService;

/**
 * TbAdmin的控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/TbAdmin")
public class TbAdminController {
  @Autowired
  private TbAdminService tbAdminService;

  @RequestMapping("/login")
  public JsonMessage login(TbAdminModel model) throws Exception {
    return tbAdminService.login(model);
  }

  @RequestMapping("/logout")
  public JsonMessage logout(TbAdminModel model) throws Exception {
    return tbAdminService.logout(model);
  }

  @RequestMapping("/getAdminInfo")
  public JsonMessage getAdminInfo(TbAdminModel model) throws Exception {
    return tbAdminService.getAdminInfo(model);
  }
}
