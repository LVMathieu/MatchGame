<%@ page import="static webapp.common.Constants.WINNER" %>
<%@ page import="static webapp.common.Constants.MATCHES" %><%--
  User: Mathieu
  Date: 09/10/2019
  Time: 00:13
  Note : This is the main page where the MatchGame will be played as well.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>MatchGame Demo</title>
        <!-- Latest compiled and minified CSS - only for production -->
        <link rel="stylesheet" href="./../css/bootstrap.min.css">
        <!-- compiled and minified bootstrap js library - only for production -->
        <script src="./../js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="text-center col-12">Select One, Two or Three Matches</h1>
                <br>
                <%
                    if (request.getAttribute(WINNER) != null) {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert(\"" + request.getAttribute(WINNER) + " has won this game.\");</script>");
                        request.removeAttribute(WINNER);
                        response.sendRedirect("../index.jsp");
                    } else if(request.getAttribute(MATCHES) != null) {
                        out.println("<div class=\"col-12 text-center\">");
                        for (int i = 0; i < (int) request.getAttribute(MATCHES); i++) {
                            out.println("<img src=\"./../fonts/Match.jpg\" alt=\"Match\">");
                        }
                        out.println("</div>");
                    }
                %>
                <br>
                <div class="col-12 text-center">
                    <form action="/matchgame" method="GET">
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="1"/>
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="2"/>
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="3"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
