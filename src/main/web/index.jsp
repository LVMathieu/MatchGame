<%@ page import="static webapp.common.Constants.WINNER" %>
<%@ page import="java.io.PrintWriter" %><%--
  Author: Mathieu Le Veve
  Date: 08/10/2019
  Time: 23:10

  Note : This page is an home page with rule details and three buttons for choosing the level mode.
  Then it submits the form to the matchgame servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>MatchGame Demo</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- compiled and minified bootstrap js library -->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="align-content-center"> Matches Game !! </h1>

            <%
                if (request.getAttribute(WINNER) != null) {
                        final PrintWriter pw = response.getWriter();
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('" + request.getAttribute(WINNER) + " has won this game.');");
                        pw.println("</script>");
                        request.removeAttribute(WINNER);
                }
            %>

            <h2 class="align-content-center"> Rules: </h2>
            <p class="align-content-center">
                Two players are face to face and they are opposed for a match game.
                Both are faced to matches number which can fluctuate depending on the game.
                Each round, the current player can remove one, two or three matches.
                Whom is taking the last match is the winner.
            </p>
            <h2 class="align-content-center">Before starting, type an username and select a level mode !!</h2>
            <br>
                <div class="row text-center">
                    <form action="/App/matchgame" method="GET" class="col-12">
                        <label for="input-username" class="col-3 text-center">Username: </label>
                        <input type="text" class="btn col-3" name="username" id="input-username" placeholder="Username" required>
                        <br>
                        <input type="submit" class="btn col-2" name="mode" value="Noobie">
                        <input type="submit" class="btn col-2" name="mode" value="Medium">
                        <input type="submit" class="btn col-2" name="mode" value="Expert">
                    </form>
                </div>
        </div>
    </body>
</html>
