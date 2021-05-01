package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Project {



public Connection connect() {

		Connection con = null;
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb", "root", "");
		
		System.out.println("Successfully connected");
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		
		return con;
}

public String insertProject(String ProjectName,String ProjectType,String UserID, String sdate, String edate,String status,String investStatus,String InvestmentAmount,String ProposedEquity,String ProjectTimeline) {

		String output = "";
		
		try {
		Connection con = connect();
		
		if(con == null) {
		
		return "Error while connecting to the database";
		
		}
		
		String query = " insert into projects(`ProjectID`,`ProjectName`,`ProjectType`,`UserID`,`sdate`,`edate`,`status`,`investStatus`,`InvestmentAmount`,`ProposedEquity`,`ProjectTimeline`)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, ProjectName);
		preparedStmt.setString(3, ProjectType);
		preparedStmt.setString(4, UserID);
		preparedStmt.setString(5, sdate);
		preparedStmt.setString(6, edate);
		preparedStmt.setString(7, status);
		preparedStmt.setString(8, investStatus);
		preparedStmt.setDouble(9, Double.parseDouble(InvestmentAmount));
		preparedStmt.setDouble(10, Double.parseDouble(ProposedEquity));
		preparedStmt.setString(11, ProjectTimeline);
		
		preparedStmt.execute();
		con.close();
		
		String newProjects = readProjects();
		output = "{\"status\":\"success\", \"data\": \"" +
		newProjects + "\"}";

		}

		catch(Exception e){
		output = "{\"status\":\"error\", \"data\":\"Error while inserting the project.\"}";
		System.err.println(e.getMessage());
		}
		
		return output;
}

public String readProjects() {

	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for reading."; }
	// Prepare the html table to be displayed
	output = "<table border='1'><tr><th>ProjectName</th><th>ProjectType</th><th>UserID</th><th>sdate</th>" +
	"<th>eDate</th>" +
	"<th>status</th>" +
	"<th>investStatus</th>" +
	"<th>InvestmentAmount</th>" +
	"<th>ProposedEquity</th>" +
	"<th>ProjectTimeline</th>" +
	"<th>Update</th><th>Remove</th></tr>";
	String query = "select * from projects";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String ProjectID = Integer.toString(rs.getInt("ProjectID"));
	String ProjectName = rs.getString("ProjectName");
	String ProjectType=rs.getString("ProjectType");
	String UserID=Integer.toString(rs.getInt("UserID"));
	String sdate = rs.getString("sdate");
	String edate = rs.getString("edate");
	String status = rs.getString("status");
	String investStatus = rs.getString("investStatus");
	String InvestmentAmount = Double.toString(rs.getDouble("InvestmentAmount"));
	String ProposedEquity = Double.toString(rs.getDouble("ProposedEquity"));
	String ProjectTimeline = rs.getString("ProjectTimeline");
	// Add into the html table
	output += "<tr><td>" + ProjectName + "</td>";
	output += "<td>" + ProjectType + "</td>";
	output += "<td>" + UserID + "</td>";
	output += "<td>" + sdate + "</td>";
	output += "<td>" + edate + "</td>";
	output += "<td>" + status + "</td>";
	output += "<td>" + investStatus + "</td>";
	output += "<td>" + InvestmentAmount + "</td>";
	output += "<td>" + ProposedEquity + "</td>";
	output += "<td>" + ProjectTimeline + "</td>";
	// buttons
	output += "<td><input name='btnUpdate' type='button' value='Update' "
			+ "class='btnUpdate btn btn-secondary' data-itemid='" + ProjectID + "'></td>"
			+ "<td><input name='btnRemove' type='button' value='Remove' "
			+ "class='btnRemove btn btn-danger' data-itemid='" + ProjectID + "'></td></tr>";
			}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the projects.";
	System.err.println(e.getMessage());
	}
	return output;
}
		
public String deleteProject(String ProjectID) {
		
		String output = "";
		
		try {
		
		Connection con = connect();
		if(con == null) {
		return "Error while connecting to the database for deleting.";
		}
		
		String query = "delete from projects where ProjectID=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		preparedStmt.setInt(1, Integer.parseInt(ProjectID));
		
		preparedStmt.execute();
		con.close();
		
		String newProjects = readProjects();
		output = "{\"status\":\"success\", \"data\": \"" +
		newProjects + "\"}";
		}
		catch(Exception e) {
		output = "{\"status\":\"error\", \"data\": \"Error while deleting the project.\"}";
		System.err.println(e.getMessage());
		}
		return output;
}

public String updateProject(String ProjectID,String ProjectName,String ProjectType,String UserID, String sdate, String edate,String status,String investStatus,String InvestmentAmount,String ProposedEquity,String ProjectTimeline) {

String output = "";

try {

Connection con = connect();
if(con == null) {
return "Error while connecting to the database for update.";
}

String query = "UPDATE projects SET ProjectName=?,ProjectType=?,UserID=?,sdate=?,edate=?,status=?,investStatus=?,InvestmentAmount=?,ProposedEquity=?,ProjectTimeline=? WHERE ProjectID=?";
PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
preparedStmt.setString(1, ProjectName);
preparedStmt.setString(2, ProjectType);
preparedStmt.setInt(3,  Integer.parseInt(UserID));
preparedStmt.setString(4, sdate);
preparedStmt.setString(5, edate);
preparedStmt.setString(6, status);
preparedStmt.setString(7, investStatus);
preparedStmt.setDouble(8, Double.parseDouble(InvestmentAmount));
preparedStmt.setDouble(9, Double.parseDouble(ProposedEquity));
preparedStmt.setString(10, ProjectTimeline);
preparedStmt.setInt(11, Integer.parseInt(ProjectID));

preparedStmt.execute();
con.close();

String newItems = readProjects();
output = "{\"status\":\"success\", \"data\": \"" +
newItems + "\"}";
}
catch(Exception e) {
output = "{\"status\":\"error\", \"data\": \"Error while updating the project.\"}";
System.err.println(e.getMessage());
}
return output;
}


}
