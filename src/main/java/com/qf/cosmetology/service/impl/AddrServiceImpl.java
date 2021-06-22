package com.qf.cosmetology.service.impl;

import com.qf.cosmetology.entity.Addr;
import com.qf.cosmetology.dao.AddrDao;
import com.qf.cosmetology.service.AddrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Addr)表服务实现类
 *
 * @author makejava
 * @since 2021-06-22 12:38:18
 */
@Service("addrService")
public class AddrServiceImpl implements AddrService {
    @Resource
    private AddrDao addrDao;

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    @Override
    public Addr queryById(Integer aId) {
        return this.addrDao.queryById(aId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Addr> queryAllByLimit(int offset, int limit) {
        return this.addrDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param addr 实例对象
     * @return 实例对象
     */
    @Override
    public Addr insert(Addr addr) {
        this.addrDao.insert(addr);
        return addr;
    }

    /**
     * 修改数据
     *
     * @param addr 实例对象
     * @return 实例对象
     */
    @Override
    public Addr update(Addr addr) {
        this.addrDao.update(addr);
        return this.queryById(addr.getAId());
    }

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer aId) {
        return this.addrDao.deleteById(aId) > 0;
    }
}
