//updating the records by using "where" clause
package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
				//based on id fetch the record
					//Connection 
					String driver="com.mysql.cj.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/deepika"; //deepika is the database name of mysql
					String un="root";
					String pass="root";
					Connection conn=null;
					Statement st=null;
					ResultSet rs=null;
					Scanner sc = new Scanner(System.in);
				System.out.println("enter username to update record");
					String username = sc.next();
					
					
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url,un,pass);
						st=conn.createStatement();
					  String sql="select * from login where username='"+username+"'"; //get only one row
					  //check id exists
					  rs=st.executeQuery(sql);
					  if(rs.next()) { //if true record exists
						  //Update operation when record exists
						  System.out.println("Enter userpassword to change");
							String userpassword=sc.next(); 
						String upd="update login set userpassword='"+userpassword+"' where username='"+username+"'";
						int  i=st.executeUpdate(upd);//statement to perform update operation
						
						if(i>0) {
							System.out.println("Record is Updated");
						}
						}//if
					  else {
						  System.out.println("Record not exists");
					  }
					  
				}catch(Exception e) {
					e.printStackTrace();
				}
	      }

	}
