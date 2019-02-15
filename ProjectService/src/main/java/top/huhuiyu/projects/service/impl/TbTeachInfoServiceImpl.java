package top.huhuiyu.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.api.utils.mybase.PageBean;
import top.huhuiyu.projects.dao.TbSysConfigDAO;
import top.huhuiyu.projects.dao.TbTeachInfoDAO;
import top.huhuiyu.projects.dao.TbTeachSubtypeDAO;
import top.huhuiyu.projects.dao.TbTeachTypeDAO;
import top.huhuiyu.projects.entity.TbTeachInfo;
import top.huhuiyu.projects.entity.TbTeachSubtype;
import top.huhuiyu.projects.entity.TbTeachType;
import top.huhuiyu.projects.model.TbTeachInfoModel;
import top.huhuiyu.projects.service.TbTeachInfoService;

/**
 * TbTeachInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTeachInfoServiceImpl implements TbTeachInfoService {
  @Autowired
  private TbTeachInfoDAO    tbTeachInfoDAO;
  @Autowired
  private TbTeachSubtypeDAO tbTeachSubtypeDAO;
  @Autowired
  private TbTeachTypeDAO    tbTeachTypeDAO;
  @Autowired
  private TbSysConfigDAO    tbSysConfigDAO;

  @Override
  public JsonMessage queryBySubtype(TbTeachInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("list", tbTeachInfoDAO.queryBySubtype(model.getTbTeachInfo()));
    message.putData("config", tbSysConfigDAO.queryOssUrl());
    return message;
  }

  @Override
  public JsonMessage queryModifyBaseInfo(TbTeachInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("infotypes", tbSysConfigDAO.queryTeachInfoType());
    TbTeachType type = new TbTeachType();
    type.setEnable("y");
    message.putData("types", tbTeachTypeDAO.queryAll(type));
    TbTeachSubtype subtype = new TbTeachSubtype();
    subtype.setTstid(model.getTbTeachInfo().getTstid());
    message.putData("subtypes", tbTeachSubtypeDAO.queryBySubType(subtype));
    return message;
  }

  @Override
  public JsonMessage queryAddBaseInfo(TbTeachInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("infotypes", tbSysConfigDAO.queryTeachInfoType());
    TbTeachType type = new TbTeachType();
    type.setEnable("y");
    message.putData("types", tbTeachTypeDAO.queryAll(type));
    return message;
  }

  // 基础方法============================================================================

  @Override
  public JsonMessage queryAll(TbTeachInfoModel model) throws Exception {
    TbTeachInfo tbTeachInfo = model.getTbTeachInfo();
    PageBean    page        = model.getPage();
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbTeachInfo> list = (Page<TbTeachInfo>) tbTeachInfoDAO.queryAll(tbTeachInfo);
    model.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbTeachInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbTeachInfo", tbTeachInfoDAO.queryByKey(model.getTbTeachInfo()));
    return message;
  }

  @Override
  public JsonMessage add(TbTeachInfoModel model) throws Exception {
    int result = tbTeachInfoDAO.add(model.getTbTeachInfo());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbTeachInfoModel model) throws Exception {
    int result = tbTeachInfoDAO.delete(model.getTbTeachInfo());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbTeachInfoModel model) throws Exception {
    int result = tbTeachInfoDAO.update(model.getTbTeachInfo());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
