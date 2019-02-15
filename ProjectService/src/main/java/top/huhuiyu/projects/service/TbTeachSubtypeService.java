package top.huhuiyu.projects.service;

import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachSubtypeModel;

/**
 * TbTeachSubtype的Service
 * 
 * @author 胡辉煜
 */
public interface TbTeachSubtypeService {

  /**
   * 分类查询TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 分类查询TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByType(TbTeachSubtypeModel model) throws Exception;

  // 基础方法============================================================================
  /**
   * 修改TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbTeachSubtypeModel model) throws Exception;

  /**
   * 删除TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbTeachSubtypeModel model) throws Exception;

  /**
   * 添加TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbTeachSubtypeModel model) throws Exception;

  /**
   * 按照主键查询TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbTeachSubtypeModel model) throws Exception;

  /**
   * 分页查询TbTeachSubtype信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbTeachSubtypeModel model) throws Exception;

}
