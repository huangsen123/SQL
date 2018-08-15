package it.cast_02;
import java.sql.*;
public class Gradation {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	public Connection getConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("数据库驱动加载成功");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","root","920813");
			System.out.println("数据库连接成功");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args){
		Gradation c=new Gradation();
		con=c.getConnection();
		try{
			sql=con.createStatement();
			res=sql.executeQuery("select*from emp");
			while(res.next()){
			String empno=res.getString("empno");
			String ename=res.getString("ename");
			String job=res.getString("job");	
			String hiredate=res.getString("hiredate");	
			System.out.println("编号："+empno);
			System.out.println("姓名:"+ename);	
			System.out.println("工作："+job);	
			System.out.println("工作时间："+hiredate);	
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}
	}

}
