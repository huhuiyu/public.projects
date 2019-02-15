package top.huhuiyu.projects.base;

import com.github.pagehelper.Page;
import top.huhuiyu.api.utils.mybase.PageBean;

/**
 * 带分页信息的model基类
 * 
 * @author 胡辉煜
 */
public class MyBasePageModel extends MyBaseModel {
  private static final long serialVersionUID = -8563908600786083918L;
  private PageBean          page             = new PageBean();

  public MyBasePageModel() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /**
   * 设置分页信息
   * 
   * @param page
   *             分页插件查询信息
   */
  public void setPageInfo(Page<?> page) {
    this.page.setPageCount(page.getPages());
    this.page.setPageNumber(page.getPageNum());
    this.page.setPageSize(page.getPageSize());
    this.page.setTotal(page.getTotal());
  }

}
