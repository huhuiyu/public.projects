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
import top.huhuiyu.projects.dao.TbTeachTypeDAO;
import top.huhuiyu.projects.entity.TbTeachType;
import top.huhuiyu.projects.model.TbTeachTypeModel;
import top.huhuiyu.projects.service.TbTeachTypeService;

/**
 * TbTeachType的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTeachTypeServiceImpl implements TbTeachTypeService {
  @Autowired
  private TbTeachTypeDAO tbTeachTypeDAO;

  @Override
  public JsonMessage queryAllNoPage(TbTeachTypeModel model) throws Exception {
    List<TbTeachType> list    = tbTeachTypeDAO.queryAll(model.getTbTeachType());
    JsonMessage       message = JsonMessage.getSuccess("");
    message.putData("list", list);
    return message;
  }

  // 基础方法============================================================================

  @Override
  public JsonMessage queryAll(TbTeachTypeModel model) throws Exception {
    PageBean page = model.getPage();
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbTeachType> list = (Page<TbTeachType>) tbTeachTypeDAO.queryAll(model.getTbTeachType());
    model.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbTeachTypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbTeachType", tbTeachTypeDAO.queryByKey(model.getTbTeachType()));
    return message;
  }

  @Override
  public JsonMessage add(TbTeachTypeModel model) throws Exception {
    TbTeachType tbTeachType = model.getTbTeachType();
    if (StringUtils.isEmpty(tbTeachType.getTypeName())) {
      return JsonMessage.getFail("分类名称必须填写");
    }
    if (StringUtils.isEmpty(tbTeachType.getIconfont())) {
      return JsonMessage.getFail("图标必须填写");
    }
    tbTeachType.setInfo(StringUtils.trim(tbTeachType.getInfo()));
    TbTeachType stype = tbTeachTypeDAO.queryByTypeName(tbTeachType);
    if (stype != null) {
      return JsonMessage.getFail("分类名称已经存在");
    }
    int result = tbTeachTypeDAO.add(model.getTbTeachType());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbTeachTypeModel model) throws Exception {
    int result = tbTeachTypeDAO.delete(model.getTbTeachType());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbTeachTypeModel model) throws Exception {
    TbTeachType tbTeachType = model.getTbTeachType();
    if (StringUtils.isEmpty(tbTeachType.getTypeName())) {
      return JsonMessage.getFail("分类名称必须填写");
    }
    if (StringUtils.isEmpty(tbTeachType.getIconfont())) {
      return JsonMessage.getFail("图标必须填写");
    }
    tbTeachType.setInfo(StringUtils.trim(tbTeachType.getInfo()));
    TbTeachType idtype   = tbTeachTypeDAO.queryByKey(tbTeachType);
    TbTeachType nametype = tbTeachTypeDAO.queryByTypeName(tbTeachType);
    // id查询的名称如果和name查询的不同，表示数据库中存在相同名称记录
    if ((nametype != null) && (idtype != null) && !idtype.getTypeName().equals(nametype.getTypeName())) {
      return JsonMessage.getFail("分类名称已经存在");
    }
    int result = tbTeachTypeDAO.update(model.getTbTeachType());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
