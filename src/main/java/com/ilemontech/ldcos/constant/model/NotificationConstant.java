package com.ilemontech.ldcos.constant.model;

/**
 * 通知类的常量
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/31 下午11:02
 * @since 1.0 Created by lipangeng on 2017/5/31 下午11:02. Email:lipg@outlook.com.
 */
public class NotificationConstant {
    /** 通知在session中存储的参数名 */
    public static final String CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE = "CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE";

    /** 通知类型 */
    public enum TYPE {
        alert,  // 弹出通知框
        toastr // 展示通知
    }

    /** 通知状态 */
    public enum STATUS {
        success, // 成功通知
        error, // 错误通知
        waring // 警告类型的通知
    }

    /** 状态码 */
    public enum CODE {
        OK(200), BAD_REQUEST(400),SERVER_ERROR(500);//成功

        private int value;

        CODE(int code) {
            this.value = code;
        }

        public int getValue() {
            return value;
        }
    }
}
