<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bs.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchResult.jsp' starting page</title>
    
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
					<tr> <th>#</th><th>题名</th> <th>作者</th> <th>摘要</th><th>期刊</th> <th>年份</th><th>关键词</th></tr> 
				</thead>
				<%	int i=1;
					List<docinfo> list = (ArrayList<docinfo>)request.getAttribute("list");
				 %>
				 <tbody>
				 <c:forEach items="${list}" var="list">
				  <tr> <th scope="row"><% out.print(i++);%></th> 
				  <td>${list.title}</td> 
				 <td>
				  <c:forEach items="${fn:split(list.author,';')}" var="var">
				  <a href="moredetails.jsp?author=${var}">${var}</a>;
				  </c:forEach></td>
				   
				  <td>${list.abstracts}</td>
				  <td>${list.journal}</td> 
				  <td>${list.year}</td>
				  <td>${list.keywords}</td>
				  </tr>
				  </c:forEach>
				  </tbody> 
				  
				  </table>
			</div>
		</div>
  </div>
 
  </body>
</html>
