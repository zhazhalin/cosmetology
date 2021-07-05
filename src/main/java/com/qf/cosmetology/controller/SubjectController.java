package com.qf.cosmetology.controller;

import com.qf.cosmetology.entity.Subject;
import com.qf.cosmetology.result.ResponseCode;
import com.qf.cosmetology.result.ResponseData;
import com.qf.cosmetology.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Subject)表控制层
 *
 * @author makejava
 * @since 2021-06-25 16:17:52
 */
@RestController
@RequestMapping("subjects")
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectService subjectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "queryById",notes = "通过项目Id获取项目详细信息")
    @ApiParam(name = "queryById",value = "项目id")
    @GetMapping("/{id}")
    public ResponseData queryById(@PathVariable Integer id) {
        Subject subject = this.subjectService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS,subject);
    }
    /**
     * 查询所有并按照价格降序排列
     *
     * @return List
     */
    @ApiOperation(value = "queryAllDesc",notes = "查询所有的项目，并按照价格降序排列")
    @ApiParam(name = "queryById",value = "项目id")
    @GetMapping("/")
    public ResponseData queryAllDesc() {
        List<Subject> subjects= this.subjectService.queryAllDesc("price");
        return new ResponseData(ResponseCode.SUCCESS,subjects);
    }
    /**
     * 根据按钮标题去查找对应的项目列表
     *
     * @return List
     */
    @ApiOperation(value = "queryByTitle",notes = "根据按钮标题去查找对应的项目列表")
    @ApiParam(name = "title",value = "标题")
    @GetMapping("/type/{title}")
    public ResponseData queryByTitle(@PathVariable String title) {
        List<Subject> subjects= this.subjectService.queryByTitle(title);
        return new ResponseData(ResponseCode.SUCCESS,subjects);
    }
}
