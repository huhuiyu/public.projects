package top.huhuiyu.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import top.huhuiyu.api.fileutil.Md5;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.api.utils.mybase.PageBean;
import top.huhuiyu.projects.dao.TbAdminDAO;
import top.huhuiyu.projects.entity.TbAdmin;
import top.huhuiyu.projects.entity.TbTokenInfo;
import top.huhuiyu.projects.model.TbAdminModel;
import top.huhuiyu.projects.service.TbAdminService;

/**
 * TbAdmin的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAdminServiceImpl implements TbAdminService {
  private static final String ENABLE = "y";
  @Autowired
  private TbAdminDAO          tbAdminDAO;

  @Override
  public JsonMessage modifyPwd(TbAdminModel model) throws Exception {
    TbAdmin loginAdmin = model.getLoginAdmin();
    TbAdmin admin      = model.getTbAdmin();
    if (StringUtils.isEmpty(model.getOldPwd())) {
      return JsonMessage.getFail("旧密码必须填写");
    }
    if (StringUtils.isEmpty(admin.getPassword())) {
      return JsonMessage.getFail("新密码必须填写");
    }
    if (model.getOldPwd().equals(admin.getPassword())) {
      return JsonMessage.getFail("新旧密码一致");
    }
    if (!Md5.checkSaltMd5(model.getOldPwd(), loginAdmin.getPwdsalt(), loginAdmin.getPassword())) {
      return JsonMessage.getFail("旧密码不正确");
    }
    loginAdmin.setPassword(Md5.saltMd5(admin.getPassword(), loginAdmin.getPwdsalt()));
    int result = tbAdminDAO.modifyPwd(loginAdmin);
    return result == 1 ? JsonMessage.getSuccess("密码修改成功") : JsonMessage.getFail("密码修改失败");
  }

  @Override
  public JsonMessage login(TbAdminModel model) throws Exception {
    TbAdmin admin = model.getTbAdmin();
    if (StringUtils.isEmpty(admin.getUsername())) {
      return JsonMessage.getFail("用户名必须填写");
    }
    if (StringUtils.isEmpty(admin.getPassword())) {
      return JsonMessage.getFail("密码必须填写");
    }
    TbAdmin sadmin = tbAdminDAO.queryByUsername(admin);
    if (sadmin == null) {
      return JsonMessage.getFail("用户名错误");
    }
    if (!ENABLE.equalsIgnoreCase(sadmin.getEnable())) {
      return JsonMessage.getFail("用户已经冻结");
    }
    if (!Md5.checkSaltMd5(admin.getPassword(), sadmin.getPwdsalt(), sadmin.getPassword())) {
      return JsonMessage.getFail("密码错误");
    }
    // 处理token
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tbAdminDAO.deleteTokenAdmin(tokenInfo);
    tokenInfo.setInfo(sadmin.getAid() + "");
    tbAdminDAO.addTokenAdmin(tokenInfo);
    return JsonMessage.getSuccess("登录成功");
  }

  @Override
  public JsonMessage logout(TbAdminModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tbAdminDAO.deleteTokenAdmin(tokenInfo);
    return JsonMessage.getSuccess("登出成功");
  }

  @Override
  public JsonMessage getAdminInfo(TbAdminModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    TbAdmin     admin     = getTokenAdmin(tokenInfo);
    JsonMessage message   = JsonMessage.getSuccess("");
    if (admin != null) {
      admin.setAid(null);
      admin.setPassword(null);
      admin.setPwdsalt(null);
      admin.setEnable(null);
      message.putData("admin", admin);
    }
    return message;
  }

  @Override
  public TbAdmin getTokenAdmin(TbTokenInfo tokenInfo) throws Exception {
    return tbAdminDAO.queryTokenAdmin(tokenInfo);
  }

  // 基础方法============================================================================

  @Override
  public JsonMessage queryAll(TbAdminModel model) throws Exception {
    PageBean page = model.getPage();
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbAdmin> list = (Page<TbAdmin>) tbAdminDAO.queryAll();
    model.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbAdminModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbAdmin", tbAdminDAO.queryByKey(model.getTbAdmin()));
    return message;
  }

  @Override
  public JsonMessage add(TbAdminModel model) throws Exception {
    int result = tbAdminDAO.add(model.getTbAdmin());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbAdminModel model) throws Exception {
    int result = tbAdminDAO.delete(model.getTbAdmin());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbAdminModel model) throws Exception {
    int result = tbAdminDAO.update(model.getTbAdmin());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
