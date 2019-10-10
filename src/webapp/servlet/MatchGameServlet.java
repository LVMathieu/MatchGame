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

import static java.lang.Integer.parseInt;
import static webapp.common.Constants.*;
import static webapp.common.utils.StringUtils.isNullOrEmpty;

/**
 * Created by Mathieu Le Veve on 09/10/2019
 * This class aims to provide a basic Servlet to the web client containing the match game logic
 *
 */
@WebServlet(name = "MatchGameServlet")
public class MatchGameServlet extends HttpServlet {
    private final static String JSP_MATCHGAME_PATH = "./jsp/matchgame.jsp";
    private static MatchGame game = new MatchGame();

    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response) throws ServletException, IOException {

        // First Step of the game
        if(!isNullOrEmpty(request.getParameter(MODE))
                && !isNullOrEmpty(request.getParameter(USERNAME))
                && isNullOrEmpty(request.getParameter(BTN_PLAYER_CHOICE))) {
            MatchGame.setMatchGame(request.getParameter(MODE), request.getParameter(USERNAME));
        } else if (isNullOrEmpty(request.getParameter(MODE)) && !isNullOrEmpty(request.getParameter(BTN_PLAYER_CHOICE))) {
            final int playerChoice = parseInt(request.getParameter(BTN_PLAYER_CHOICE));
            game.playUserTurn(playerChoice);
            if (game.isWinner()) {
                request.setAttribute(WINNER, MatchGameConfig.getUsername());
            } else {
                final int matchesRemoved = game.playIATurn();
                request.setAttribute(BTN_IA_CHOICE, matchesRemoved);
                if (game.isWinner()) {
                    request.setAttribute(WINNER, IA_NAME);
                }
            }
        }
        request.setAttribute(MATCHES, MatchGameConfig.getMatches());
        System.out.println(game.toString());
        PrintWriter out = response.getWriter();
        out.println(game.toString());

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher(JSP_MATCHGAME_PATH);
        requestDispatcher.forward(request, response);

    }
}
