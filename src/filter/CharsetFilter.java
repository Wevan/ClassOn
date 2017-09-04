package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wean on 2017/9/4.
 */
@WebFilter(filterName = "CharsetFilter",urlPatterns = "/charset")
public class CharsetFilter implements Filter {
    String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        this.charset=config.getInitParameter("charset");
    }

}
