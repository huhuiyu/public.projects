package top.huhuiyu.projects.model;

import top.huhuiyu.projects.base.MyBasePageModel;
import top.huhuiyu.projects.entity.TbSysConfig;

/**
 * TbSysConfig的Model
 * 
 * @author 胡辉煜
 */
public class TbSysConfigModel extends MyBasePageModel {

  private static final long serialVersionUID = -1045309862403952278L;

  private TbSysConfig tbSysConfig = new TbSysConfig();

  public TbSysConfigModel() {
  }

  public TbSysConfig getTbSysConfig() {
    return tbSysConfig;
  }

  public void setTbSysConfig(TbSysConfig tbSysConfig) {
    this.tbSysConfig = tbSysConfig;
  }

}
