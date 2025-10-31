package cn.wenzhuo4657.dailyWeb.infrastructure.database.dao;


import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.UserSelector;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserSelector)表数据库访问层
 *
 * @author makejava
 * @since 2025-10-27 21:55:13
 */
public interface UserSelectorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserSelector queryById(Integer id);

  
    /**
     * 统计总行数
     *
     * @param userSelector 查询条件
     * @return 总行数
     */
    long count(UserSelector userSelector);

    /**
     * 新增数据
     *
     * @param userSelector 实例对象
     * @return 影响行数
     */
    int insert(UserSelector userSelector);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelector> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserSelector> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelector> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserSelector> entities);

    /**
     * 修改数据
     *
     * @param userSelector 实例对象
     * @return 影响行数
     */
    int update(UserSelector userSelector);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

