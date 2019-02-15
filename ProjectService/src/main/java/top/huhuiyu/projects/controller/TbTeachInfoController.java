package top.huhuiyu.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachInfoModel;
import top.huhuiyu.projects.service.TbTeachInfoService;

/**
 * 前台TbTeachInfo
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/teachinfo")
public class TbTeachInfoController {

  @Autowired
  private TbTeachInfoService tbTeachInfoService;

  @RequestMapping("/queryBySubtype")
  public JsonMessage queryBySubtype(TbTeachInfoModel model) throws Exception {
    return tbTeachInfoService.queryBySubtype(model);
  }

}
