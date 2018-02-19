package org.dao;
import java.sql.*;

import org.pojo.Employee;
public class EmpDAO {
	private Connection con;
	private PreparedStatement pstmtEmpReg,pstmtEmpLogin;
	private String sqlEmpReg="insert into employee (empId,empUserName,empEmail,empPassword,empAddress,empContactNo) values(emp_seq.nextval,?,?,?,?,?)";
	//private String sqlEmpReg="insert into Employee (empUserName,empEmail,empPassword,empAddress,empContactNo) values(?,?,?,?,?)";
	private String sqlEmpLogin="select empId,empUserName,empAddress,empContactNo from Employee where empEmail=? and empPassword=?";
	public EmpDAO() throws ClassNotFoundException, SQLException{
		String driver=/*"com.mysql.jdbc.Driver";*/"oracle.jdbc.OracleDriver";
		String url=/*"jdbc:mysql://localhost:3306/TestDB";*/"jdbc:oracle:thin:@localhost:1521:XE";
		String dbuser="system";//"hr";
		String dbpass="system";//"mo123";
		Class.forName(driver);
		con=DriverManager.getConnection(url,dbuser,dbpass);
		pstmtEmpReg=con.prepareStatement(sqlEmpReg);
		pstmtEmpLogin=con.prepareStatement(sqlEmpLogin);
	}
	public int empReg(String empUserName,String empEmail,String empPassword,String empAddress,String empContactNo) throws SQLException{
		pstmtEmpReg.setString(1, empUserName);
		pstmtEmpReg.setString(2, empEmail);
		pstmtEmpReg.setString(3, empPassword);
		pstmtEmpReg.setString(4, empAddress);
		pstmtEmpReg.setString(5, empContactNo);
		int row=pstmtEmpReg.executeUpdate();
		return row;		
	}
	public Employee empLogin(String empEmail,String empPassword) throws SQLException{
		pstmtEmpLogin.setString(1, empEmail);
		pstmtEmpLogin.setString(2, empPassword);
		ResultSet rs=pstmtEmpLogin.executeQuery();		
		if(rs.next()){
			Employee e=new Employee(rs.getInt(1),rs.getString(2),empEmail,null,rs.getString(3),rs.getString(4));
			return e; 
		}	
		else{
			return null;
		}
	}	
}