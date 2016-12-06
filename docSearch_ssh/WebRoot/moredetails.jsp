<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*,java.util.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
	<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- jQuery -->

	<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
	<!-- /js -->
<script src="js/jquery-1.10.2.min.js"></script>
  </head>
  
  <body>
 
    <div class="error_page">
    	<div class="graph">
    		<div class="tables">
    			<table class="table table-bordered">
    				<thead>
    					<tr> <th>#</th><th>作者</th><th>关键词</th></tr>
    				</thead>
    				<% int i=1; %>
	    			<%
				  	 String JDBC_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
					 String DB_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=SEE2016;characterEncoding=UTF-8";
					 String USER = "sa";
					 String PASS = "";
					 Connection conn = null;
					 Statement stmt = null;
					 try{
							//加载数据库驱动
							Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
						
					
							conn = DriverManager.getConnection(DB_URL, USER, PASS);
							stmt = conn.createStatement();
							String sql = null;
							String author = request.getParameter("author");
							sql = "select keyword,count(*) from wordindoc where docid in (select docid from links where aid=(select aid from authors where author='" + author +"')) group by keyword order by count(*) desc";
							ResultSet rs = stmt.executeQuery(sql);
							while(rs.next()){
  	 %>
    					<tr>
    						<td><%out.print(i++); %></td>
    						<td><%out.print(request.getParameter("author")); %></td>
    						<td><%out.print(rs.getString("keyword")); %></td>
    					</tr>
    				<%
    					}
    					rs.close();
						stmt.close();
						conn.close();
    				 %>
    			</table>
    		</div>
    	</div>
    
    </div>
  </body>
</html>
