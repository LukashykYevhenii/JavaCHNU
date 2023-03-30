package lab2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab2.dao.jdbc.JdbcSummerSessionDAOImpl;
import lab2.model.SummerSession;

@WebServlet("/summerSession")
public class SummerSessionServlet extends HttpServlet {

  JdbcSummerSessionDAOImpl jdbcSessionDAO = new JdbcSummerSessionDAOImpl();
  ArrayList<SummerSession> summerSessions = null;


  public void myException() {
    throw new ArithmeticException("test arithmetic exception");
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    //myException();

    summerSessions = jdbcSessionDAO.getAllSessions();

    HttpSession session = req.getSession();
    session.invalidate();

    PrintWriter out = resp.getWriter();

    int fiveCount = 0, fourCount = 0, threeCount = 0, twoCount = 0;
    double avgFirst = 0, avgSecond = 0, avgThird = 0;

    for (SummerSession summerSession : summerSessions) {

      int firstSubMark = summerSession.getSubjectFirst();
      int secondSubMark = summerSession.getSubjectSecond();
      int thirdSubMark = summerSession.getSubjectThird();

      if (firstSubMark == 5) {
        fiveCount++;
      } else if (firstSubMark == 4) {
        fourCount++;
      } else if (firstSubMark == 3) {
        threeCount++;
      } else if (firstSubMark == 2) {
        twoCount++;
      }
      avgFirst += firstSubMark;

      if (secondSubMark == 5) {
        fiveCount++;
      } else if (secondSubMark == 4) {
        fourCount++;
      } else if (secondSubMark == 3) {
        threeCount++;
      } else if (secondSubMark == 2) {
        twoCount++;
      }
      avgSecond += secondSubMark;

      if (thirdSubMark == 5) {
        fiveCount++;
      } else if (thirdSubMark == 4) {
        fourCount++;
      } else if (thirdSubMark == 3) {
        threeCount++;
      } else if (thirdSubMark == 2) {
        twoCount++;
      }
      avgThird += thirdSubMark;
    }

    out.println("<html><head>");
    out.println(
        "<style> table, td, th{ border: 1px solid black; text-align: center;margin-left: 45px;}"
            + "a{display: inline-block;text-decoration: none;color: white;background-color:#4287f5;padding: 5px;}"
            + ".one{float:left;} h1, h2{margin-left: 45px;};</style>");
    out.println("</head><body>");
    out.println("<div class='one'>");
    out.println("<a href='/index.jsp'>Main page</a>");
    out.println("</div>");
    out.println("<div class='one'>");
    out.println("<h2>Summer session</h2>");
    out.println("<table><tr>");
    out.println("<th>group</th>");
    out.println("<th>info</th>");
    out.println("<th>first</th>");
    out.println("<th>second</th>");
    out.println("<th>third</th>");
    out.println("</tr>");
    for (SummerSession summerSession : summerSessions) {
      out.println("<tr>");
      out.println("<td>" + summerSession.getGroupNum() + "</td>");
      out.println("<td>" + summerSession.getStudentInfo() + "</td>");
      out.println("<td>" + summerSession.getSubjectFirst() + "</td>");
      out.println("<td>" + summerSession.getSubjectSecond() + "</td>");
      out.println("<td>" + summerSession.getSubjectThird() + "</td>");
      out.println("<td><a href='/delete?id="+ summerSession.getIdSession()+"'>delete</a></td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</div>");

    out.println("<div class='one'>");
    out.println("<h2>Marks count</h2>");
    out.println("<table><tr>");
    out.println("<th>Mark</th><th>Count</th></tr>");
    out.println("<tr><td>Five</td><td>" + fiveCount + "</td>");
    out.println("</tr>");
    out.println("<td>Four</td><td>" + fourCount + "</td>");
    out.println("</tr>");
    out.println("<td>Three</td><td>" + threeCount + "</td>");
    out.println("</tr>");
    out.println("<td>Two</td><td>" + twoCount + "</td>");
    out.println("</tr>");
    out.println("</tr></table>");
    out.println("</div>");

    out.println("<div class='one'>");
    out.println("<h2>Average marks</h2>");
    out.println("<table><tr>");
    out.println("<th>Subject</th><th>Avg mark</th></tr>");
    out.println("<tr><td>First subject</td><td>" + avgFirst / summerSessions.size() + "</td>");
    out.println("</tr>");
    out.println("<td>Second subject</td><td>" + avgSecond / summerSessions.size() + "</td>");
    out.println("</tr>");
    out.println("<td>Third subject</td><td>" + avgThird / summerSessions.size() + "</td>");
    out.println("</tr>");
    out.println("</tr></table>");
    out.println("</div>");

    out.println("</body></html>");

    System.out.println("fiveCount = " + fiveCount);
    System.out.println("fourCount = " + fourCount);
    System.out.println("threeCount = " + threeCount);
    System.out.println("twoCount = " + twoCount);
    System.out.println("avgFirst = " + avgFirst / summerSessions.size());
    System.out.println("avgSecond = " + avgSecond / summerSessions.size());
    System.out.println("avgThird = " + avgThird / summerSessions.size());
    System.out.println(summerSessions);

    //summerSessions = null;
  }
}
