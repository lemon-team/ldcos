package com.ilemontech.ldcos.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * 用户组的实体类
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/27 下午4:01
 * @since 1.0 Created by lipangeng on 2017/5/27 下午4:01. Email:lipg@outlook.com.
 */
public class GroupEntity extends IdEntity {
    /** 组名称 */
    private String name;
    /** 组状态 */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof GroupEntity)) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }
        GroupEntity that = (GroupEntity) o;
        return Objects.equal(name, that.name) && Objects.equal(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, status);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("status", status)
                .add("id", id)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .toString();
    }
}
