<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<title>一粒种子的梦想</title>
	<jsp:include page="/common/common.jsp"></jsp:include>
</head>
<body>
<h2>Hello World!</h2>
<form action="<%=request.getContextPath() %>/active/sayGreet" method="POST">
	<input type="text" name="content"/>
	<input type="submit" value="确定"/>
</form>
</body>
</html>
