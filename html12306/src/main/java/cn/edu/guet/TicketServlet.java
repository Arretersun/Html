package cn.edu.guet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("余票查询");
        /*webServer:Tomcat jBoss webLogic websPhere
        后台获取网页中提交的数据
        * 网页中的input中的数据在点击查询的一瞬间都被<web server>:封装到了一个对象中
        * 这个对象就是HttpServletRequest对象
        request对象是Tomcat容器帮我们创建的，
        * */
        //request.setCharacterEncoding("UTF-8");//tomcat把我们的数据封装到HttpServletRequest对象中，自动将编码转变了，所以要重新转变回来

        String startStation=request.getParameter("startStation");
        //System.out.println("起始站："+startStation);
        String endStation=request.getParameter("endStation");
        // System.out.println("终点站："+endStation);
        String departureDate=request.getParameter("departureDate");
        //System.out.println("出发日期："+departureDate);

        /*String allTickets=TicketSearch.search(startStation,endStation,departureDate);*/
/*        List<Ticket> ticketList= (List<Ticket>) TicketSearch.search(startStation,endStation,departureDate);
        String json = JSON.toJSONString(ticketList, SerializerFeature.PrettyFormat);
        //设置相应类型，响应到前端，把车次json数据返回给浏览器
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();*/
/*      System.out.println("起始站："+startStation);
        System.out.println("终点站："+endStation);
        System.out.println("出发日期："+departureDate);*/

        String allTickets=TicketSearch.search(startStation,endStation,departureDate);
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out=response.getWriter();
        out.println(allTickets);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*doGet(request,response);*/

    }
}
