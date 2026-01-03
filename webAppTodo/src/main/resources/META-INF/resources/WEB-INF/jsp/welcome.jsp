<html>
	<head>
		<title>Welcome Page</title>
	</head>
	<body>
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		<div style="margin-left: 50px;">
		  
			<h3>Welcome Todo</h3>	
			
				<h4 style="margin-top: 30px;">
					Your Name:  ${name} </h4>					
			
			<a href="list-todos">Manage</a> your todos
			
			
		</div>
		<%@ include file="common/footer.jspf" %>
	</body>
</html>