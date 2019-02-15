package top.huhuiyu.projects.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.base.IAdminAuth;
import top.huhuiyu.projects.model.TbTeachTypeModel;
import top.huhuiyu.projects.service.TbTeachTypeService;

/**
 * TbTeachType后台管理
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/auth/teachtype")
public class AuthTbTeachTypeController implements IAdminAuth {

  @Autowired
  private TbTeachTypeService tbTeachTypeService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTeachTypeModel model) throws Exception {
    return tbTeachTypeService.queryAll(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTeachTypeModel model) throws Exception {
    return tbTeachTypeService.add(model);
  }

  @RequestMapping("/update")
  public JsonMessage update(TbTeachTypeModel model) throws Exception {
    return tbTeachTypeService.update(model);
  }

}
