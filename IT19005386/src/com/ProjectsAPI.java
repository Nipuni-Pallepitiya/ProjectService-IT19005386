package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectsAPI
 */
@WebServlet("/ProjectsAPI")
public class ProjectsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Project projectObj = new Project();
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public ProjectsAPI() {
	super();
	// TODO Auto-generated constructor stub
	}



	private static Map getParasMap(HttpServletRequest request)
	{
	Map<String, String> map = new HashMap<String, String>();
	try
	{
	Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	String queryString = scanner.hasNext() ?
	scanner.useDelimiter("\\A").next() : "";
	scanner.close();
	String[] params = queryString.split("&");
	for (String param : params)
	{
	String[] p = param.split("=");
	map.put(p[0], p[1]);
	}
	}
	catch (Exception e)
	{
	}
	return map;
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}



	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String output = projectObj.insertProject(
	request.getParameter("ProjectName"),
	request.getParameter("ProjectType"),
	request.getParameter("UserID"),
	request.getParameter("sdate"),
	request.getParameter("edate"),
	request.getParameter("status"),
	request.getParameter("investStatus"),
	request.getParameter("InvestmentAmount"),
	request.getParameter("ProposedEquity"),
	request.getParameter("ProjectTimeline")
	
	
			);
	response.getWriter().write(output);
	}



	/**
	* @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	*/
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map paras = getParasMap(request);
	String output = projectObj.updateProject(paras.get("hidItemIDSave").toString(),
	paras.get("ProjectName").toString(),
	paras.get("ProjectType").toString(),
	paras.get("UserID").toString(),
	paras.get("sdate").toString(),
	paras.get("edate").toString(),
	paras.get("status").toString(),
	paras.get("investStatus").toString(),
	paras.get("InvestmentAmount").toString(),
	paras.get("ProposedEquity").toString(),
	paras.get("ProjectTimeline").toString()
	
			
			);
	response.getWriter().write(output);
	}



	/**
	* @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	*/
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map paras = getParasMap(request);
	String output = projectObj.deleteProject(paras.get("ProjectID").toString());
	response.getWriter().write(output);
	}



	}
