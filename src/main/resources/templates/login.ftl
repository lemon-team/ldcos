<#-- @ftlvariable name="errorMsg" type="java.lang.String" -->
<#-- 引入页面工具 -->
<#include '/layout/common.ftl' />
<!doctype html >
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
<#assign title='登陆页面' />
<#include '/layout/head.ftl' />
<#include '/layout/plugins/ickeck.css.ftl' />
    <link rel="stylesheet" href="css/app/login.css" />
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="${baseDir}"><b>Lemon</b> Data Center OS</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
    <#if errorMsg??>
        <p style="text-align: center;color: red">${errorMsg!'发生未知错误，请重试~！'}</p>
    <#else>
        <p class="login-box-msg">登陆系统</p>
    </#if>
        <form method="post">
            <!-- csrf -->
            <input name="${_csrf.parameterName}" value="${_csrf.token}" hidden />
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control" placeholder="UserName" required>
                <span class="glyphicon glyphicon-user form-control-feedback"></span></input>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span></input>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="remember-me" /> 记住我
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- OR -</p>
        </div>
        <!-- /.social-auth-links -->

    <#--<a href="#">I forgot my password</a><br>-->
    <#--<a href="register.html" class="text-center">Register a new membership</a>-->

    </div>
    <!-- /.login-box-body -->
</div>
<!-- jQuery 2.2.3 -->
<script src="js/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="js/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="js/app.min.js"></script>
<#include '/layout/plugins/jquery-validate.js.ftl' />
<#include '/layout/plugins/ickeck.js.ftl' />
<script type="text/javascript">
    // 页面完成后加载
    $(function () {
        // 启用表单验证
        $('form').validate();
    });
</script>
</body>
</html>