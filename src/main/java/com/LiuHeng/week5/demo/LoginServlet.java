package com.LiuHeng.week5.demo;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {

//    public Connection dbConn;
//    public void init() {
//        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
//            dbConn = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("Username"), getServletConfig().getServletContext().getInitParameter("Password"));
//        } catch (Exception e) {
//            System.out.println(e); }
        con =(Connection)getServletContext().getAttribute("dbConn");
//        System.out.println(con);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password= request.getParameter("password");
        System.out.println(name + password);
//        System.out.println(con);
        try {
            if( con != null){
                String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    // writer.println("Login Success!!!");
                    // writer.println("Welcome "+name+".");
                    request.setAttribute("ID",rs.getInt("id"));
                    request.setAttribute("Username",rs.getString("name"));
                    request.setAttribute("Password",rs.getString("password"));
                    request.setAttribute("Email",rs.getString("email"));
                    request.setAttribute("Gender",rs.getString("gender"));
                    request.setAttribute("Birthdate",rs.getDate("birthdate"));
                    request.getRequestDispatcher("userinfo.jsp").forward(request, response);
                }else{
                    request.setAttribute("msg" ,"username or password Error");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    //  writer.print("Username or Password Error!!!");
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
