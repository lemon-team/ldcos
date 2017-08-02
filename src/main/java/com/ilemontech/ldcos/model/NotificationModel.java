package com.ilemontech.ldcos.model;

import com.ilemontech.ldcos.constant.model.NotificationConstant.CODE;
import com.ilemontech.ldcos.constant.model.NotificationConstant.STATUS;
import com.ilemontech.ldcos.constant.model.NotificationConstant.TYPE;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * 通知模型
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/31 下午10:58
 * @since 1.0 Created by lipangeng on 2017/5/31 下午10:58. Email:lipg@outlook.com.
 */
public class NotificationModel implements Serializable {
    /** 标题 */
    private String title;
    /** 内容 */
    private String content;
    /** 类型 */
    private String type = TYPE.alert.name();
    /** 通知状态 */
    private String status = STATUS.success.name();
    /** 错误代码 */
    private Integer code = CODE.OK.getValue();


    public NotificationModel() {
    }

    /**
     * 默认发送操作成功通知
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 下午11:17. Email:lipg@outlook.com.
     */
    public NotificationModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NotificationModel(String title, String content, String type, String status, Integer code) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.status = status;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public NotificationModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NotificationModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getType() {
        return type;
    }

    public NotificationModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public NotificationModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public NotificationModel setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof NotificationModel)) {
            return false;
        }
        NotificationModel that = (NotificationModel) o;
        return Objects.equal(title, that.title) && Objects.equal(content, that.content) && Objects.equal(type, that.type) &&
               Objects.equal(status, that.status) && Objects.equal(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, content, type, status, code);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("content", content)
                .add("type", type)
                .add("status", status)
                .add("code", code)
                .toString();
    }

    /**
     * 成功提示
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午2:43. Email:lipg@outlook.com.
     */
    public static NotificationModel successAlert(String title, String content) {
        return new NotificationModel(title, content, TYPE.alert.name(), STATUS.success.name(), CODE.OK.getValue());
    }

    /**
     * 错误提示信息
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午2:43. Email:lipg@outlook.com.
     */
    public static NotificationModel errorAlert(String title, String content, int code) {
        return new NotificationModel(title, content, TYPE.alert.name(), STATUS.error.name(), code);
    }

    /**
     * 成功提示
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午2:43. Email:lipg@outlook.com.
     */
    public static NotificationModel successToastr(String title, String content) {
        return new NotificationModel(title, content, TYPE.toastr.name(), STATUS.success.name(), CODE.OK.getValue());
    }

}
