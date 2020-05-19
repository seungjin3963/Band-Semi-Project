<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layout.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/MakingBand/css/makeBand.css?ver=1.1">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/MakingBand/css/bandMain.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<%
String file=(String)request.getAttribute("file");

if(file == null){
	file="BandList/bandList.jsp";
} 
%>
<div id="wrap">
	<div id="header">
		<div id="headerbar">
			<jsp:include page="bandList_header.jsp"/>
		</div>
	</div>
	<div id="main">
		<div id="mainbar">
			<jsp:include page="<%=file %>"/>
		</div>
	</div>
	<div id="footer">
		<div id="footerbar">
		
		</div>
	</div>
</div>
</body>
</html>