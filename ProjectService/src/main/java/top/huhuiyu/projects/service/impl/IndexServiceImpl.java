package top.huhuiyu.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.dao.UtilsDAO;
import top.huhuiyu.projects.model.IndexModel;
import top.huhuiyu.projects.service.IndexService;

/**
 * 首页服务层实现
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index(IndexModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess(model.getEcho());
    message.getDatas().put("now", utilsDAO.queryTime());
    return message;
  }
}
