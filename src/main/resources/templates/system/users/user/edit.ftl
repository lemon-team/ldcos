<#-- @ftlvariable name="user" type="com.ilemontech.ldcos.cloud.model.form.system.users.EditUserForm" -->
<#-- 引入页面工具 -->
<#include '/layout/common.ftl' />
<!doctype html>
<html lang="en">
<head>
<#assign title='系统管理->用户中心->添加用户' />
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
        <li class="active"><i class="fa fa-user"></i>EditUser</li>
    </@content_header>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <form id="user_edit" method="post">
                            <input name="${_csrf.parameterName}" value="${_csrf.token}" hidden />
                            <input name="id" value="${(user.id)!0}" hidden />
                            <div class="box-header with-border">
                                <h3 class="box-title">编辑用户(${(user.username)!'NONE'})</h3>
                            </div>
                            <div class="box-body">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="password">密 码(*):</label>
                                        <input type="password"
                                               class="form-control"
                                               id="password"
                                               name="password"
                                               placeholder="密码(不填写为保留原密码)">
                                    </div>
                                    <div class="form-group">
                                        <label for="repassword">确认密码(*):</label>
                                        <input type="password"
                                               class="form-control"
                                               id="repassword"
                                               name="repassword"
                                               placeholder="确认密码">
                                    </div>
                                    <div class="form-group">
                                        <label for="remark">备 注:</label>
                                        <input type="text"
                                               class="form-control"
                                               id="remark"
                                               name="remark"
                                               placeholder="账户备注"
                                               value="${(user.remark)!''}">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="realName">真实姓名(*):</label>
                                        <input type="text"
                                               class="form-control "
                                               id="realName"
                                               name="realName"
                                               placeholder="真实姓名"
                                               required
                                               maxlength="32"
                                               minlength="2"
                                               value="${(user.realName)!''}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">邮箱地址(*):</label>
                                        <input type="email"
                                               class="form-control "
                                               id="email"
                                               name="email"
                                               placeholder="邮箱地址"
                                               required
                                               maxlength="32"
                                               minlength="4"
                                               value="${(user.email)!''}">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">联系电话(*):</label>
                                        <input type="text"
                                               class="form-control "
                                               id="phone"
                                               name="phone"
                                               placeholder="手机号码"
                                               required
                                               maxlength="32"
                                               minlength="4"
                                               value="${(user.phone)!''}">
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="reset" class="btn btn-default">重置</button>
                                <button type="submit" class="btn btn-info pull-right">更新</button>
                            </div>
                        </form>
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
        $('form#user_edit').validate();
    });
</script>
</body>
</html>