<!DOCTYPE HTML>
<html>
<head>
<title>搜索结果</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<%@ page import="java.util.*" %>
<%@ page import="com.bs.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<!--clock init-->
</head> 
<body>
								<!--/404-->
									   <div class="error_page error">
												<!--/error-top-->
													<div class="error-top error">
															<div class="graph">
																<div class="tables">
																<%List list =(List) request.getAttribute("list"); %>
																
																	<table class="table table-bordered">
																		<thead>
																		<tr>
																			<th>标题</th>
																			<th>作者</th>
																			<th>摘要</th>
																			<th>期刊</th>
																			<th>年份</th>
																			<th>关键词</th>
																		</tr>
																		</thead>
																		<c:forEach var="list" items="${list}">
																			<tr>
																				<td>${list.title}</td>
																				<td>${list.author}</td>
																				<td>${list.summary}</td>
																				<td>${list.journary}</td>																				
																				<td>${list.age}</td>
																				<td>${list.keyword}</td>
																			</tr>
																		</c:forEach>
																	</table>
																</div>
															</div>
															<div class="error-btn">
															<a class="read fourth" href="index.html">Return to Home</a>
															</div>
														</div>

												<!--//error-top-->
										   </div>
										    <!--footer section start-->
										<div class="footer error">
										   <p>Copyright &copy; 2016.Company name All rights reserved.</p>
										</div>
									<!--footer section end-->
									<!--/404-->
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>