import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Sneha"),
                @WebInitParam(name = "password", value = "sneha")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get request param for usr and password
        String user=req.getParameter("user");
        String pwd=req.getParameter("pwd");
        //get servlet config init params
        String userID=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");

        String nameValidate = "^[A-Z]{1}[A-Za-z]{2,}";
        if(userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd)) {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out  = resp.getWriter();
            out.println("<font color = red> username is wrong</font>");
            rd.include(req, resp);
        }



    }
}