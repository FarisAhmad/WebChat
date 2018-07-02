package br.com.ltp4.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public Connection getConnection() {
	        try { 
	            // Load the JDBC driver   
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        	
	            return DriverManager.getConnection(
	                    "jdbc:oracle:thin:@25.75.218.192:1521:XE", "LTP", "ltp");
	        
	        } catch (ClassNotFoundException e) {  
	        	System.out.println("Nao foi possivel achar o driver do banco de dados.");
	            return null; 
	        } catch (SQLException e) {
	            System.out.println("Nao foi possivel conectar ao banco de dados.");
	            return null;
	        }
	        
	    }
}
