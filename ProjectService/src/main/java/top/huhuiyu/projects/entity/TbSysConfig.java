package top.huhuiyu.projects.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbSysConfig表
 * 
 * @author 胡辉煜
 */
public class TbSysConfig extends BaseEntity {

  private static final long serialVersionUID = 3191899009169469328L;

  private java.lang.Integer scid;
  private java.lang.String  typeCode;
  private java.lang.String  infoCode;
  private java.lang.String  infoValue;
  private java.util.Date    lastupdate;

  public TbSysConfig() {
  }

  public java.lang.Integer getScid() {
    return scid;
  }

  public void setScid(java.lang.Integer scid) {
    this.scid = scid;
  }

  public java.lang.String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(java.lang.String typeCode) {
    this.typeCode = typeCode;
  }

  public java.lang.String getInfoCode() {
    return infoCode;
  }

  public void setInfoCode(java.lang.String infoCode) {
    this.infoCode = infoCode;
  }

  public java.lang.String getInfoValue() {
    return infoValue;
  }

  public void setInfoValue(java.lang.String infoValue) {
    this.infoValue = infoValue;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
