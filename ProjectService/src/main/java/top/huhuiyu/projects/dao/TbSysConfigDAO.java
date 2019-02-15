package top.huhuiyu.projects.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.projects.entity.TbSysConfig;

/**
 * TbSysConfig表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbSysConfigDAO {

  /**
   * 查询教学信息分类
   * 
   * @return 教学信息分类
   * @throws Exception
   *                   处理发生异常
   */
  List<TbSysConfig> queryTeachInfoType() throws Exception;

  /**
   * 查询ossurl信息
   * 
   * @return ossurl信息
   * @throws Exception
   *                   处理发生异常
   */
  TbSysConfig queryOssUrl() throws Exception;

  // 基础方法=============================================================================
  /**
   * 查询全部TbSysConfig
   *
   * @return TbSysConfig的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbSysConfig> queryAll() throws Exception;

  /**
   * 按照主键查询TbSysConfig
   *
   * @param tbSysConfig主键信息
   * @return 主键查询TbSysConfig的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbSysConfig queryByKey(TbSysConfig tbSysConfig) throws Exception;

  /**
   * 添加TbSysConfig信息
   *
   * @param tbSysConfig信息
   * @return 添加tbSysConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbSysConfig tbSysConfig) throws Exception;

  /**
   * 修改TbSysConfig信息
   *
   * @param tbSysConfig信息
   * @return 修改tbSysConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbSysConfig tbSysConfig) throws Exception;

  /**
   * 删除TbSysConfig信息
   *
   * @param tbSysConfig信息
   * @return 删除tbSysConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbSysConfig tbSysConfig) throws Exception;

}
