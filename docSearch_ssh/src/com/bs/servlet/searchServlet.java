package com.bs.servlet;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bs.bean.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class searchServlet extends HttpServlet {
	//数据库相关设置
	static final String JDBC_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	static final String DB_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=SEE2016;characterEncoding=UTF-8";
	static final String USER = "sa";
	static final String PASS = "";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//List<All> list = new ArrayList<All>();
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		String title1 = "搜索结果";
//		String docType =
//				"<!doctype html public \"-//w3c//dtd html 4.0 " +
//				"transitional//en\">\n";
//				out.println(docType +
//				"<html>\n" +
//				"<head><meta charset=\"utf-8\"><title>" + title1 + "</title></head>\n" +
//				"<body bgcolor=\"#f0f0f0\">\n" +
//				"<h1 align=\"center\">" + title1 + "</h1>\n" +
//				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
//				"<tr bgcolor=\"#949494\">\n" +
//				"<th>题名</th><th>作者</th><th>摘要</th><th>期刊</th><th>年份</th><th>关键词</th>\n"+
//				"</tr>\n");
		Connection conn = null;
		Statement stmt = null;
		
		List<docinfo> list = new ArrayList<docinfo>();
		try{
			//加载数据库驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = null;
			//获取从页面传输来的数据
			
			String selectCond = request.getParameter("selectCond");
			String selectCond2 = request.getParameter("selectCond2");
			String selectCond3 = request.getParameter("selectCond3");
			String selectCond4 = request.getParameter("selectCond4");
			String searchCont1 = new String(request.getParameter("searchCont1").getBytes("ISO-8859-1"),"UTF-8");
			String searchCont2 = new String(request.getParameter("searchCont2").getBytes("ISO-8859-1"),"UTF-8");
			String searchCont3 = new String(request.getParameter("searchCont3").getBytes("ISO-8859-1"),"UTF-8");
			String searchCont4 = new String(request.getParameter("searchCont4").getBytes("ISO-8859-1"),"UTF-8");
			String andor1 = request.getParameter("andor1");
			String andor2 = request.getParameter("andor2");
			String andor3 = request.getParameter("andor3");
			
			//搜索功能
			if(andor1.equals("yu") && andor2.equals("yu") && andor3.equals("yu")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' AND " + selectCond2 + " LIKE '%" + searchCont2 + "%' AND " + selectCond3 + " LIKE '%" + searchCont3 + "%' AND " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("yu") && andor2.equals("yu") && andor3.equals("huo")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' AND " + selectCond2 + " LIKE '%" + searchCont2 + "%' AND " + selectCond3 + " LIKE '%" + searchCont3 + "%' OR " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("yu") && andor2.equals("huo") && andor3.equals("huo")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' AND " + selectCond2 + " LIKE '%" + searchCont2 + "%' OR " + selectCond3 + " LIKE '%" + searchCont3 + "%' OR " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("huo") && andor2.equals("huo") && andor3.equals("huo")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' OR " + selectCond2 + " LIKE '%" + searchCont2 + "%' OR " + selectCond3 + " LIKE '%" + searchCont3 + "%' OR " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("huo") && andor2.equals("huo") && andor3.equals("yu")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' OR " + selectCond2 + " LIKE '%" + searchCont2 + "%' OR " + selectCond3 + " LIKE '%" + searchCont3 + "%' AND " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("huo") && andor2.equals("yu") && andor3.equals("yu")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' OR " + selectCond2 + " LIKE '%" + searchCont2 + "%' AND " + selectCond3 + " LIKE '%" + searchCont3 + "%' AND " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("huo") && andor2.equals("yu") && andor3.equals("huo")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' OR " + selectCond2 + " LIKE '%" + searchCont2 + "%' AND " + selectCond3 + " LIKE '%" + searchCont3 + "%' OR " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}else if(andor1.equals("yu") && andor2.equals("huo") && andor3.equals("yu")){
				sql = "SELECT * FROM docdetails WHERE " + selectCond + " LIKE '%" + searchCont1 + "%' AND " + selectCond2 + " LIKE '%" + searchCont2 + "%' OR " + selectCond3 + " LIKE '%" + searchCont3 + "%' AND " + selectCond4 + " LIKE '%" + searchCont4 + "%'";
			}
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				docinfo dinfo = new docinfo();
				dinfo.setDocid(rs.getInt("docid"));
				dinfo.setTitle(rs.getString("title"));
				dinfo.setAuthor(rs.getString("author"));
				dinfo.setJournal(rs.getString("journal"));
				dinfo.setAbstracts(rs.getString("abstracts"));
				dinfo.setYear(rs.getString("year"));
				dinfo.setKeywords(rs.getString("keywords"));
				list.add(dinfo);
				
//				String title = rs.getString("title");
//				String author = rs.getString("author");
//				String abstracts = rs.getString("abstracts");
//				String journal = rs.getString("journal");
//				String year = rs.getString("year");
//				String keywords = rs.getString("keywords");
				//All a1 = new All(title, author, summary, journary, age, keyword);
				//list.add(a1);
//				out.println("<tr>");
//				out.println("<td>"+title+"</td>");
//				
//				out.println("<td>"+author+"</td>");
//				out.println("<td>"+abstracts+"</td>");
//				out.println("<td>"+journal+"</td>");
//				out.println("<td>"+year+"</td>");
//				out.println("<td>"+keywords+"</td>");
//				out.println("</tr>");
			}
//			out.println("\n</table>");
//			out.println("\n<a href='search.html'>回到上一页</a>");
//			out.println("\n</body></html>");
			rs.close();
			stmt.close();
			conn.close();
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchResult.jsp").forward(request, response);
		}catch(Exception se){
			se.printStackTrace();
		}
		//super.doPost(request, response);
	}
}
