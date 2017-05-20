<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pump Service</title>
    <link rel="icon" href="../img/icon.png">

    <%!
        static final String VERSION = "v1";

        static final String[] JS = {
                "../js/libs/jquery.js",
                "../js/libs/bootstrap.min.js",

                "../js/libs/angular.js",
                "../js/libs/angular-sanitize.js",
                "../js/libs/angular-route.js",
                "../js/libs/angular-bootstrap.js",
                "../js/libs/es5-shim.min.js",

                "../js/app.js",
                "../js/modules/search/search-module.js",
                "../js/modules/manage/manage-module.js",
                "../js/modules/manage/constant-module.js"
        };

        static final String[] CSS = {
                "../css/bootstrap.min.css",
                "../css/bootstrap-theme.min.css",
                "../css/bootstrap-ng.min.css",
                "../css/font-awesome.css",
                "../css/style.css"
        };
    %>

    <%
        for (String css : CSS) {
    %>
    <link rel="stylesheet" href="<%=css%>?<%=VERSION%>">
    <% } %>

    <%
        for (String js : JS) {
    %>
    <script src="<%=js%>?<%=VERSION%>"></script>
    <% } %>
</head>

<body>
<%--<div class="container col-xs-12 col-sm-12 col-md-12 col-lg-12">--%>
<div class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="sr-only">Toggle Navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Eqeeper</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li><a href="../view/#/search">Search</a></li>
                <li class="active"><a href="../view/#/manage">Manage</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a>
                        </li>
                        <li><a href="#">Another action</a>
                        </li>
                        <li><a href="#">Something else here</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <form action="" class="navbar-form navbar-right hidden-sm">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="E-mail" value="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" value="">
                </div>
                <button type="submit" class="btn btn-primary">
                    <i class="fa fa-sign-in"></i> Log In
                </button>
                <button type="submit" class="btn btn-success">
                    Sign Up
                </button>
            </form>
        </div>
    </div>
</div>

<div class="container-fluid" ng-app="pump.modules.route" ng-cloak>
    <div class="row">
        <div ng-if="state.viewReload" class="progress-striped active progress" style="z-index: 8900; margin-top: 20%;
    width: 60%; margin-left: 20%;">
            <div class="progress-bar progress-bar-info" role="progressbar" style="width: 100%;"></div>
        </div>

        <alert ng-if="state.notification"
               type="{{state.notification.type}}"
               close="cleanUpNotification()"
               class="crimtan-alert">{{state.notification.message}}
        </alert>

        <div ng-if="!state.viewReload && !state.notification.hideView"
             ng-view class="container-fluid col-xs-12 col-sm-12 col-md-12"></div>
    </div>
</div>
<script>
    $(".nav a").on("click", function () {
        $(".nav").find(".active").removeClass("active");
        $(this).parent().addClass("active");
    });
</script>
</body>
</html>

