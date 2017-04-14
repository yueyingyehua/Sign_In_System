package cn.tsuki.web.base;

import cn.tsuki.service.SignInService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by tsuki on 2017/4/14.
 */
public class BaseServlet extends HttpServlet {
    protected SignInService signInService;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        signInService = (SignInService) context.getBean("signInService");
    }
}
