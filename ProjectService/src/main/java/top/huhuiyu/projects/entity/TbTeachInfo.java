package top.huhuiyu.projects.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbTeachInfo表
 * 
 * @author 胡辉煜
 */
public class TbTeachInfo extends BaseEntity {

  private static final long serialVersionUID = 7118839891949923803L;

  private java.lang.Integer tiid;
  private java.lang.Integer tstid;
  private java.lang.Integer scid;
  private java.lang.String  link;
  private java.lang.String  info;
  private java.lang.String  enable;
  private java.util.Date    lastupdate;
  private TbSysConfig       linktype;
  private TbTeachSubtype    subtype;

  public TbTeachInfo() {
  }

  public java.lang.Integer getTiid() {
    return tiid;
  }

  public void setTiid(java.lang.Integer tiid) {
    this.tiid = tiid;
  }

  public java.lang.Integer getTstid() {
    return tstid;
  }

  public void setTstid(java.lang.Integer tstid) {
    this.tstid = tstid;
  }

  public java.lang.Integer getScid() {
    return scid;
  }

  public void setScid(java.lang.Integer scid) {
    this.scid = scid;
  }

  public java.lang.String getLink() {
    return link;
  }

  public void setLink(java.lang.String link) {
    this.link = link;
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

  public TbSysConfig getLinktype() {
    return linktype;
  }

  public void setLinktype(TbSysConfig linktype) {
    this.linktype = linktype;
  }

  public TbTeachSubtype getSubtype() {
    return subtype;
  }

  public void setSubtype(TbTeachSubtype subtype) {
    this.subtype = subtype;
  }

}
