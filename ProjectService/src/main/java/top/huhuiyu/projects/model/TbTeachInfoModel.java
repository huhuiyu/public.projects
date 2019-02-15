package top.huhuiyu.projects.model;

import top.huhuiyu.projects.base.MyBasePageModel;
import top.huhuiyu.projects.entity.TbTeachInfo;

/**
 * TbTeachInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbTeachInfoModel extends MyBasePageModel {

  private static final long serialVersionUID = -161110221199365782L;

  private TbTeachInfo tbTeachInfo = new TbTeachInfo();

  public TbTeachInfoModel() {
  }

  public TbTeachInfo getTbTeachInfo() {
    return tbTeachInfo;
  }

  public void setTbTeachInfo(TbTeachInfo tbTeachInfo) {
    this.tbTeachInfo = tbTeachInfo;
  }

}
