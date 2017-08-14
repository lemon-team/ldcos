package com.ilemontech.ldcos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理Request的相关工具
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/31 上午9:47
 * @since 1.0 Created by lipangeng on 2017/5/31 上午9:47. Email:lipg@outlook.com.
 */
public class ServletUtils {
    private static final Logger logger = LoggerFactory.getLogger(ServletUtils.class);

    /**
     * 工具类，均为静态方法，防止初始化
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 上午9:47. Email:lipg@outlook.com.
     */
    private ServletUtils() {
    }


    /**
     * 获取用来做重定向的自身url
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午2:30. Email:lipg@outlook.com.
     */
    public static String RedirectSelfUri(HttpServletRequest request) {
        return request.getRequestURI().substring(1);
    }

    /**
     * 获取请求中的{@link HttpServletRequest HttpServletRequest}
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 上午9:48. Email:lipg@outlook.com.
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = getServletRequestAttributes();
        if (requestAttributes != null) {
            requestAttributes.getRequest();
        }
        return null;
    }

    /**
     * 获取请求中的{@link HttpServletResponse HttpServletResponse}
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 上午9:48. Email:lipg@outlook.com.
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = getServletRequestAttributes();
        if (requestAttributes != null) {
            requestAttributes.getResponse();
        }
        return null;
    }


    /**
     * 获取{@link ServletRequestAttributes ServletRequestAttributes}
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 上午10:01. Email:lipg@outlook.com.
     */
    public static ServletRequestAttributes getServletRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        try {
            return ((ServletRequestAttributes) requestAttributes);
        } catch (Exception e) {
            logger.error("获取ServletRequestAttributes失败", e);
        }
        return null;
    }
}
