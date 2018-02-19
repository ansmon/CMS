package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.pojo.Engineer;
import org.pojo.Ticket;

public class EnggDAO {
	private Connection con;
	private PreparedStatement pstmtEnggReg,pstmtEnggLogin,pstmtFetchNameNo,pstmtAllEngineer;
	private String sqlEnggReg="insert into Engineer (enggId,enggUserName,enggEmail,enggPassword,enggAddress,enggContactNo) values(engi_seq.nextval,?,?,?,?,?)";
	//private String sqlEnggReg="insert into Engineer (enggUserName,enggEmail,enggPassword,enggAddress,enggContactNo) values(?,?,?,?,?)";
	private String sqlEnggLogin="select enggId,enggUserName,enggAddress,enggContactNo from Engineer where enggEmail=? and enggPassword=?";
	private String sqlFetchNameNo="select enggUserName,enggContactNo from Engineer where enggId=?";
	private String sqlAllEngineer="select enggId,enggUserName,enggEmail,enggContactNo from Engineer";
	public EnggDAO() throws ClassNotFoundException, SQLException{
		String driver=/*"com.mysql.jdbc.Driver";*/"oracle.jdbc.OracleDriver";
		String url=/*"jdbc:mysql://localhost:3306/TestDB";*/"jdbc:oracle:thin:@localhost:1521:XE";
		String dbuser="system";//"hr";
		String dbpass="system";//"mo123";
		Class.forName(driver);
		con=DriverManager.getConnection(url,dbuser,dbpass);
		pstmtEnggReg=con.prepareStatement(sqlEnggReg);
		pstmtEnggLogin=con.prepareStatement(sqlEnggLogin);
		pstmtFetchNameNo=con.prepareStatement(sqlFetchNameNo);
		pstmtAllEngineer=con.prepareStatement(sqlAllEngineer);
	}
	public int enggReg(String enggUserName,String enggEmail,String enggPassword,String enggAddress,String enggContactNo) throws SQLException{
		pstmtEnggReg.setString(1, enggUserName);
		pstmtEnggReg.setString(2, enggEmail);
		pstmtEnggReg.setString(3, enggPassword);
		pstmtEnggReg.setString(4, enggAddress);
		pstmtEnggReg.setString(5, enggContactNo);
		int row=pstmtEnggReg.executeUpdate();
		return row;		
	}
	public Engineer enggLogin(String enggEmail,String enggPassword) throws SQLException{
		pstmtEnggLogin.setString(1, enggEmail);
		pstmtEnggLogin.setString(2, enggPassword);
		ResultSet rs=pstmtEnggLogin.executeQuery();		
		if(rs.next()){
			Engineer e=new Engineer(rs.getInt(1),rs.getString(2),enggEmail,null,rs.getString(3),rs.getString(4));
			return e;
		}		
		else{
			return null;
		}
	}
	public Engineer fetchNameNo(int enggId) throws SQLException{
		pstmtFetchNameNo.setInt(1, enggId);		
		ResultSet rs=pstmtFetchNameNo.executeQuery();		
		if(rs.next()){
			Engineer e=new Engineer(enggId, rs.getString(1), null, null, null, rs.getString(2));
			return e;
		}		
		else{
			return null;
		}
	}
	public ArrayList<Engineer> allEngineer() throws SQLException{
		ResultSet rs=pstmtAllEngineer.executeQuery();
		ArrayList<Engineer> eList=null;
		while(rs.next()){
			Engineer e=new Engineer(rs.getInt(1), rs.getString(2), rs.getString(3), null, null, rs.getString(4));
			if(eList==null){
				eList=new ArrayList<>();
			}
			eList.add(e);
		}		
		return eList;
	}
	
}
