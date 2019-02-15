package top.huhuiyu.projects.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.projects.entity.TbTeachType;

/**
 * TbTeachType表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbTeachTypeDAO {

  /**
   * 按照分类名称查询TbTeachType
   *
   * @param tbTeachType分类名称信息
   * @return 分类名称查询TbTeachType的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTeachType queryByTypeName(TbTeachType tbTeachType) throws Exception;

  // 基础方法=============================================================================
  /**
   * 查询全部TbTeachType
   * 
   * @param tbTeachType
   *                    查询参数
   * @return TbTeachType的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachType> queryAll(TbTeachType tbTeachType) throws Exception;

  /**
   * 按照主键查询TbTeachType
   *
   * @param tbTeachType主键信息
   * @return 主键查询TbTeachType的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTeachType queryByKey(TbTeachType tbTeachType) throws Exception;

  /**
   * 添加TbTeachType信息
   *
   * @param tbTeachType信息
   * @return 添加tbTeachType信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbTeachType tbTeachType) throws Exception;

  /**
   * 修改TbTeachType信息
   *
   * @param tbTeachType信息
   * @return 修改tbTeachType信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbTeachType tbTeachType) throws Exception;

  /**
   * 删除TbTeachType信息
   *
   * @param tbTeachType信息
   * @return 删除tbTeachType信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbTeachType tbTeachType) throws Exception;

}
