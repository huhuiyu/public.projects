package top.huhuiyu.projects.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbTeachType表
 * 
 * @author 胡辉煜
 */
public class TbTeachType extends BaseEntity {

  private static final long serialVersionUID = -2501988205634428227L;

  private java.lang.Integer ttid;
  private java.lang.String  typeName;
  private java.lang.String  iconfont;
  private java.lang.String  info;
  private java.lang.String  enable;
  private java.util.Date    lastupdate;

  public TbTeachType() {
  }

  public java.lang.Integer getTtid() {
    return ttid;
  }

  public void setTtid(java.lang.Integer ttid) {
    this.ttid = ttid;
  }

  public java.lang.String getTypeName() {
    return typeName;
  }

  public void setTypeName(java.lang.String typeName) {
    this.typeName = typeName;
  }

  public java.lang.String getIconfont() {
    return iconfont;
  }

  public void setIconfont(java.lang.String iconfont) {
    this.iconfont = iconfont;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.lang.String getEnable() {
    return enable;
  }

  public void setEnable(java.lang.String enable) {
    this.enable = enable;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
