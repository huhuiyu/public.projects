package top.huhuiyu.projects.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.projects.entity.TbTeachInfo;

/**
 * TbTeachInfo表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbTeachInfoDAO {

  /**
   * 查询分类TbTeachInfo
   * 
   * @param tbTeachInfo
   *                    查询参数
   * @return 分类TbTeachInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachInfo> queryBySubtype(TbTeachInfo tbTeachInfo) throws Exception;

  // 基础方法============================================================================

  /**
   * 查询全部TbTeachInfo
   * 
   * @param tbTeachInfo
   *                    查询参数
   * @return TbTeachInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachInfo> queryAll(TbTeachInfo tbTeachInfo) throws Exception;

  /**
   * 按照主键查询TbTeachInfo
   *
   * @param tbTeachInfo主键信息
   * @return 主键查询TbTeachInfo的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTeachInfo queryByKey(TbTeachInfo tbTeachInfo) throws Exception;

  /**
   * 添加TbTeachInfo信息
   *
   * @param tbTeachInfo信息
   * @return 添加tbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbTeachInfo tbTeachInfo) throws Exception;

  /**
   * 修改TbTeachInfo信息
   *
   * @param tbTeachInfo信息
   * @return 修改tbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbTeachInfo tbTeachInfo) throws Exception;

  /**
   * 删除TbTeachInfo信息
   *
   * @param tbTeachInfo信息
   * @return 删除tbTeachInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbTeachInfo tbTeachInfo) throws Exception;

}
