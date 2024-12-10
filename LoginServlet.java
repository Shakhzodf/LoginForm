package net.javaguides.login.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.login.bean.LoginBean;
import net.javaguides.login.database.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp"); // GET so'rovlarda login sahifasiga qaytadi
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        if (loginDao.validate(username, password)) {
            response.sendRedirect("success.jsp"); // Muvaffaqiyat sahifasi
        } else {
            response.sendRedirect("login.jsp?error=1"); // Xatolik bo'lsa, qayta login
        }
    }
}

