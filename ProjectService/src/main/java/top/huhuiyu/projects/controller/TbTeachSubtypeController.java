package top.huhuiyu.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachSubtypeModel;
import top.huhuiyu.projects.service.TbTeachSubtypeService;

/**
 * 前台TbTeachSubtype
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/teachsubtype")
public class TbTeachSubtypeController {

  @Autowired
  private TbTeachSubtypeService tbTeachSubtypeService;

  @RequestMapping("/queryByType")
  public JsonMessage queryByType(TbTeachSubtypeModel model) throws Exception {
    return tbTeachSubtypeService.queryByType(model);
  }

}
