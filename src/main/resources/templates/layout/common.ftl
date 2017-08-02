<#-- @ftlvariable name="note" type="java.lang.String" -->
<#-- @ftlvariable name="title" type="java.lang.String" -->
<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT.authentication.principal" type="com.ilemontech.ldcos.cloud.configure.security.SecurityUserDetails" -->
<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT" type="org.springframework.security.core.context.SecurityContext" -->
<#-- @ftlvariable name="page" type="com.github.pagehelper.Page" -->
<#-- 注入baseDir -->
<#assign baseDir=springMacroRequestContext.contextPath />
<#-- 用户信息，注意：未登录时用户信息为空 -->
<#assign userDetails=(Session.SPRING_SECURITY_CONTEXT.authentication.principal)! />
<#-- content header -->
<#macro content_header title note>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
    ${title!'Cloud Portal'}
        <small>${note!'Cloud Portal'}</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href=""><i class="fa fa-home"></i>Autozi Cloud Portal</a></li>
        <#nested />
    </ol>
</section>
</#macro>
<#-- 分页功能 pageNum:当前页数,pageSize:每页数量，通用型的分页 -->
<#macro box_footer_pagination pageNum=1 pageTotal=1 startRow=0 endRow=0 totalRow=0 buttonNum=7 href=(springMacroRequestContext.requestUri)!'' queryString=(springMacroRequestContext.queryString)!'' ulClass='pagination-sm no-margin pull-right' liClass='paginate_button' aClass='' spanClass=''>
<#-- 拼接href链接，并处理掉Url中的pageNum参数 -->
    <#local _queryString="${queryString?replace('[&]?pageNum=\\\\d+','','ir')}" />
<#-- 判断查询参数是否为空，防止?&形式的url出现，保证url格式的标准性 -->
    <#if _queryString?length gt 0 >
        <#local targetHref="${href}?${_queryString}&" />
    <#else >
        <#local targetHref="${href}?${_queryString}" />
    </#if>
<#-- 计算需要展示的分页链接页数,保证输出分页按钮个数 -->
    <#if pageNum gt buttonNum/2?int >
        <#local _startPage=pageNum-(buttonNum/2)?int />
    <#else >
        <#local _startPage=1 />
    </#if>
    <#local _endPage=_startPage+buttonNum-1 />
<#-- 数据总量大于0的时候才显示当前数据条数 -->
    <#if totalRow gt 0>
    <span class="${spanClass!''}"> ${startRow!0}-${endRow!0} Of ${totalRow!0} </span>
    </#if>
<ul class="pagination ${ulClass}">
    <li class="paginate_button previous <#if pageNum lte 1>disabled</#if>">
        <a href="${targetHref}pageNum=${(pageNum-1 gt 0)?string((pageNum-1)?string,'1')}">上一页</a>
    </li>
    <#list _startPage.._endPage as page>
        <#if page gt 0 && page lte pageTotal >
            <li class="paginate_button <#if page==pageNum>active</#if>">
                <a href="${targetHref}pageNum=${page}">${page}</a>
            </li>
        </#if>
    <#else >
        <li class="paginate_button active">
            <a href="${targetHref}pageNum=1">1</a>
        </li>
    </#list>
    <li class="paginate_button next <#if pageNum gte pageTotal>disabled</#if>">
        <a href="${targetHref}&pageNum=${(pageNum+1 lte pageTotal)?string((pageNum+1)?string,pageTotal?string)}">下一页</a>
    </li>
</ul>
</#macro>

<#-- 分页功能 pageNum:当前页数,pageSize:每页数量,基于pageHelper的PageInfo -->
<#macro box_footer_pagination_page page={} href=(springMacroRequestContext.requestUri)!'' queryString=(springMacroRequestContext.queryString)!'' ulClass='pagination-sm no-margin pull-right' liClass='paginate_button' aClass='' spanClass=''>
<#-- 拼接href链接，并处理掉Url中的pageNum参数 -->
    <#local _queryString="${queryString?replace('[&]?pageNum=\\\\d+','','ir')}" />
<#-- 判断查询参数是否为空，防止?&形式的url出现，保证url格式的标准性 -->
    <#if _queryString?length gt 0 >
        <#local targetHref="${href}?${_queryString}&" />
    <#else >
        <#local targetHref="${href}?${_queryString}" />
    </#if>
<#-- 数据总量大于0的时候才显示当前数据条数 -->
    <#if ((page.total)!0) gt 0>
    <span class="${spanClass!''}"> ${(page.startRow)!0}-${(page.endRow)!0} Of ${page.total!0} </span>
    </#if>
<ul class="pagination ${ulClass}">
    <li class="paginate_button previous <#if (page.isFirstPage)!true >disabled</#if>">
        <a href="${targetHref}pageNum=${(page.prePage)!1}">上一页</a>
    </li>
    <#list (page.navigatepageNums)![] as pn>
        <li class="paginate_button <#if pn == page.pageNum >active</#if>">
            <a href="${targetHref}pageNum=${pn}">${pn}</a>
        </li>
    <#else >
        <li class="paginate_button active">
            <a href="${targetHref}pageNum=1">1</a>
        </li>
    </#list>
    <li class="paginate_button next <#if (page.isLastPage)!true >disabled</#if>">
        <a href="${targetHref}&pageNum=${(page.nextPage)!1}">下一页</a>
    </li>
</ul>
</#macro>