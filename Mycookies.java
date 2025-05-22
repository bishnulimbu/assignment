import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/MyCookies")
public class Mycookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // create new cookies
        Cookie c1 = new Cookie("Name", "Sohan");
        Cookie c2 = new Cookie("id", "Sohan@123");

        // set valid time for 1 hour
        c1.setMaxAge(60 * 60);
        c2.setMaxAge(60 * 60);

        // add cookies to response
        response.addCookie(c1);
        response.addCookie(c2);

        out.println("<h1>Cookies Example</h1>");

        // Read cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<h3>Cookie Name: " + cookie.getName() + "</h3>");
                out.println("<h3>Cookie Value: " + cookie.getValue() + "</h3>");
            }
        } else {
            out.println("<p>No cookies</p>");
        }
    }
}
