package top.huhuiyu.projects.service;

import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbSysConfigModel;

/**
 * TbSysConfig的Service
 * 
 * @author 胡辉煜
 */
public interface TbSysConfigService {

  // 基础方法============================================================================
  /**
   * 修改TbSysConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbSysConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbSysConfigModel model) throws Exception;

  /**
   * 删除TbSysConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbSysConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbSysConfigModel model) throws Exception;

  /**
   * 添加TbSysConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbSysConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbSysConfigModel model) throws Exception;

  /**
   * 按照主键查询TbSysConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbSysConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbSysConfigModel model) throws Exception;

  /**
   * 分页查询TbSysConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbSysConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbSysConfigModel model) throws Exception;

}
