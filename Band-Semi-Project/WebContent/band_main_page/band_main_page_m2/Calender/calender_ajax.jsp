
<%@page import="jhta.band.db.JDBCUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int bandnum=Integer.parseInt(request.getParameter("num"));
	int year=Integer.parseInt(request.getParameter("year"));
	int month=Integer.parseInt(request.getParameter("month"));
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String CalenderTitle="";
	int Calenderdate=0;
	String content="";
	ArrayList<String> TitleList=new ArrayList<String>();
	ArrayList<Integer> dateList=new ArrayList<Integer>();
	ArrayList<String> contentList=new ArrayList<String>();
	try{
		con=JDBCUtil.getConn();			//밴드 번호
		String sql="select aa.* , to_char(CALENDARdate,'dd') gg from(select * from calendar where band_num=? and to_char(CALENDARdate,'yyyy')=? and to_char(CALENDARdate,'mm')=?)aa";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, bandnum);
		pstmt.setInt(2, year);
		pstmt.setInt(3, month);
		rs=pstmt.executeQuery();
		while(rs.next()){
			CalenderTitle=rs.getString("CALENDARTITLE");
			Calenderdate=rs.getInt("gg");
			content=rs.getString("calendarcontent");
			TitleList.add(CalenderTitle);
			dateList.add(Calenderdate);
			contentList.add(content);
			
		}	
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		try{
		if(rs!=null){rs.close();}
		if(pstmt!=null){pstmt.close();}
		if(con!=null){con.close();}
		}catch(SQLException sse){
			sse.printStackTrace();
		}
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version='1.0' encoding='utf-8' ?>");
	pw.print("<result>");
	for (int i = 0; i < TitleList.size(); i++) {
		
	pw.print("<calendertitle>"+TitleList.get(i)+"</calendertitle>");
	pw.print("<calenderdate>"+dateList.get(i)+"</calenderdate>");
	pw.print("<calendercontent>"+contentList.get(i)+"</calendercontent>");
	}
	pw.print("</result>");
%>









