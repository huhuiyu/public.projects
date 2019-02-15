package top.huhuiyu.projects.model;

import top.huhuiyu.projects.base.MyBasePageModel;
import top.huhuiyu.projects.entity.TbTeachType;

/**
 * TbTeachType的Model
 * 
 * @author 胡辉煜
 */
public class TbTeachTypeModel extends MyBasePageModel {

  private static final long serialVersionUID = 6019171218269860788L;

  private TbTeachType tbTeachType = new TbTeachType();

  public TbTeachTypeModel() {
  }

  public TbTeachType getTbTeachType() {
    return tbTeachType;
  }

  public void setTbTeachType(TbTeachType tbTeachType) {
    this.tbTeachType = tbTeachType;
  }

}
