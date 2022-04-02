/*deleting the record after checking whether the records exists,
if exists then doing the delete operation*/
package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {

			public static void main(String[] args) {
				//based on user-name fetch the record from the existing table
				//Connection 
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/DEEPIKA"; //DEEPIKA is the database name of mysql
				String un="root";
				String pass="root";
				Connection conn=null;
				Statement st=null;
				ResultSet rs=null;
				Scanner sc = new Scanner(System.in);
				System.out.println("enter USERNAME to delete record");
				String  username = sc.next();
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url,un,pass);
					st=conn.createStatement();
					//if it is a string data-type then give'"+field-value+"' 
				  String sql="select * from login where USERNAME='"+username+"'"; //get only one row
				  //check id exists
				  rs=st.executeQuery(sql);
				  if(rs.next()) {//if true record exists
					  //delete operation when record exists
					  String del="delete from login where username='"+username+"'";
					  int i=st.executeUpdate(del);
					  if(i>0)
					  {
						  System.out.println("Record is deleted");
					  }
				  }//if
					  
				  else {
					  System.out.println("Record not exists");
				  }
				  }
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}
}