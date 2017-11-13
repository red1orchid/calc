package curr.calc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
/*TODO: ajax only*/
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*        UserData userData = (UserData) req.getSession().getAttribute("userData");

        req.setAttribute("company", userData.getCompanyInfo());
        req.setAttribute("isWidgetActive", dao.isWidgetActive(userData.getCompanyId()));
        req.setAttribute("isSync", SyncDao.getSyncState(userData.getCompanyId()));*/

        req.getRequestDispatcher("jsp/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
