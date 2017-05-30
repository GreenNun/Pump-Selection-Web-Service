<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pump Service</title>
    <link rel="icon" href="../img/icon.png">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>

    <%!
        static final String VERSION = "v1";

        static final String[] JS = {
                "../js/libs/jquery.js",
                "../js/libs/bootstrap-4.0.0-alpha.6/bootstrap.js",

                "../js/libs/angular.js",
                "../js/libs/angular-sanitize.js",
                "../js/libs/angular-route.js",
                "../js/libs/es5-shim.min.js",

                "../js/app.js",
                "../js/modules/search/search-module.js",
                "../js/modules/manage/manage-module.js",
                "../js/modules/manage/constant-module.js"
        };

        static final String[] CSS = {
                "../css/bootstrap-4.0.0-alpha.6/bootstrap.css",
                "../css/bootstrap-4.0.0-alpha.6/bootstrap-grid.css",
                "../css/bootstrap-4.0.0-alpha.6/bootstrap-reboot.css",
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
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse navbar-static-top mb-3">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Eqeeper</a>

    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="../view/#/search">Search</a>
                    <a class="dropdown-item" href="../view/#/manage">Manage</a>
                    <a class="dropdown-item" href="../view/#/constant">Constant</a>
                </div>
            </li>
        </ul>
        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="E-mail">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="Password">--%>
            <%--<button class="btn btn-outline-primary my-2 my-sm-2" type="submit"><i class="fa fa-sign-in"></i> Log In</button>--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign Up</button>--%>
        <%--</form>--%>
        <form class="form-inline">
            <div class="col-xs-6 my-1 mr-1">
                <input class="form-control" type="email" placeholder="E-mail">
                <input class="form-control" type="password" placeholder="Password">
            </div>
            <div class="col-xs-6 my-1 mr-0">
                <button class="btn btn-outline-primary" type="submit"><i class="fa fa-sign-in"></i> Log In</button>
                <button class="btn btn-outline-success" type="submit">Sign Up</button>
                <%--<button class="btn btn-primary" type="submit"><i class="fa fa-sign-in"></i> Log In</button>--%>
                <%--<button class="btn btn-success" type="submit">Sign Up</button>--%>
            </div>
        </form>
    </div>
</nav>
<%--<div class="container col-xs-12 col-sm-12 col-md-12 col-lg-12">--%>
<%--<div class="navbar navbar-default navbar-static-top">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">--%>
                <%--<span class="sr-only">Toggle Navigation</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<a class="navbar-brand" href="#">Eqeeper</a>--%>
        <%--</div>--%>
        <%--<div class="navbar-collapse collapse" id="navbar-main">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li><a href="../view/#/search">Search</a></li>--%>
                <%--<li class="active"><a href="../view/#/manage">Manage</a></li>--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b--%>
                            <%--class="caret"></b></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">Another action</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">Something else here</a>--%>
                        <%--</li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a>--%>
                        <%--</li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">One more separated link</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<form action="" class="navbar-form navbar-right hidden-sm">--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="E-mail" value="">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="password" class="form-control" placeholder="Password" value="">--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-primary">--%>
                    <%--<i class="fa fa-sign-in"></i> Log In--%>
                <%--</button>--%>
                <%--<button type="submit" class="btn btn-success">--%>
                    <%--Sign Up--%>
                <%--</button>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<div class="container-fluid" ng-app="pump.modules.route" ng-cloak>
    <div class="row">
        <div ng-if="state.viewReload" class="progress-striped active progress" style="z-index: 8900; margin-top: 20%;
    width: 60%; margin-left: 20%;">
            <div class="progress-bar progress-bar-info" role="progressbar" style="width: 100%;"></div>
        </div>

        <div ng-if="state.notification"
               <%--type="{{state.notification.type}}"--%>
               <%--close="cleanUpNotification()"--%>
               class="alert alert-{{state.notification.type}}">
            <%--<button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
                <%--<span aria-hidden="true">&times;</span>--%>
            <%--</button>--%>
            {{state.notification.message}}
        </div>

        <div ng-if="!state.viewReload && !state.notification.hideView"
             ng-view class="container-fluid col-xs-12 col-sm-12 col-md-12"></div>
    </div>
</div>
<script>
    $(".navbar-nav a").on("click", function () {
        $(".navbar-nav").find(".active").removeClass("active");
        $(this).parent().addClass("active");
    });
</script>
</body>
</html>

