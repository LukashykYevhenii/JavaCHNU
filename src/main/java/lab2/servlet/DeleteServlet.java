package lab2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab2.dao.jdbc.JdbcSummerSessionDAOImpl;

@WebServlet("/delete")
  public class DeleteServlet extends HttpServlet {

    JdbcSummerSessionDAOImpl summerSessionDAO = new JdbcSummerSessionDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
      int id = Integer.parseInt(req.getParameter("id"));
        summerSessionDAO.remove(summerSessionDAO.getById(id));
      resp.sendRedirect("/summerSession");

    }
  }
