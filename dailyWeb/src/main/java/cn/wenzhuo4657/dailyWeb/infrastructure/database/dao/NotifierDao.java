package cn.wenzhuo4657.dailyWeb.infrastructure.database.dao;

import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Notifier;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Notifier)表数据库访问层
 *
 * @author makejava
 * @since 2025-11-10 18:17:09
 */
public interface NotifierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notifier queryById(Long id);

  
    /**
     * 统计总行数
     *
     * @param notifier 查询条件
     * @return 总行数
     */
    long count(Notifier notifier);

    /**
     * 新增数据
     *
     * @param notifier 实例对象
     * @return 影响行数
     */
    int insert(Notifier notifier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Notifier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Notifier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Notifier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Notifier> entities);

    /**
     * 修改数据
     *
     * @param notifier 实例对象
     * @return 影响行数
     */
    int update(Notifier notifier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Notifier> querByUserId(@Param("userId") Long userId);

    String queryByNotifyId(@Param("notifyId") Long notifyId);
}

