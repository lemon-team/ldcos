<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT.authentication.principal" type="com.ilemontech.ldcos.cloud.configure.security.SecurityUserDetails" -->
<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT" type="org.springframework.security.core.context.SecurityContext" -->
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <!-- 头像地址 -->
                <img src="${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.headUrl)!'img/avatar.png'}"
                     class="img-circle"
                     alt="User Image">
            </div>
            <div class="pull-left info">
                <!-- 用户名 -->
                <p>${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.realName)!'未知'}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header"><i class="fa fa-cube"></i> <span>应用管理</span></li>
            <li><a href=""><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
            <li class="header"><i class="fa fa-cogs"></i> <span>系统管理</span></li>
            <li><a href="system"><i class="fa fa-cog"></i> <span>系统设置</span></a></li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>