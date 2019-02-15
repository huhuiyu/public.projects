package top.huhuiyu.projects.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.base.IAdminAuth;
import top.huhuiyu.projects.model.TbAdminModel;
import top.huhuiyu.projects.service.TbAdminService;

/**
 * 后台admin管理
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/auth/admin")
public class AuthAdminController implements IAdminAuth {
  @Autowired
  private TbAdminService tbAdminService;

  @RequestMapping("/modifyPwd")
  public JsonMessage modifyPwd(TbAdminModel model) throws Exception {
    return tbAdminService.modifyPwd(model);
  }

}
