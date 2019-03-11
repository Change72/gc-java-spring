package com.gc.framework.model;

import com.gc.base.Pager;
import java.io.Serializable;
import java.util.Date;

public class Userinfo extends Pager implements Serializable {
    /** 标识 */
    private Integer id;

    /** 用户id */
    private Integer uid;

    /** 用户名 */
    private String username;

    /** 用户性别 */
    private Boolean sex;

    /** 用户城市 */
    private String city;

    /** 创建时间 */
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", username=").append(username);
        sb.append(", sex=").append(sex);
        sb.append(", city=").append(city);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}