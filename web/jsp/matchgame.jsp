<%--
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
    </head>
    <body>
        <h1 class="align-content-center col-12">Select One, Two or Three Matches</h1>
        <%
            if(request.getAttribute("matches") != null) {
                final int test = (int) request.getAttribute("matches");
                for (int i = 0; i < test; i++) {
                    out.println("<img src=\"./../fonts/Match.jpg\" alt=\"Match\">");
                }
            }
        %>
        <br>
        <button type="button" class="btn" name="btn-player-choice">1</button>
        <button type="button" class="btn" name="btn-player-choice">2</button>
        <button type="button" class="btn" name="btn-player-choice">3</button>
    </body>
</html>
