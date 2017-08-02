<#-- @ftlvariable name="users" type="com.github.pagehelper.PageInfo<com.ilemontech.ldcos.cloud.entity.UserEntity>" -->
<#-- 引入页面工具 -->
<#include '/layout/common.ftl' />
<!doctype html>
<html lang="en">
<head>
<#assign title='系统管理->用户中心' />
<#include '/layout/head.ftl' />
</head>
<body class="hold-transition skin-blue sidebar-mini sidebar-collapse">
<div class="wrapper">
<#-- 页面头部标签 -->
<#include '/layout/header.ftl' />
<#-- 页面左侧导航 -->
<#include '/layout/sidebar.ftl' />
<#-- 页面右侧配置 -->
<#include '/layout/control-sidebar.ftl' />
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
    <@content_header title='Users' note='用户中心' >
        <li><a href="system"><i class="fa fa-cog"></i>系统配置</a></li>
        <li><a href="system/users"><i class="fa fa-users"></i>Users</a></li>
        <li class="active"><i class="fa fa-list-alt"></i> List</li>
    </@content_header>
        <!-- Main content -->
        <section class="content">
            <div class="row">
            <#-- 左侧筛选 -->
                <div class="col-md-3">
                <#-- 添加用户按钮 -->
                    <a href="system/users/user/add" class="btn btn-primary btn-block margin-bottom">添加用户</a>
                <#-- 通过状态筛选用户 -->
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">账户状态</h3>
                            <div class="box-tools">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding" style="display: block;">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#"><i class="fa fa-circle-o text-blue"></i>全部</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-green"></i>已启用</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-red"></i>已锁定</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-black"></i>已禁用</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i>密码过期</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i>账户过期</a></li>
                            </ul>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
            <#-- 右侧展示区域 -->
                <div class="col-md-9">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">用户列表</h3>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <form action="" method="get">
                                        <input type="text"
                                               name="search_username"
                                               id="search_username"
                                               class="form-control input-sm"
                                               placeholder="查找用户">
                                        <span class="glyphicon glyphicon-search form-control-feedback cloud_form_submit"></span>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <ul class="users-list clearfix">
                            <#list (users.list)![] as user>
                                <li class="col-xs-4 col-sm-2">
                                    <a href="system/users/user/${user.id}">
                                        <img src="${user.headUrl!'img/avatar.png'}" alt="User Image">
                                        <span class="users-list-name">${user.realName!'真实姓名'}</span>
                                        <span class="users-list-date">${user.username!'用户名'}</span>
                                    </a>
                                </li>
                            <#else >
                                <div class="text-center">
                                    <i class="fa fa-warning"></i>暂无数据，请修改查询条件或重新查询。
                                </div>
                            </#list>
                            </ul>
                        </div>
                        <div class="box-footer">
                        <@box_footer_pagination_page page=users!{} />
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
<#include '/layout/footer.ftl' />
</div>
<#include '/layout/foot.ftl' />
</body>
</html>