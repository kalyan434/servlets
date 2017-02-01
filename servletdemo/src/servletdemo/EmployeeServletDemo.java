package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServletDemo extends HttpServlet  {

	
	public void addParameter(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, ClassNotFoundException, SQLException{
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		String eid=request.getParameter("employee_eid");
		String ename=request.getParameter("employee_ename");
		String eaddress=request.getParameter("employee_eadd");
		String ephone=request.getParameter("employee_ephone");
		String esalary= request.getParameter("employee_esalary");
		
		EmployeeDao empd=new EmployeeDao();
		empd.addemployee (Integer.parseInt(eid), ename, Integer.parseInt(esalary), eaddress,Integer.parseInt( ephone));

}
}


