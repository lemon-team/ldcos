package com.ilemontech.ldcos.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Date;

/**
 * Id 主类
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/6 上午8:56
 * @since 1.0 Created by lipangeng on 2017/5/6 上午8:56. Email:lipg@outlook.com.
 */
public class IdEntity implements Serializable {
    /** 主键id */
    protected Long id;
    /** 创建时间 */
    protected Date createTime=new Date();
    /** 更新时间 */
    protected Date updateTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof IdEntity)) {
            return false;
        }
        IdEntity idEntity = (IdEntity) o;
        return Objects.equal(id, idEntity.id) && Objects.equal(createTime, idEntity.createTime) &&
               Objects.equal(updateTime, idEntity.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, createTime, updateTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("createTime", createTime).add("updateTime", updateTime).toString();
    }
}
