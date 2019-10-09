package webapp.servlet;

import webapp.MatchGame;
import webapp.common.config.MatchGameConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by Mathieu Le Veve on 09/10/2019
 * This class aims to provide a basic Servlet to the web client containing the match game logic
 *
 */
@WebServlet(name = "MatchGameServlet")
public class MatchGameServlet extends HttpServlet {
    private final static String MODE                = "mode";
    private final static String BTN_PLAYER_CHOICE   = "btn-player-choice";
    private static MatchGame game = new MatchGame();

    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response) throws ServletException, IOException {

        // First Step of the game
        if(!isNullOrEmpty(request.getParameter(MODE)) && isNullOrEmpty(request.getParameter(BTN_PLAYER_CHOICE))) {
            MatchGame.setMatchGame(request.getParameter(MODE));
            request.setAttribute("matches", MatchGameConfig.getMatches());
        } else if (isNullOrEmpty(request.getParameter(MODE)) && !isNullOrEmpty(request.getParameter(BTN_PLAYER_CHOICE))){
            // DO SMTH request.setAttribute("message", "");
        }


        System.out.println(game.toString());
        PrintWriter out = response.getWriter();
        out.println(game.toString());

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("./jsp/matchgame.jsp");
        requestDispatcher.forward(request, response);

    }
}
