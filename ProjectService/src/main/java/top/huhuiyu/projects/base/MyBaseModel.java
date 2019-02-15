package top.huhuiyu.projects.base;

import top.huhuiyu.api.utils.mybase.BaseModel;
import top.huhuiyu.projects.entity.TbAdmin;
import top.huhuiyu.projects.entity.TbToken;
import top.huhuiyu.projects.entity.TbTokenInfo;

/**
 * model层基类
 * 
 * @author 胡辉煜
 */
public class MyBaseModel extends BaseModel {
  private static final long serialVersionUID = 9077955457629675262L;
  private TbAdmin           loginAdmin;

  public MyBaseModel() {
  }

  public TbAdmin getLoginAdmin() {
    return loginAdmin;
  }

  public void setLoginAdmin(TbAdmin loginAdmin) {
    this.loginAdmin = loginAdmin;
  }

  /**
   * 获取token的委托方法
   * 
   * @return TbToken信息
   */
  public TbToken makeTbToken() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(getToken());
    return tbToken;
  }

  /**
   * 获取tokeninfo的委托方法
   * 
   * @return TbTokenInfo信息
   */
  public TbTokenInfo makeTbTokenInfo() {
    TbTokenInfo tokenInfo = new TbTokenInfo();
    tokenInfo.setToken(getToken());
    return tokenInfo;
  }

}
