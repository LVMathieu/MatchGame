<%@ page import="static webapp.common.Constants.WINNER" %>
<%@ page import="static webapp.common.Constants.MATCHES" %>
<%@ page import="static webapp.common.Constants.*" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Author: Mathieu
  Date: 09/10/2019
  Time: 00:13
  Note : This is the main page where the MatchGame will be played as well.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>MatchGame Demo</title>
        <!-- Latest compiled and minified CSS - only for production -->
        <link rel="stylesheet" href="./css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="text-center col-12">Select One, Two or Three Matches</h1>
                <br>
                <%
                    // This part is the end of game when a winner was raised. Otherwise the game continues to be played
                    if (request.getAttribute(WINNER) != null) {
                        request.getRequestDispatcher("./index.jsp").forward(request, response);
                    } else if(request.getAttribute(MATCHES) != null) {
                        // display last hit from the IA Player<
                        if (request.getAttribute(BTN_IA_CHOICE) != null) {
                            final String endSentence =
                                    request.getAttribute(BTN_IA_CHOICE).equals('1') ? " was removed." : " were removed.";
                            out.println("<br><div class=\"col-12 text-center\"><p class=\"font-weight-bold\">"
                                            + request.getAttribute(BTN_IA_CHOICE) + endSentence + "</p><br>");
                        }
                        out.println("<div class=\"col-12 text-center\">");
                        // loading matches image
                        for (int i = 0; i < (int) request.getAttribute(MATCHES); i++) {
                            out.println("<img src=\"./fonts/Match.jpg\" alt=\"Match\">");
                        }
                        out.println("</div>");
                    }
                %>
                <br>
                <!-- The player selects one of the suggested options and submits -->
                <div class="col-12 text-center">
                    <form action="/App/matchgame" method="GET">
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="1"/>
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="2"/>
                        <input type="submit" class="btn col-3" name="btn-player-choice" value="3"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
