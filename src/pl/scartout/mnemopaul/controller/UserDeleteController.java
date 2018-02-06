package pl.scartout.mnemopaul.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.service.UserService;
 
@WebServlet("/deleteuser")
public class UserDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long user_id = Long.parseLong(request.getParameter("user_id"));
        UserService.deleteUser(user_id);
        response.sendRedirect(request.getContextPath() + "/userlist");
    }

}