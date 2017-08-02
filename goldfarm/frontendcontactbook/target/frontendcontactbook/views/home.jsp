<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<title>Insert title here</title>
</head>
<body>


 	<c:url var="action" value="add"></c:url>
   
	<form:form action="${action}" commandName="userdetails">
		<table>
			<tr>
				<td><form:label path="twitterusername">
						<spring:message text="Twitter UserName" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty userdetails.twitterusername}">
						<td><form:input path="twitterusername" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="twitterusername" pattern =".{6,7}" required="true" title="id should contains 6 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
				<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
			<form:input path="emailid" hidden="true"  />
				<td><form:label path="emailid">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input type="email" path="emailid" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="phonenumber">
						<spring:message text="phonenumber" />
					</form:label></td>
				<td><form:input type="number" path="phonenumber" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><c:if test="${!empty supplier.name}">
						<input type="submit"
							value="<spring:message text="Edit Supplier"/>" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit" value="<spring:message text="Add Supplier"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
        
        
        
 <%-- <c:url var="action" value="add"></c:url>
	<form:form action="${action}" method="post">
	
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" required="true"></td>
			</tr>
			<tr>
				<td>emailid</td>
				<td><input type="email" name="emailid" required="true"></td>
			</tr>
			<tr>
				<td>Phone number</td>
				<td><input type="number" name="phonenumber" required="true"></td>
			</tr>
			 

			<tr>
				<td>twitterusername</td>
				<td><input type="text" name="twitterusername" required="true"></td>
			</tr>
			 


			<tr>
				<td><input type="submit" value="add">
				<td><input type="reset" value="delete">
			</tr>

		</table>

	</form:form>
	  --%>
</body>
</html>