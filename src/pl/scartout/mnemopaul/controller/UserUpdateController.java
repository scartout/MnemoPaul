package pl.scartout.mnemopaul.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.service.UserService;
 
@WebServlet("/updateuser")
public class UserUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long user_id = Long.valueOf(request.getParameter("user_id"));
        updateUser(user_id);
        response.sendRedirect(request.getContextPath() + "/edituserlist");
    }

    private void updateUser(long user_id) {
        UserService userService = new UserService();
        User user = userService.getUserById(user_id);
        user.setRole("admin");
        userService.updateUser(user);
    }

}