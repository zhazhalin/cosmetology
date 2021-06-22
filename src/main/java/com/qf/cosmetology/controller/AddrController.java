package com.qf.cosmetology.controller;

import com.qf.cosmetology.entity.Addr;
import com.qf.cosmetology.service.AddrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Addr)表控制层
 *
 * @author makejava
 * @since 2021-06-22 12:38:18
 */
@RestController
@RequestMapping("addr")
public class AddrController {
    /**
     * 服务对象
     */
    @Resource
    private AddrService addrService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Addr selectOne(Integer id) {
        return this.addrService.queryById(id);
    }

}
