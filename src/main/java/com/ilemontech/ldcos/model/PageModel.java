package com.ilemontech.ldcos.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;

/**
 * 分页绑定对象
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/6/1 下午5:04
 * @since 1.0 Created by lipangeng on 2017/6/1 下午5:04. Email:lipg@outlook.com.
 */
public class PageModel implements Serializable {
    /** 页数 */
    private Integer pageNum = 1;
    /** 每页数据量 */
    private Integer pageSize = 20;
    /** 导航条展示页数 */
    private Integer navigatePages = 7;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(Integer navigatePages) {
        this.navigatePages = navigatePages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof PageModel)) {
            return false;
        }
        PageModel pageModel = (PageModel) o;
        return Objects.equal(pageNum, pageModel.pageNum) && Objects.equal(pageSize, pageModel.pageSize) &&
               Objects.equal(navigatePages, pageModel.navigatePages);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pageNum, pageSize, navigatePages);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageNum", pageNum)
                .add("pageSize", pageSize)
                .add("navigatePages", navigatePages)
                .toString();
    }

    /**
     * 转换为RowBounds分页对象
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午5:33. Email:lipg@outlook.com.
     */
    public RowBounds toRowBounds() {
        return new RowBounds(getPageNum(), getPageSize());
    }
}
