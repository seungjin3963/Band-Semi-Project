<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layout.jsp</title>
<link rel="stylesheet" type="text/css" href="${cp }/MakingBand/css_makeband/makeBand.css">
<link rel="stylesheet" type="text/css" href="${cp }/MakingBand/css_makeband/bandMain.css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerbar">
			 <jsp:include page="${sessionScope.header }"/>
		</div>
	</div>
	<div id="main">
		<div id="mainbar">
			<jsp:include page="${requestScope.file }"/> 
		</div>
		<div id="footer">
			<div id="footerbar">
				<jsp:include page="${footer }"/> 
			</div>
		</div>
	</div>
</div>
</body>
</html>