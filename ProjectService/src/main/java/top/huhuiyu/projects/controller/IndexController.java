package top.huhuiyu.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.mybase.INoToken;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.IndexModel;
import top.huhuiyu.projects.service.IndexService;

/**
 * 首页
 * 
 * @author 胡辉煜
 */
@RestController
public class IndexController implements INoToken {
  @Autowired
  private IndexService indexService;

  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    return indexService.index(model);
  }
}
