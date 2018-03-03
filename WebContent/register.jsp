<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<style>
		body{
		background:FloralWhite;
		margin-left:50px;
		margin-top:50px;
		}
		table{
			width=100%;
			border:2px solid skyblue;
			}
		</style>
</head>
<body>
	<form action="loginRegister" method="post">
	
	<h3 style=color:purple>Registration</h3>
	
		<table>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password1"/></td>
			</tr>
			<tr>
				<td>Retype Password: </td>
				<td><input type="password" name="password2"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Register"/></td>
			</tr>
		</table>
	</form>
</body>
</html>