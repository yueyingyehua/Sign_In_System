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
@WebServlet(urlPatterns = "/CheckIn")
public class ChechInServlet extends BaseServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        response.setContentType("text/javascript;charset=gbk");
        //获取输出流
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String name = (String) session.getAttribute("curUser");

        if (name != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String date = df.format(new Date());
            signInService.checkIn(name, date);
            System.out.println("qiandao1");
            out.println("alert('签到成功！！');");
            out.println("$('#notcheckInDiv').hide(500);");
            out.println("$('#hascheckInDiv').show(500);");
            out.println("onLoadCheckIn();");
        } else {
            out.println("alert('请先登入');");
        }




    }
}
