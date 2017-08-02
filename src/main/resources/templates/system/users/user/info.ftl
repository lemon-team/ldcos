<#-- @ftlvariable name="user" type="com.ilemontech.ldcos.cloud.entity.UserEntity" -->
<#-- 引入页面工具 -->
<#include '/layout/common.ftl' />
<!doctype html>
<html lang="en">
<head>
<#assign title='系统管理->用户中心->用户信息' />
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
    <@content_header title='用户信息' note='信息详情' >
        <li><a href="system"><i class="fa fa-cog"></i>系统配置</a></li>
        <li><a href="system/users"><i class="fa fa-users"></i>Users</a></li>
        <li class="active"><i class="fa fa-user"></i>用户信息</li>
    </@content_header>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-3">
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <!-- 用户基本信息 -->
                            <img class="profile-user-img img-responsive img-circle" src="img/avatar.png" alt="用户头像">
                            <h3 class="profile-username text-center">${(user.realName)!'用户姓名'}</h3>
                            <p class="text-muted text-center">${(user.username)!'用户名'}</p>
                            <p class="text-muted text-center">${(user.remark)!'用户备注'}</p>
                            <!-- 用户其他信息 -->
                            <div class="row">
                                <div class="col-md-6">
                                    <a href="system/users/user/${(user.id)!'0'}/edit" class="btn btn-primary btn-block"><b>编辑信息</b></a>
                                </div>
                                <div class="col-md-6">
                                    <form action="system/users/user/${(user.id)!'0'}/delete" method="post">
                                        <input name="${_csrf.parameterName}" value="${_csrf.token}" hidden />
                                        <button type="button"
                                                data-title="删除用户"
                                                data-content="确认删除用户${(user.realName)!'用户名'}？"
                                                class="btn btn-warning btn-block cloud_form_submit_confirm">删除用户
                                        </button>
                                    </form>
                                </div>
                            </div>
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
<#include '/layout/plugins/jquery-validate.js.ftl' />
<script type="text/javascript">
    // 页面完成后加载
    $(function () {
        // 启用表单验证
        $('form#user_add').validate();
    });
</script>
</body>
</html>