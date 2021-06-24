package com.qf.cosmetology.controller;

import com.qf.cosmetology.entity.Pic;
import com.qf.cosmetology.result.ResponseCode;
import com.qf.cosmetology.result.ResponseData;
import com.qf.cosmetology.service.PicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * (Pic)表控制层
 *
 * @author makejava
 * @since 2021-06-22 15:03:00
 * //满足GET请求 //当参数超过三个以后，将数据放在请求体中
 * http://localhost:8080/pics/1
 * http://localhost:8080/pics/1/zhazhalin/1
 * //当数据需要放在请求体中时，可以采用POST DELETE PUT PATCH
 * http://localhost:8080/pisc   {id:1,name:"zhazhalin"} 前端使用ajax的是有申明请求类型  type:POST
 * http://localhost:8080/pisc   {id:1,name:"zhazhalin"} 前端使用ajax的是有申明请求类型  type:PUT
 * GET请求适用于查询操作
 * POST请求适用于增加操作
 * DELETE请求适用于删除操作
 * PUT请求适用于修改操作  update user set name="zhazhalin" where id=1 修改多个属性
 * PATCH请求适用于修改操作 update user set name="zhazhalin" where id=1 只修改一个属性
 * 如何接受请求中的参数
 */
@Api("PicApi")
@RestController
@RequestMapping("/pics")
public class PicController {
    //responseBody  自动将对象转换成json数据格式
    /**
     * 服务对象
     */
    @Resource
    private PicService picService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiIgnore
    @GetMapping("selectOne")
    public Pic selectOne(Integer id) {
        return this.picService.queryById(id);
    }
    @ApiOperation(value = "queryById",notes = "通过id获取对应的图片信息")
    @ApiImplicitParam(name = "id",value = "图片的Id")
    @GetMapping("/{id}")//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseData select(@PathVariable Integer id) {
        return new ResponseData(ResponseCode.SUCCESS,1);
    }

    /**
     * 适用restful风格设计接口，数据交互方式为json格式
     * @param pic
     * @return
     */
    @PostMapping("/")
    public Pic upPic(@RequestBody Pic pic) {
        System.out.println("哈哈哈");
        return pic;
//        return this.picService.queryById(pic.getpId());
    }

}
