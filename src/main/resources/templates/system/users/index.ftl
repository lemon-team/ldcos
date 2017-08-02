<#-- @ftlvariable name="users" type="com.github.pagehelper.Page<com.ilemontech.ldcos.cloud.entity.UserEntity>" -->
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
        <li class="active"><i class="fa fa-users"></i>Users</li>
    </@content_header>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3>${usersCount!0}</h3>

                            <p>已注册用户</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add" onclick="location.href='system/users/user/add';"></i>
                        </div>
                        <a href="system/users/list" class="small-box-footer">更多信息<i class="fa fa-arrow-circle-right"></i></a>
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