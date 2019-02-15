package top.huhuiyu.projects.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbAdmin表
 * 
 * @author 胡辉煜
 */
public class TbAdmin extends BaseEntity {

  private static final long serialVersionUID = 5682230482508873288L;

  private java.lang.Integer aid;
  private java.lang.String  username;
  private java.lang.String  password;
  private java.lang.String  pwdsalt;
  private java.lang.String  enable;
  private java.util.Date    lastupdate;

  public TbAdmin() {
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getUsername() {
    return username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }

  public java.lang.String getPassword() {
    return password;
  }

  public void setPassword(java.lang.String password) {
    this.password = password;
  }

  public java.lang.String getPwdsalt() {
    return pwdsalt;
  }

  public void setPwdsalt(java.lang.String pwdsalt) {
    this.pwdsalt = pwdsalt;
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
