package lab2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorServlet")
public class ErrorServlet extends HttpServlet {

  public ErrorServlet() {
    super();
  }

  final String EXCEPTION = "javax.servlet.error.exception";
  final String MESSAGE = "javax.servlet.error.message";
  final String STATUS = "javax.servlet.error.status_code";


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();

    Exception exception = (Exception)req.getAttribute(EXCEPTION);
    Integer status_code = (Integer) req.getAttribute(STATUS);
    String message = (String) req.getAttribute(MESSAGE);

    System.out.println("message = " + message);

    writer.println("<html><body><hr>");
    writer.println("<h1>Error</h1>");
    writer.println("<table><tr>");
    writer.println("<td><h3>Status code = </h3></td><td><h3>" + status_code + "</h3></td>");
    writer.println("</tr><tr>");
    writer.println("<td><h3>Exception type = </h3></td><td><h3>"+ exception.getClass().getName() + " </h3></td>");
    writer.println("</tr><tr>");
    writer.println("<td><h3>Message = </h3></td><td><h3> " + message + "</h3></td>");
    writer.println("</tr></table>");
    writer.println("</body></html>");


  }
}
