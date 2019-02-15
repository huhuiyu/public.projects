package top.huhuiyu.projects.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.projects.entity.TbTeachSubtype;

/**
 * TbTeachSubtype表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbTeachSubtypeDAO {

  /**
   * 查询小类所在大类信息
   * 
   * @param tbTeachSubtype
   *                       查询参数
   * @return TbTeachSubtype的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachSubtype> queryBySubType(TbTeachSubtype tbTeachSubtype) throws Exception;

  /**
   * 按照ttid查询TbTeachSubtype
   *
   * @param tbTeachSubtype
   *                       查询参数
   * @return TbTeachSubtype的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachSubtype> queryByType(TbTeachSubtype tbTeachSubtype) throws Exception;

  // 基础方法=============================================================================
  /**
   * 查询全部TbTeachSubtype
   *
   * @param tbTeachSubtype
   *                       查询参数
   * @return TbTeachSubtype的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbTeachSubtype> queryAll(TbTeachSubtype tbTeachSubtype) throws Exception;

  /**
   * 按照主键查询TbTeachSubtype
   *
   * @param tbTeachSubtype主键信息
   * @return 主键查询TbTeachSubtype的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTeachSubtype queryByKey(TbTeachSubtype tbTeachSubtype) throws Exception;

  /**
   * 添加TbTeachSubtype信息
   *
   * @param tbTeachSubtype信息
   * @return 添加tbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbTeachSubtype tbTeachSubtype) throws Exception;

  /**
   * 修改TbTeachSubtype信息
   *
   * @param tbTeachSubtype信息
   * @return 修改tbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbTeachSubtype tbTeachSubtype) throws Exception;

  /**
   * 删除TbTeachSubtype信息
   *
   * @param tbTeachSubtype信息
   * @return 删除tbTeachSubtype信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbTeachSubtype tbTeachSubtype) throws Exception;

}
