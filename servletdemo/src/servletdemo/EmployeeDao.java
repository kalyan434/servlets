package servletdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class EmployeeDao {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDao ed=new EmployeeDao();
		ed.addemployee(6, "kalyan", 1000, "660", 135);
		//ed.deleteEmployee(1);
		//ed.updateEmployee(3, "sravanthi", 1000, "boas street", 12345678);
	}
	
	
public  void  addemployee(int eid,String ename,int esal,String eaddress,int ephone)throws ClassNotFoundException, SQLException  
{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:xe","chinna","chinna");
	Statement stmt=con.createStatement();
String insertsql="insert into employee(eid,ename,esal,eaddress,ephone)values ("+eid+",'"+ename+"',"+esal+",'"+eaddress+"',"+ephone+")";

	int result=stmt.executeUpdate(insertsql);
	
	if(result>0)
		
		
	{
		System.out.println("Inserted Sucessfully");
	}
	else{
		System.out.println("Insertion fail");
	}
	
	
	
	
}
public void deleteEmployee(int eid) throws ClassNotFoundException, SQLException{
	
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:xe","chinna","chinna");
	Statement stmt=con.createStatement();
	String deletesql="delete employee where eid="+eid;
	int result=stmt.executeUpdate(deletesql);
	if(result>0){
		System.out.println("Delete Sucessfully");
	}else{
		System.out.println("Delete failed");
	}
}
public  void updateEmployee(int eid,String ename,int esal,String eaddress,int ephone) throws ClassNotFoundException, SQLException{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:xe","chinna","chinna");
	Statement stmt=con.createStatement();
	String updatesql="update employee set ename='"+ename+"' ,esal="+esal+",ephone="+ephone+" ,eaddress='"+eaddress+"' where eid="+eid;
	System.out.println(updatesql);
	int result=stmt.executeUpdate(updatesql);
	
	System.out.println("result is"+result);
	if (result>0){
		System.out.println("Update Sucessfully");
	}
	else{
		System.out.println("Update Failed");
	}
	
	
	
	 
}









}
