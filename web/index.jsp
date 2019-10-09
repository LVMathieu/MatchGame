<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 08/10/2019
  Time: 23:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>MatchGame Demo</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <!-- compiled and minified bootstrap js library -->
        <script src="./js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1> Hello World !! </h1>
        <p> This is a sample of body text</p>
        <div class="row col-12">
            <form action="/matchgame" method="GET">
                <label for="input-username" class="col-6">Username: </label>
                <input type="text" class="btn col-6" name="username" id="input-username" placeholder="Username" required>
                <input type="submit" class="btn col-3" name="mode" value="Noobie">
                <input type="submit" class="btn col-3" name="mode" value="Medium">
                <input type="submit" class="btn col-3" name="mode" value="Expert">
            </form>
        </div>
    </body>
</html>
