<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap API -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- BootStrap API -->
</head>
<body>
<!-- nav -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
<%--       <li><a href="<%= request.getContextPath() %>/point/pointList">Point</a></li> --%>	<!--요즘은 안쓴다  -->
      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>	<!-- 공통적으로 쓰이는 페이지는 절대경로로 씀 -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<!-- Jumbotron -->
<div class="container">
  <div class="jumbotron">
    <h1>Bootstrap Tutorial</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
  <p></p>      
  <p></p>      
</div>
	<div class="container">
		<div class="row">
		<h1></h1>
		<h1></h1>
  <h2>Member Join</h2>
  <form action="./memberJoin" method="post">
    <div class="form-group">
      <label for="Id">ID:</label>

      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" >
    </div>
    
    <div class="form-group">
      <label for="Password">Password:</label>
      <input type="text" class="form-control" id="password" placeholder="Enter Password" name="password">
    </div>
    
   <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
   
   <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>
   
   <div class="form-group">
      <label for="Email:">Email::</label>
      <input type="text" class="form-control" id="email:" placeholder="Enter Email:" name="email:">

    </div>
   
   <div class="form-group">
      <label for="Age:">Age::</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age:" name="age">

    </div>
    <input type="submit" class="btn btn-default" value="Submit">
  </form>
</div>


</body>
</html>