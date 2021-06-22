package com.qf.cosmetology.entity;

import java.io.Serializable;

/**
 * (Addr)实体类
 *
 * @author makejava
 * @since 2021-06-22 12:38:17
 */
public class Addr implements Serializable {
    private static final long serialVersionUID = 269737522123223089L;

    private Integer aId;
    /**
     * 地址
     */
    private String title;
    /**
     * 电话
     */
    private String tel;
    /**
     * 用户别名
     */
    private String uname;
    /**
     * 商铺id
     */
    private Integer sId;


    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}
