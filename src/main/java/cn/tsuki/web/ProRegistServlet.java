package cn.tsuki.web;

import cn.tsuki.exception.SignInException;
import cn.tsuki.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tsuki on 2017/4/14.
 */
@WebServlet(urlPatterns = "/proRegist")
public class ProRegistServlet extends BaseServlet {

    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        //获取输出流
        PrintWriter out = response.getWriter();
        try {
            out.println("$('#user,#password').val('');");
            if (name != null && password != null && signInService.registAccount(name, password) > 0) {
                HttpSession session = request.getSession(true);
                session.setAttribute("curUser", name);
                out.println("alert('恭喜您，您已经注册成功！');");
                out.println("$('#noLogin').hide(500);");
                out.println("$('#hasLogin').show(500);");
                //获取签到信息
                out.println("onLoadCheckIn();");

            } else {
                out.println("alert('您注册出现失败，请选择合适的用户名重试!');");
            }
        } catch (SignInException ex) {
            out.println("alert('("+ex.getMessage() + "请更换用户名重试！');");
        }
    }
}
