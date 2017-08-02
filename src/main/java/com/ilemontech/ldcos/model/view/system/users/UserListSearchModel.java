package com.ilemontech.ldcos.model.view.system.users;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * 用户列表用的查询对象
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/6/1 下午5:09
 * @since 1.0 Created by lipangeng on 2017/6/1 下午5:09. Email:lipg@outlook.com.
 */
public class UserListSearchModel implements Serializable {
    /** 用户名 */
    private String username;
    /** 真实姓名 */
    private String realName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof UserListSearchModel)) {
            return false;
        }
        UserListSearchModel that = (UserListSearchModel) o;
        return Objects.equal(username, that.username) && Objects.equal(realName, that.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, realName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("username", username).add("realName", realName).toString();
    }
}
