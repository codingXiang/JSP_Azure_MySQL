<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.security.*"%>
<%String id = request.getParameter("id");%>
<jsp:useBean id="database" class="com.database.Database">
  <jsp:setProperty property="ip" name="database" value="140.120.54.114"/>
  <jsp:setProperty property="port" name="database" value="3306"/>
  <jsp:setProperty property="db" name="database" value="7105029031"/>
  <jsp:setProperty property="user" name="database" value="7105029031"/>
  <jsp:setProperty property="password" name="database" value="7105029031"/>
</jsp:useBean>
<%
  database.connectDB();
  database.query("select * from attraction where id = " + id);
  ResultSet rs = database.getRS();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <style>
      .card-header{
        font-size:20px;
        font-weight: bold;
      }
    </style>
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

    <script>
      $(".button-collapse").sideNav();
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>
  <body>

      <%
        if (rs != null){
          while(rs.next()){
            String name = rs.getString("name");
            String photo = rs.getString("photo");
            String des = rs.getString("description");
            String createdAt = rs.getString("createdAt");
      %>
      <div class="navbar-fixed">
          <nav>
              <div class="nav-wrapper">
                  <a href="#!" class="brand-logo"><%=name%></a>
              </div>
          </nav>
      </div>
      <div class="row">
      <div class="col s12">
        <div class="card">
          <div class="card-image" >
            <img src="<%=photo%>" style="background-color:black;"height=500>
          </div>
          <div class="card-content">
            <h style="font-size:20px;font-weight:bold;"><%=name%></h>
            <p><%=des%></p>
          </div>
        </div>
      </div>
      <%}}%>
    </div>

  </body>
</html>
