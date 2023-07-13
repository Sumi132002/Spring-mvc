<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo Home</title>
</head>
<body>
${list}
<h2 style="color:green">${pass}</h2>
<h1 align="center">Todo Home Page</h1>
<fieldset>
<table align="center" border="2px solid black" >
			<tr>
				<th>ID</th>
				<th>Task Name</th>
				<th>Description</th>
				<th>Date</th>
				<th>Status</th>
				<th>Change Status</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			<tr>
				<th>1</th>
				<th>Swimming</th>
				<th>Learn swimming within 30 Days</th>
				<th>30/08/2023</th>
				<th>Incomplete</th>
				<th><button>Change</button></th>
				<th><button>Delete</button></th>
				<th><button>Update</button></th>
			</tr>
		</table>
	<a href="AddTask.jsp"><button style="margin-top:50px;margin-left: 300px;margin-right: 600px">Add Task</button></a>
		<a href="logout"><button>Logout</button></a>
		</fieldset>
</body>
</html>