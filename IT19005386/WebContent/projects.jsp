<%@ page import="com.Project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/projects.js"></script>

<title>Project Management</title>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>Project Management</h1>
<form id="formItem" name="formItem">
 Project Name: 
 <input id="ProjectName" name="ProjectName" type="text" 
 class="form-control form-control-sm">
 <br> Project Type: 
 <input id="ProjectType" name="ProjectType" type="text" 
 class="form-control form-control-sm">
 
 <br> User ID: 
 <input id="UserID" name="UserID" type="text" 
 class="form-control form-control-sm">
 
 <br> sdate: 
 <input id="sdate" name="sdate" type="text" 
 class="form-control form-control-sm">
 
 <br> edate: 
 <input id="edate" name="edate" type="text" 
 class="form-control form-control-sm">
 
 <br> status: 
 <input id="status" name="status" type="text" 
 class="form-control form-control-sm">
 
 <br> invest status: 
 <input id="investStatus" name="investStatus" type="text" 
 class="form-control form-control-sm">
 
 <br> invest amount: 
 <input id="InvestmentAmount" name="InvestmentAmount" type="text" 
 class="form-control form-control-sm">
 
 <br> proposed equity: 
 <input id="ProposedEquity" name="ProposedEquity" type="text" 
 class="form-control form-control-sm">
 
 <br> Project timeline: 
 <input id="ProjectTimeline" name="ProjectTimeline" type="text" 
 class="form-control form-control-sm">
 
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 Project itemObj = new Project(); 
 out.print(itemObj.readProjects()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>