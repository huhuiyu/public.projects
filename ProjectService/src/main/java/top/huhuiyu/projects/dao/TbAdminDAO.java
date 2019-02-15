package top.huhuiyu.projects.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.projects.entity.TbAdmin;
import top.huhuiyu.projects.entity.TbTokenInfo;

/**
 * TbAdmin表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbAdminDAO {
  /**
   * 查询登录admin
   * 
   * @param tokenInfo
   *                  token信息
   * @return 登录admin
   * @throws Exception
   *                   处理发生异常
   */
  TbAdmin queryTokenAdmin(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 添加登录admin
   * 
   * @param tokenInfo
   *                  token信息
   * @return 添加登录admin的结果
   * @throws Exception
   */
  int addTokenAdmin(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除登录admin
   * 
   * @param tokenInfo
   *                  token信息
   * @return 删除登录admin的结果
   * @throws Exception
   */
  int deleteTokenAdmin(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 按照姓名查询TbAdmin
   *
   * @param tbAdmin姓名信息
   * @return 姓名查询TbAdmin的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbAdmin queryByUsername(TbAdmin tbAdmin) throws Exception;

  /**
   * 修改密码
   *
   * @param tbAdmin信息
   * @return 修改密码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int modifyPwd(TbAdmin tbAdmin) throws Exception;

  // 基础方法=============================================================================
  /**
   * 查询全部TbAdmin
   *
   * @return TbAdmin的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbAdmin> queryAll() throws Exception;

  /**
   * 按照主键查询TbAdmin
   *
   * @param tbAdmin主键信息
   * @return 主键查询TbAdmin的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbAdmin queryByKey(TbAdmin tbAdmin) throws Exception;

  /**
   * 添加TbAdmin信息
   *
   * @param tbAdmin信息
   * @return 添加tbAdmin信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbAdmin tbAdmin) throws Exception;

  /**
   * 修改TbAdmin信息
   *
   * @param tbAdmin信息
   * @return 修改tbAdmin信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbAdmin tbAdmin) throws Exception;

  /**
   * 删除TbAdmin信息
   *
   * @param tbAdmin信息
   * @return 删除tbAdmin信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbAdmin tbAdmin) throws Exception;

}
