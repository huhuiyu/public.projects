package top.huhuiyu.projects.model;

import top.huhuiyu.projects.base.MyBasePageModel;
import top.huhuiyu.projects.entity.TbTeachSubtype;

/**
 * TbTeachSubtype的Model
 * 
 * @author 胡辉煜
 */
public class TbTeachSubtypeModel extends MyBasePageModel {

  private static final long serialVersionUID = 7847864922447673150L;

  private TbTeachSubtype tbTeachSubtype = new TbTeachSubtype();

  public TbTeachSubtypeModel() {
  }

  public TbTeachSubtype getTbTeachSubtype() {
    return tbTeachSubtype;
  }

  public void setTbTeachSubtype(TbTeachSubtype tbTeachSubtype) {
    this.tbTeachSubtype = tbTeachSubtype;
  }

}
