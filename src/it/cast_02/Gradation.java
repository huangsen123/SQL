package it.cast_02;
import java.sql.*;
public class Gradation {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	public Connection getConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("���ݿ��������سɹ�");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","root","920813");
			System.out.println("���ݿ����ӳɹ�");
			
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
			System.out.println("��ţ�"+empno);
			System.out.println("����:"+ename);	
			System.out.println("������"+job);	
			System.out.println("����ʱ�䣺"+hiredate);	
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}
	}

}
