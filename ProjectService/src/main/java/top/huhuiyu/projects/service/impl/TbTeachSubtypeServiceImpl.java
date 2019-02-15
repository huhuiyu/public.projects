package top.huhuiyu.projects.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.api.utils.mybase.PageBean;
import top.huhuiyu.projects.dao.TbTeachSubtypeDAO;
import top.huhuiyu.projects.dao.TbTeachTypeDAO;
import top.huhuiyu.projects.entity.TbTeachSubtype;
import top.huhuiyu.projects.entity.TbTeachType;
import top.huhuiyu.projects.model.TbTeachSubtypeModel;
import top.huhuiyu.projects.service.TbTeachSubtypeService;

/**
 * TbTeachSubtype的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTeachSubtypeServiceImpl implements TbTeachSubtypeService {
  @Autowired
  private TbTeachSubtypeDAO tbTeachSubtypeDAO;
  @Autowired
  private TbTeachTypeDAO    tbTeachTypeDAO;

  @Override
  public JsonMessage queryByType(TbTeachSubtypeModel model) throws Exception {
    List<TbTeachSubtype> list    = tbTeachSubtypeDAO.queryByType(model.getTbTeachSubtype());
    JsonMessage          message = JsonMessage.getSuccess("");
    message.putData("list", list);
    return message;
  }

  // 基础方法============================================================================

  @Override
  public JsonMessage queryAll(TbTeachSubtypeModel model) throws Exception {
    PageBean page = model.getPage();
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbTeachSubtype> list = (Page<TbTeachSubtype>) tbTeachSubtypeDAO.queryAll(model.getTbTeachSubtype());
    model.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    TbTeachType type = new TbTeachType();
    type.setEnable("y");
    message.putData("types", tbTeachTypeDAO.queryAll(type));
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbTeachSubtypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbTeachSubtype", tbTeachSubtypeDAO.queryByKey(model.getTbTeachSubtype()));
    return message;
  }

  @Override
  public JsonMessage add(TbTeachSubtypeModel model) throws Exception {
    TbTeachSubtype subtype = model.getTbTeachSubtype();
    TbTeachType    type    = new TbTeachType();
    type.setTtid(subtype.getTtid());
    if (StringUtils.isEmpty(subtype.getSubtypeName())) {
      return JsonMessage.getFail("类型名称必须填写");
    }
    if (StringUtils.isEmpty(subtype.getIconfont())) {
      return JsonMessage.getFail("图标必须填写");
    }
    subtype.setInfo(StringUtils.trim(subtype.getInfo()));
    type = tbTeachTypeDAO.queryByKey(type);
    if (type == null) {
      return JsonMessage.getFail("分类信息错误");
    }
    int result = tbTeachSubtypeDAO.add(model.getTbTeachSubtype());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbTeachSubtypeModel model) throws Exception {
    int result = tbTeachSubtypeDAO.delete(model.getTbTeachSubtype());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbTeachSubtypeModel model) throws Exception {
    TbTeachSubtype subtype = model.getTbTeachSubtype();
    TbTeachType    type    = new TbTeachType();
    type.setTtid(subtype.getTtid());
    if (StringUtils.isEmpty(subtype.getSubtypeName())) {
      return JsonMessage.getFail("类型名称必须填写");
    }
    if (StringUtils.isEmpty(subtype.getIconfont())) {
      return JsonMessage.getFail("图标必须填写");
    }
    subtype.setInfo(StringUtils.trim(subtype.getInfo()));
    type = tbTeachTypeDAO.queryByKey(type);
    if (type == null) {
      return JsonMessage.getFail("分类信息错误");
    }
    int result = tbTeachSubtypeDAO.update(model.getTbTeachSubtype());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
