package com.qf.cosmetology.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.cosmetology.entity.Pic;
import com.qf.cosmetology.dao.PicDao;
import com.qf.cosmetology.result.ResponseCode;
import com.qf.cosmetology.result.ResponseData;
import com.qf.cosmetology.service.PicService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    public ResponseData queryAllByLimit(Integer offset, Integer limit) {
        if(offset==null&&limit==null){
            offset=0;
            limit=10;
        }else {
            offset=(offset-1)*limit;
        }
        List<Pic> pics = this.picDao.queryAllByLimit(offset, limit);
        Integer i=picDao.getCount();
        return new ResponseData("0","success",pics,i);
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

    @Override
    public ResponseData queryAll() {
        List<Pic> pics = picDao.queryAllPic();
        return new ResponseData("0","success",pics);
    }

    @Transactional
    @Override
    public ResponseData updateStatus(Integer id, Integer status) {
        //直接去进行修改
        //先去数据库判定当前数据是否已经保存
        try {
            Integer i=picDao.updateStatus(id,status);
            if(i>0){
                return new ResponseData(ResponseCode.SUCCESS);
            }else {
                return new ResponseData(ResponseCode.FAILED);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    @Override
    public ResponseData delete(JSONArray array) {
        try {
            for (int i = 0; i < array.size(); i++) {
                Integer i1 = picDao.deleteById((Integer) array.get(i));
            }
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }
}
