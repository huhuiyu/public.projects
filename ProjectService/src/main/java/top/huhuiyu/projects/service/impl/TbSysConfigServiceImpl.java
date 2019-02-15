package top.huhuiyu.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.api.utils.mybase.PageBean;
import top.huhuiyu.projects.dao.TbSysConfigDAO;
import top.huhuiyu.projects.entity.TbSysConfig;
import top.huhuiyu.projects.model.TbSysConfigModel;
import top.huhuiyu.projects.service.TbSysConfigService;

/**
 * TbSysConfig的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbSysConfigServiceImpl implements TbSysConfigService {
  @Autowired
  private TbSysConfigDAO tbSysConfigDAO;

  // 基础方法============================================================================

  @Override
  public JsonMessage queryAll(TbSysConfigModel model) throws Exception {
    PageBean page = model.getPage();
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbSysConfig> list = (Page<TbSysConfig>) tbSysConfigDAO.queryAll();
    model.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbSysConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbSysConfig", tbSysConfigDAO.queryByKey(model.getTbSysConfig()));
    return message;
  }

  @Override
  public JsonMessage add(TbSysConfigModel model) throws Exception {
    int result = tbSysConfigDAO.add(model.getTbSysConfig());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbSysConfigModel model) throws Exception {
    int result = tbSysConfigDAO.delete(model.getTbSysConfig());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbSysConfigModel model) throws Exception {
    int result = tbSysConfigDAO.update(model.getTbSysConfig());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
