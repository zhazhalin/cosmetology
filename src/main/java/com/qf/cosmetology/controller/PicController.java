package com.qf.cosmetology.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.qf.cosmetology.entity.Pic;
import com.qf.cosmetology.result.ResponseCode;
import com.qf.cosmetology.result.ResponseData;
import com.qf.cosmetology.service.PicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("pics")
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
     * 局部跨级注解
     * @param type
     * @param response
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "queryByType",notes = "通过图片类型获取对应的图片信息")
    @ApiImplicitParam(name = "type",value = "图片的类型")
    @PostMapping("/{type}")//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseData queryByType(@PathVariable String type, HttpServletResponse response) {
        /*//设置访问源，*代表所有，只针对简单跨域请求
        response.setHeader("Access-Control-Allow-Origin","*");
        //设置访问限制时间，在规定时间内可以不用再发送预检请求
        response.setHeader("Access-Control-Max-Age","5000");
        //设置请求头信息
        response.setHeader("Access-Control-Headers","*");
        //设置cookie的携带，值为boolean
        response.setHeader("Access-Control-Allow-Credentials","true");
        //设置请求方式POST、GET、DELETE、PATCH、PUT
        response.setHeader("Access-Control-Allow-Methods","GET");*/
        return picService.queryByType(type);
    }
    @PostMapping("/")
    public ResponseData query(@PathVariable String type) {
        return new ResponseData(ResponseCode.SUCCESS,"成功了");
    }
    /**
     * 适用restful风格设计接口，数据交互方式为json格式
     * @param
     * @return
     */
    @ApiOperation(value = "queryAll",notes = "查询图片")
    @GetMapping("/all")
    public ResponseData queryAll(Integer page,Integer limit) {
        ResponseData responseData = picService.queryAllByLimit(page, limit);
        return responseData;
    }
    @ApiOperation(value = "updateStatus",notes = "通过图片id修改图片的发布状态")
    @ApiImplicitParam(name = "id",value = "图片id")
    @PatchMapping("/")
    public ResponseData updateStatus(@RequestBody String  value) {
        JSONObject jsonObject=JSONObject.parseObject(value);
        Integer id = Integer.parseInt(jsonObject.getString("id"));
        Integer status = Integer.parseInt(jsonObject.getString("status"));
        ResponseData res=picService.updateStatus(id,status);
        return res;
    }
    @ApiOperation(value = "delete",notes = "通过图片id删除图片")
    @ApiImplicitParam(name = "id",value = "图片id")
    @DeleteMapping("/")
    public ResponseData delete(@RequestBody String  value) {
        JSONObject jsonObject = JSONArray.parseObject(value);
        JSONArray array = jsonObject.getJSONArray("data");
        return picService.delete(array);

    }
}
