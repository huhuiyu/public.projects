package top.huhuiyu.projects.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.base.IAdminAuth;
import top.huhuiyu.projects.model.TbTeachInfoModel;
import top.huhuiyu.projects.service.TbTeachInfoService;

/**
 * TbTeachInfo后台管理
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/auth/teachinfo")
public class AuthTbTeachInfoController implements IAdminAuth {
  @Autowired
  private TbTeachInfoService tbTeachInfoService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.queryAll(model);
  }

  @RequestMapping("/queryAddBaseInfo")
  public JsonMessage queryAddBaseInfo(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.queryAddBaseInfo(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.add(model);
  }

  @RequestMapping("/queryModifyBaseInfo")
  public JsonMessage queryModifyBaseInfo(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.queryModifyBaseInfo(model);
  }

  @RequestMapping("/update")
  public JsonMessage update(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.update(model);
  }

}
