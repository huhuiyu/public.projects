package top.huhuiyu.projects.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbTeachSubtype表
 * 
 * @author 胡辉煜
 */
public class TbTeachSubtype extends BaseEntity {

  private static final long serialVersionUID = -1974748472246082895L;

  private java.lang.Integer tstid;
  private java.lang.Integer ttid;
  private java.lang.String  subtypeName;
  private java.lang.String  iconfont;
  private java.lang.String  info;
  private java.lang.String  enable;
  private java.util.Date    lastupdate;
  private TbTeachType       type;

  public TbTeachSubtype() {
  }

  public java.lang.Integer getTstid() {
    return tstid;
  }

  public void setTstid(java.lang.Integer tstid) {
    this.tstid = tstid;
  }

  public java.lang.Integer getTtid() {
    return ttid;
  }

  public void setTtid(java.lang.Integer ttid) {
    this.ttid = ttid;
  }

  public java.lang.String getSubtypeName() {
    return subtypeName;
  }

  public void setSubtypeName(java.lang.String subtypeName) {
    this.subtypeName = subtypeName;
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

  public TbTeachType getType() {
    return type;
  }

  public void setType(TbTeachType type) {
    this.type = type;
  }

}
