package top.huhuiyu.projects.service;

import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachTypeModel;

/**
 * TbTeachType的Service
 * 
 * @author 胡辉煜
 */
public interface TbTeachTypeService {

  /**
   * 查询全部TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 查询全部TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAllNoPage(TbTeachTypeModel model) throws Exception;

  // 基础方法============================================================================
  /**
   * 修改TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbTeachTypeModel model) throws Exception;

  /**
   * 删除TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbTeachTypeModel model) throws Exception;

  /**
   * 添加TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbTeachTypeModel model) throws Exception;

  /**
   * 按照主键查询TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbTeachTypeModel model) throws Exception;

  /**
   * 分页查询TbTeachType信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbTeachType信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbTeachTypeModel model) throws Exception;

}
