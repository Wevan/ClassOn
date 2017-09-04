package servlet;

import Dao.ChzLoginDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Wean on 2017/8/30.
 */
@WebServlet(name = "login",urlPatterns = "/login")
public class ChzLoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session=request.getSession();
        String chzname=request.getParameter("chzuname");
        String chzpwd=request.getParameter("chzpwd");
        if (new ChzLoginDao().checkInfo(chzname,chzpwd)){
            session.setAttribute("chzuname",chzname);
            session.setAttribute("chzpwd",chzpwd);
            response.sendRedirect("show.jsp");
        }else {
            response.sendRedirect("fail.jsp");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }


}
