package cn.tsuki.web;

import cn.tsuki.domain.CheckIn;
import cn.tsuki.exception.SignInException;
import cn.tsuki.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
@WebServlet(urlPatterns = "/getCheckIn")
public class GetCheckInServlet extends BaseServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
    {
        HttpSession session = request.getSession(true);
        //从HttpSession中获取系统当前用户、相片列表的当前页码
        String name = (String) session.getAttribute("curUser");
        response.setContentType("text/javascript;charset=gbk");
        //获取输出流
        PrintWriter out = response.getWriter();
        try {
            List<CheckIn> checkInList = signInService.getCheckInsByAccount(name);
            //清空id为list的元素

            out.println("var list = $('#list').empty();");
            for (CheckIn checkIn : checkInList) {
                //将每个动态添加到id为list的元素中
                out.println("list.append(\"<div align='center'> <h1>"
                        + checkIn.getCheckin_time() + "</h1></div>\");");
            }
        } catch (SignInException ex) {
            out.println("alert('" + ex.getMessage() + "请重试！')");
        }
    }
}

