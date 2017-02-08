<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>stock</title>
<link rel="shortcut icon" href="logo.png" type="image/x-icon">
 <link rel="stylesheet" type="text/css" href="css/screen.css" >
 <link rel="stylesheet" type="text/css" href="css/styleT_2.css" >

</head>

<body>



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
      
      
    <center> <table class="table-viki" cellspacing='0'>
		<thead>
			<tr>
				
				<th>Brand</th>
				<th>Model</th>
				<th>Date</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					
					<td><center><c:out value="${item.brand}" /></center></td>
					<td><center><c:out value="${item.model}" /></center></td>
					<td><center><fmt:formatDate pattern="yyyy-MMM-dd" value="${item.date}" /></center></td>
					<td><a
						href="PhoneController?action=edit&id=<c:out value="${item.id}"/>">
						 <p style="text-align: center"><button>Update</button></p>
						
						</a></td>
					<td><a
						href="PhoneController?action=delete&id=<c:out value="${item.id}"/>">
						 <p style="text-align: center"><button>Delete</button></p>
						</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table></center>
	<p>
		
		<a href="PhoneController?action=insert">

	<p style="text-align: center"><button>Add</button></p>
	
</a>
	</p>
	
	<div class="overlay" id="overlay">
<div class="wrap"></div>
</div>


 <div id="footer" >&copy; Storage Phone 2016 <br>Created by - Igor Mashchykevych</div>
</body>

</html>