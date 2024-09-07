<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .success-container {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            color: #333;
        }
        .welcome-message {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }
        .logout-button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .logout-button:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<%
String fN = (String)request.getAttribute("adminName");

%>
<div class="success-container">
    <h2>Login Successful!</h2>
    
    <p class="welcome-message">Welcome, <%=fN %></p>
    
    <form action="logout" method="post">
        <input type="submit" value="Logout" class="logout-button">
    </form>
</div>

</body>
</html>