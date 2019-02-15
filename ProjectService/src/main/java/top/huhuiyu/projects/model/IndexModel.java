package top.huhuiyu.projects.model;

import top.huhuiyu.projects.base.MyBaseModel;

/**
 * 首页model层
 * 
 * @author 胡辉煜
 */
public class IndexModel extends MyBaseModel {

  private static final long serialVersionUID = 1333873923062621381L;
  private String            echo;

  public IndexModel() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

}
