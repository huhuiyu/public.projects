package top.huhuiyu.projects.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.base.IAdminAuth;
import top.huhuiyu.projects.model.TbTeachSubtypeModel;
import top.huhuiyu.projects.service.TbTeachSubtypeService;

/**
 * 后台小类管理
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/auth/teachsubtype")
public class AuthTbTeachSubtypeController implements IAdminAuth {
  @Autowired
  private TbTeachSubtypeService tbTeachSubtypeService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTeachSubtypeModel model) throws Exception {
    return tbTeachSubtypeService.queryAll(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTeachSubtypeModel model) throws Exception {
    return tbTeachSubtypeService.add(model);
  }

  @RequestMapping("/update")
  public JsonMessage update(TbTeachSubtypeModel model) throws Exception {
    return tbTeachSubtypeService.update(model);
  }
}
