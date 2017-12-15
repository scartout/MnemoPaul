package pl.scartout.mnemopaul.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import pl.scartout.mnemopaul.service.UserService;
 
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String password2 = request.getParameter("confirmPassword");
        String email = request.getParameter("inputEmail");
        if (password.equals(password2)) {
        	UserService userService = new UserService();
        	userService.addUser(username, password, email);
        	response.sendRedirect(request.getContextPath() + "/login");
        }
        else response.sendRedirect(request.getContextPath() + "/register");
    }
 
}