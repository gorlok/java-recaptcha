<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% String key = ResourceBundle.getBundle("config").getString("RECAPTCHA_KEY"); %>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://www.google.com/recaptcha/api.js?hl=es-419" async defer></script>
</head>

<body>
	<form action="login" method="post">
		<label>Username:</label><input type="text" name="user"><br>
		<label>Password:</label><input type="password" name="pwd"><br>
		<div class="g-recaptcha" data-sitekey="<%=key%>"></div>
		<br>
		<input type="submit" value="Login">
	</form>
	<p>Use admin/1234 to test login.</p>
</body>
</html>