package cn.tsuki.web;

import cn.tsuki.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tsuki on 2017/4/14.
 */
@WebServlet(urlPatterns="/pageLoad")
public class PageLoadServlet extends BaseServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        response.setContentType("text/javascript;charset=gbk");
        System.out.println("接受到pageLoad请求");
        //获取输出流
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String name = (String) session.getAttribute("curUser");

        //如果name不为null，表明用户已经登录
        if (name != null)
        {
            System.out.println("name!= null");
            //隐藏id为noLogin的元素（用户登录面版）
            out.println("$('#noLogin').hide(500);");
            out.println("$('#hasLogin').show(500);");
            out.println("onLoadCheckIn();");


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String date = df.format(new Date());
            if(signInService.IshasCheckIn(name, date))
            {
                out.println("$('#notcheckInDiv').hide(500);");
                out.println("$('#hascheckInDiv').show(500);");

            }
        }
    }
}
