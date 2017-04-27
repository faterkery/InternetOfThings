<%@ page language="java" pageEncoding="UTF-8"%>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String realUrl = basePath + "login.html";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    </head>

    <body>
        <br>
        <br>
        <%
        response.sendRedirect(realUrl);
        %>
    </body>
</html>