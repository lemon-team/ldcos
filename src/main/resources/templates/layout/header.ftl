<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT.authentication.principal" type="com.ilemontech.ldcos.cloud.configure.security.SecurityUserDetails" -->
<#-- @ftlvariable name="Session.SPRING_SECURITY_CONTEXT" type="org.springframework.security.core.context.SecurityContext" -->
<!-- Main Header -->
<header class="main-header" xmlns="http://www.w3.org/1999/html">

    <!-- Logo -->
    <a href="" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>CP</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Cloud</b>Portal</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">切换导航</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.headUrl)!'img/avatar.png'}"
                             class="user-image"
                             alt="User Image">
                        <span class="hidden-xs">${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.realName)!'Guest'}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.headUrl)!'img/avatar.png'}"
                                 class="img-circle"
                                 alt="User Image">
                            <p>
                            ${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.realName)!'Guest'}
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                            <#--<div class="col-xs-4 text-center">-->
                                    <#--<a href="#">Followers</a>-->
                                <#--</div>-->
                                <#--<div class="col-xs-4 text-center">-->
                                    <#--<a href="#">Sales</a>-->
                                <#--</div>-->
                                <#--<div class="col-xs-4 text-center">-->
                                    <#--<a href="#">Friends</a>-->
                                <#--</div>-->
                            </div>
                            <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">个人设置</a>
                            </div>
                            <div class="pull-right">
                                <form action="logout" method="post">
                                    <input type="text" name="${_csrf.parameterName}" value="${_csrf.token}" hidden />
                                    <input type="submit" class="btn btn-default btn-flat" value="退出">
                                </form>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>