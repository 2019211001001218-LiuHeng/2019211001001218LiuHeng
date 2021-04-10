<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 刘衡
  Date: 2021/4/10
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet"%>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Birthday</td>
    </tr>
    <%
        //get rs from request attribute
      ResultSet rs= (ResultSet) request.getAttribute("rs=name");//name of attribute-
        if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            //get one by one
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");

            out.println("</tr>");
        }
    }
        //we will get date in next demo - 6.Livedemo #3
    %>
</table>

<%@include file="footer.jsp"%>
