package cn.wenzhuo4657.dailyWeb.infrastructure.database.dao;


import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Usernotifier;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Usernotifier)表数据库访问层
 *
 * @author makejava
 * @since 2025-11-04 16:35:22
 */
public interface UsernotifierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Usernotifier queryById(Integer id);

  
    /**
     * 统计总行数
     *
     * @param usernotifier 查询条件
     * @return 总行数
     */
    long count(Usernotifier usernotifier);

    /**
     * 新增数据
     *
     * @param usernotifier 实例对象
     * @return 影响行数
     */
    int insert(Usernotifier usernotifier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usernotifier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Usernotifier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usernotifier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Usernotifier> entities);

    /**
     * 修改数据
     *
     * @param usernotifier 实例对象
     * @return 影响行数
     */
    int update(Usernotifier usernotifier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    String queryByNotifyId(Integer notifyId);

    List<Usernotifier> querByUserId(Integer userId);
}

