package com.ilemontech.ldcos.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;

/**
 * bean操作工具
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/6/1 上午9:56
 * @since 1.0 Created by lipangeng on 2017/6/1 上午9:56. Email:lipg@outlook.com.
 */
public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    private BeanUtils() {
    }


    /**
     * 获取绑定数据错误，并转换为string类型说明
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 上午10:17. Email:lipg@outlook.com.
     */
    public static String getBindingsErrorsDetailStr(BindingResult bindings) {
        List<String> errors = Lists.newArrayList();
        if (bindings.hasErrors()) {
            for (FieldError fieldError : bindings.getFieldErrors()) {
                errors.add(fieldError.getDefaultMessage());
            }
        }
        return Arrays.toString(errors.toArray());
    }

    /**
     * 获取绑定数据错误，并转换为string类型说明
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 上午10:17. Email:lipg@outlook.com.
     */
    public static String getBindingsErrorsStr(BindingResult bindings) {
        List<String> errors = Lists.newArrayList();
        if (bindings.hasErrors()) {
            for (FieldError fieldError : bindings.getFieldErrors()) {
                errors.add(fieldError.getDefaultMessage());
            }
        }
        return Arrays.toString(errors.toArray());
    }

    /**
     * 拷贝对象属性
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 上午9:59. Email:lipg@outlook.com.
     */
    public static <T> T copyProperties(Object source, T target) throws RuntimeException {
        try {
            Preconditions.checkNotNull(source, "源对象不能为空");
            Preconditions.checkNotNull(target, "目标对象不能为空");
            org.springframework.beans.BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            logger.error("拷贝对象属性发生错误", e);
            throw e;
        }
    }
}
