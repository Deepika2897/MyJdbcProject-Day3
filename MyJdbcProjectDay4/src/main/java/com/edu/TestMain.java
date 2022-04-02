//fetching the records by using where clause
package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {

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
				System.out.println("enter USERNAME to fetch record");
				String  username = sc.next();
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url,un,pass);
					st=conn.createStatement();
					//if it is a string data-type then give'"+field-value+"' 
				  String sql="select * from login where USERNAME='"+username+"'"; //get only one row
				  rs=st.executeQuery(sql);
				  if(rs.next()) {
					  System.out.println(rs.getString(1)+" "+rs.getString(2));
				  }else {
					  System.out.println("user not exists");
				  }
				  }
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}
}