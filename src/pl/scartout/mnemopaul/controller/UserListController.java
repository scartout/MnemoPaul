package pl.scartout.mnemopaul.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.service.UserService;
 
@WebServlet("/userlist")
public class UserListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	saveUsersInRequest(request);
    	
        request.getRequestDispatcher("WEB-INF/userlist.jsp").forward(request, response);
    }
    
    private void saveUsersInRequest(HttpServletRequest request) {
        UserService userService = new UserService();
        List<User> allUsers = userService.getAllUser();
        request.setAttribute("users", allUsers);
    }

}