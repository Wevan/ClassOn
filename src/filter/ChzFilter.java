package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Wean on 2017/8/30.
 */
@WebFilter(filterName = "ChzFilter", urlPatterns = "/loginfliter")
public class ChzFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //登录url


        if (isCheck(request.getRequestURI().toString())) {
            System.out.println("地址：" + request.getRequestURI().toString());
            System.out.println("姓名"+session.getAttribute("chzuname"));
            if (session.getAttribute("chzuname") != null) {
                chain.doFilter(req, resp);
            } else {
                //跳转到登录
                request.getRequestDispatcher("index.jsp").forward(request, resp);
                //另一种转跳方式
//                response.sendRedirect("http://"+request.getHeader("Host")+"/index.jsp");
            }
        }else {
            chain.doFilter(req,resp);
        }
    }

    private boolean isCheck(String path) {
        if (path.endsWith("/login")||path.endsWith("/fail.jsp")) {
            return false;
        }
        return true;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
