<%@ tag import="org.springframework.security.core.context.SecurityContextHolder" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${pageContext.request.contextPath}/">My Very Sign</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                </ul>
                <ul class="nav pull-right">
                    <% if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) { %>
                    <li class="divider-vertical">
                        <a href="${pageContext.request.contextPath}/add-cert.htm" class="dropdown-toggle"
                           data-toggle="dropdown">Generer un certificat<b class="caret"></b></a>
                    </li>
                    <% } %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profil<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/profil.htm"><i class="icon-wrench"></i>&nbsp;Configuration</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><i
                                    class="icon-off"></i>&nbsp; Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container-fluid">