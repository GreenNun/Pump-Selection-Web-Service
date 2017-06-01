<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pump Service</title>
    <link rel="icon" href="../img/icon.png">

    <%!
        static final String VERSION = "v1";

        static final String[] JS = {
                // jQuery first, then Tether, then Bootstrap JS.
                "../js/libs/jquery.js",
                "../js/libs/tether-1.3.3/tether.js",
                "../js/libs/bootstrap-4.0.0-alpha.6/bootstrap.js",

                "../js/libs/angular.js",
                "../js/libs/angular-sanitize.js",
                "../js/libs/angular-route.js",

                "../js/libs/angular-ui/angular-ui-router.js",

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
                "../css/tether-1.3.3/tether.css",
                "../css/tether-1.3.3/tether-theme-arrows.css",
                "../css/tether-1.3.3/tether-theme-arrows-dark.css",
                "../css/tether-1.3.3/tether-theme-basic.css",
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
<div ng-app="pump.modules.route" ng-cloak>
    <div ng-if="state.viewReload" class="progress-striped active progress"
         style="z-index: 8900; margin-top: 20%; width: 60%; margin-left: 20%;">
        <div class="progress-bar progress-bar-info" role="progressbar" style="width: 100%;"></div>
    </div>
    <div ng-if="state.notification"
         type="{{state.notification.type}}"
         close="cleanUpNotification()"
         class="alert alert-{{state.notification.type}} mb-0">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        {{state.notification.message}}
    </div>
    <div ng-if="!state.viewReload && !state.notification.hideView" ui-view></div>
</div>
</body>
</html>

