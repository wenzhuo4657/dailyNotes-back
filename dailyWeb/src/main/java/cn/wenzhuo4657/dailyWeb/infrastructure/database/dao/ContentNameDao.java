package cn.wenzhuo4657.dailyWeb.infrastructure.database.dao;


import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ContentName)表数据库访问层
 *
 * @author makejava
 * @since 2025-10-27 22:33:20
 */
public interface ContentNameDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ContentName queryById(Integer id);

  
    /**
     * 统计总行数
     *
     * @param contentname 查询条件
     * @return 总行数
     */
    long count(ContentName contentname);

    /**
     * 新增数据
     *
     * @param contentname 实例对象
     * @return 影响行数
     */
    int insert(ContentName contentname);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContentName> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ContentName> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContentName> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ContentName> entities);

    /**
     * 修改数据
     *
     * @param contentname 实例对象
     * @return 影响行数
     */
    int update(ContentName contentname);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

