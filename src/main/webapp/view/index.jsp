<html>
<head>
    <meta charset="utf-8">

    <%!
        static final String VERSION = "v1";

        static final String[] JS = {
                "../js/libs/jquery.js",
                "../js/libs/bootstrap.min.js",

                "../js/libs/angular.js",
                "../js/libs/angular-sanitize.js",
                "../js/libs/angular-route.js",
                "../js/libs/angular-bootstrap.js",
                "../js/libs/ui-utils.min.js",
                "../js/libs/select2.js",
                "../js/libs/select/select2.js",
                "../js/libs/checklist-model.js",
                "../js/libs/angular-file-upload.min.js",
                "../js/libs/es5-shim.min.js",

                "../js/app.js",
                "../js/modules/search/search-module.js"
        };

        static final String[] CSS = {
                "../css/bootstrap.min.css",
                "../css/bootstrap-theme.min.css",
                "../css/bootstrap-ng.min.css",
                "../css/select2.css",
                "../css/local.css",
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

<body ng-app="pump.modules.route" ng-cloak>

    <div ng-if="state.viewReload" class="progress-striped active progress" style="z-index: 8900; margin-top: 20%; width: 60%; margin-left: 20%;">
        <div class="progress-bar progress-bar-info" role="progressbar" style="width: 100%;"></div>
    </div>

    <alert ng-if="state.notification"
           type="{{state.notification.type}}"
           close="cleanUpNotification()"
           class="crimtan-alert">{{state.notification.message}}</alert>

    <div ng-if="!state.viewReload && !state.notification.hideView" ng-view class="container-fluid col-xs-12 col-sm-12 col-md-12"></div>
</body>
</html>

