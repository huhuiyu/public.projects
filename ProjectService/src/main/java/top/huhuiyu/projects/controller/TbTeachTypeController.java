package top.huhuiyu.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachTypeModel;
import top.huhuiyu.projects.service.TbTeachTypeService;

/**
 * 前台TbTeachType
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/teachtype")
public class TbTeachTypeController {

  @Autowired
  private TbTeachTypeService tbTeachTypeService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTeachTypeModel model) throws Exception {
    model.getTbTeachType().setEnable("y");
    return tbTeachTypeService.queryAllNoPage(model);
  }

}
