package com.qf.cosmetology.dao;

import com.qf.cosmetology.entity.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Pic)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-22 15:03:00
 */
public interface PicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Pic queryById(Integer pId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Pic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pic 实例对象
     * @return 对象列表
     */
    List<Pic> queryAll(Pic pic);

    List<Pic> queryAllPic();
    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 影响行数
     */
    int insert(Pic pic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Pic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Pic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Pic> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Pic> entities);

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 影响行数
     */
    int update(Pic pic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

    /**
     * 根据图片类型获取所有图片
     * @param type
     * @return
     */
    List<Pic> queryByType(String type);

    Integer getCount();

    Integer updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}

