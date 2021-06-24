package com.qf.cosmetology.entity;

import java.io.Serializable;

/**
 * (Pic)实体类
 *
 * @author makejava
 * @since 2021-06-22 15:03:00
 */
public class Pic implements Serializable {
    private static final long serialVersionUID = -12128014894880600L;

    private Integer pId;
    /**
     * 图片标题
     */
    private String title;
    /**
     * 图片路径
     */
    private String url;
    /**
     * 图片类型，例如轮播图
     */
    private String type;
    /**
     * 图片状态1,0
     */
    private Integer status;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
