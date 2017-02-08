<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css">
	
	<title>Phone detail</title>
<link rel="shortcut icon" href="logo.png" type="image/x-icon">
 <link rel="stylesheet" type="text/css" href="css/screen.css" >
 
 
 
	<script>
	  $(function() {
	    $( "#datepicker" ).datepicker();
	  });
	</script>
</head>
<body>
	<script>
		$(function() {
			$('input[name=date]').datepicker();
		});
	</script>
	
	<div id="header">
         <nav>
            <ul>
               <li><a href="index.html"title="home">home</a></li>
			   <li><a href="ListPhone.jsp"title="stock">stock</a></li>
               <li><a href="subfolder/manufacturer.html"title="manufacturer">manufacturer</a></li>
               <li><a href="subfolder/about.html"title="about us">about us</a></li>
            </ul>
         </nav>
      </div>
	
	 <div id="inputArea">
	<form method="POST" action='PhoneController' name="form">
		<input type="hidden" readonly="readonly" name="id"
            value="<c:out value="${item.id}" />" />  
		Brand : <input type="text" name="brand"
			value="<c:out value="${item.brand}" />" /> <br />
		Model : <input type="text" name="model" 
		    value="<c:out value="${item.model}" />" /><br />  
		Date : <input type="text" name="date" id="datepicker"
			value="<fmt:formatDate pattern="dd/MM/yyyy" value="${item.date}" />" />
		<br /> 
		<input type="submit" value="OK" />
	</form>
	</div>
	
	<div id="footer" class="footer">&copy; Storage Phone 2016 <br>Created by - Igor Mashchykevych</div>
</body>
</html>