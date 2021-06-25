package com.qf.cosmetology.service.impl;

import com.qf.cosmetology.entity.Pic;
import com.qf.cosmetology.dao.PicDao;
import com.qf.cosmetology.result.ResponseCode;
import com.qf.cosmetology.result.ResponseData;
import com.qf.cosmetology.service.PicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pic)表服务实现类
 *
 * @author makejava
 * @since 2021-06-22 15:03:00
 */
@Service("picService")
public class PicServiceImpl implements PicService {
    @Resource
    private PicDao picDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public Pic queryById(Integer pId) {
        return this.picDao.queryById(pId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Pic> queryAllByLimit(int offset, int limit) {
        return this.picDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Override
    public Pic insert(Pic pic) {
        this.picDao.insert(pic);
        return pic;
    }

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Override
    public Pic update(Pic pic) {
        this.picDao.update(pic);
        return this.queryById(pic.getpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.picDao.deleteById(pId) > 0;
    }

    @Override
    public ResponseData queryByType(String type) {
        List<Pic> pics=picDao.queryByType(type);
        return new ResponseData(ResponseCode.SUCCESS,pics);
    }
}
