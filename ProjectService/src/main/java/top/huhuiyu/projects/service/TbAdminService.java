package top.huhuiyu.projects.service;

import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.entity.TbAdmin;
import top.huhuiyu.projects.entity.TbTokenInfo;
import top.huhuiyu.projects.model.TbAdminModel;

/**
 * TbAdmin的Service
 * 
 * @author 胡辉煜
 */
public interface TbAdminService {
  /**
   * 获取登录信息
   * 
   * @param tokenInfo
   *                  token信息
   * @return 登录信息
   * @throws Exception
   *                   处理发生错误
   */
  TbAdmin getTokenAdmin(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 获取登录信息
   * 
   * @param model
   *              页面提交数据
   * @return 登录信息
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage getAdminInfo(TbAdminModel model) throws Exception;

  /**
   * 登录
   * 
   * @param model
   *              页面提交数据
   * @return 登录结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage logout(TbAdminModel model) throws Exception;

  /**
   * 登出
   * 
   * @param model
   *              页面提交数据
   * @return 登出结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage login(TbAdminModel model) throws Exception;

  /**
   * 修改密码
   * 
   * @param model
   *              页面提交数据
   * @return 修改密码的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage modifyPwd(TbAdminModel model) throws Exception;

  // 基础方法============================================================================
  /**
   * 修改TbAdmin信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbAdmin信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbAdminModel model) throws Exception;

  /**
   * 删除TbAdmin信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbAdmin信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbAdminModel model) throws Exception;

  /**
   * 添加TbAdmin信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbAdmin信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbAdminModel model) throws Exception;

  /**
   * 按照主键查询TbAdmin信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbAdmin信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbAdminModel model) throws Exception;

  /**
   * 分页查询TbAdmin信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbAdmin信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbAdminModel model) throws Exception;

}
