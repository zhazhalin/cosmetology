package com.qf.cosmetology.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.cosmetology.entity.Pic;
import com.qf.cosmetology.result.ResponseData;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * (Pic)表服务接口
 *
 * @author makejava
 * @since 2021-06-22 15:03:00
 */
public interface PicService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Pic queryById(Integer pId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    Pic insert(Pic pic);

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    Pic update(Pic pic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);

    /**
     * 通过图片类型获取对应轮播图或者是导航栏图片
     * @param type
     * @return
     */
    ResponseData queryByType(String type);

    Object queryAll();

    ResponseData updateStatus(Integer id, Integer status);

    ResponseData delete(JSONArray array);
}
