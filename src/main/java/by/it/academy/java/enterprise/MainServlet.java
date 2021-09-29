package by.it.academy.java.enterprise;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        Long visitCounter = (Long) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1L;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<h2>Welcome to servlets</h2>");
            writer.println("Page was visited " + visitCounter + " times."+"\n"+
                    "Name of current Thread  "+Thread.currentThread().getName());
        }


    }
}
