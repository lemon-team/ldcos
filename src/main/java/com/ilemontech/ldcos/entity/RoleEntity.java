package com.ilemontech.ldcos.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * 权限菜单
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/27 上午11:27
 * @since 1.0 Created by lipangeng on 2017/5/27 上午11:27. Email:lipg@outlook.com.
 */
public class RoleEntity extends IdEntity {
    /** 权限名称 */
    private String name;
    /** 权限类型 */
    private Integer type;
    /** 权限code，唯一标示 */
    private String code;
    /** 状态 */
    private Integer status;
    /** 备注 */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof RoleEntity)) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return Objects.equal(name, that.name) && Objects.equal(type, that.type) && Objects.equal(code, that.code) &&
               Objects.equal(status, that.status) && Objects.equal(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, type, code, status, remark);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("type", type)
                .add("id", id)
                .add("code", code)
                .add("createTime", createTime)
                .add("status", status)
                .add("updateTime", updateTime)
                .add("remark", remark)
                .toString();
    }
}
