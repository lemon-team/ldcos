<#-- 引入页面工具 -->
<#include '/layout/common.ftl' />
<!doctype html >
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
<#assign title='主页' />
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
    <@content_header title='Dashboard' note='控制面板' >
        <li class="active">Dashboard</li>
    </@content_header>

        <!-- Main content -->
        <section class="content">


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
<#include '/layout/footer.ftl' />
</div>
<#include '/layout/foot.ftl' />
</body>
</html>