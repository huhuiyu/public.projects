package top.huhuiyu.projects.service;

import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.model.TbTeachInfoModel;

/**
 * TbTeachInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbTeachInfoService {

  /**
   * 查询分类信息表的数据
   * 
   * @param model
   *              页面提交数据
   * @return 分类信息表的数据
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryBySubtype(TbTeachInfoModel model) throws Exception;

  /**
   * 查询添加关联信息表的数据
   * 
   * @param model
   *              页面提交数据
   * @return 关联信息表的数据
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAddBaseInfo(TbTeachInfoModel model) throws Exception;

  /**
   * 查询修改关联信息表的数据
   * 
   * @param model
   *              页面提交数据
   * @return 关联信息表的数据
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryModifyBaseInfo(TbTeachInfoModel model) throws Exception;

  // 基础方法============================================================================

  /**
   * 修改TbTeachInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbTeachInfoModel model) throws Exception;

  /**
   * 删除TbTeachInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbTeachInfoModel model) throws Exception;

  /**
   * 添加TbTeachInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbTeachInfoModel model) throws Exception;

  /**
   * 按照主键查询TbTeachInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbTeachInfoModel model) throws Exception;

  /**
   * 分页查询TbTeachInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbTeachInfoModel model) throws Exception;

}
