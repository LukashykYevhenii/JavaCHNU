package lab2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab2.dao.jdbc.JdbcSummerSessionDAOImpl;
import lab2.model.SummerSession;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {

  JdbcSummerSessionDAOImpl jdbcSessionDAO = new JdbcSummerSessionDAOImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String group = req.getParameter("group");
    String info = req.getParameter("student_info");
    int first = Integer.parseInt(req.getParameter("first"));
    int second = Integer.parseInt(req.getParameter("second"));
    int third = Integer.parseInt(req.getParameter("third"));

    System.out.println("group = " + group);
    System.out.println("info = " + info);
    System.out.println("first = " + first);
    System.out.println("second = " + second);
    System.out.println("third = " + third);

    SummerSession session = new SummerSession(group, info, first, second, third);

    System.out.println("session = " + session);

    jdbcSessionDAO.save(session);

    resp.sendRedirect("/summerSession");

  }
}
