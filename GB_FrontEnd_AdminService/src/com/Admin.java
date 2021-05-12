package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Admin {
	
	//establishing connection
	private Connection connect() { 
		
		Connection con = null; 
		try{ 
			Class.forName("com.mysql.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadget-badget?serverTimezone=UTC", "root", ""); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con; 
	}

	//retrieve innovator account details
	public String readInnovatorAccount() { 
		
		String output = ""; 
		
		try { 
			Connection con = connect(); 
			
			if (con == null) {
				return "Error while connecting to the database for reading."; } 
	 
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Innovator Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Action</th>"; 
				String query = "select * from innovators"; 
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
	 
				// iterate through the rows in the result set
	 
				while (rs.next()) { 
					String innID = Integer.toString(rs.getInt("innId"));
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String email = rs.getString("email");
					
					// Add into the html table
					output += "<tr><td>" + innID + "</td>"; 
					output += "<td>" + fname + "</td>"; 
					output += "<td>" + lname + "</td>"; 
					output += "<td>" + email + "</td>";
					
					// buttons
					output += "<td><form method='post' action='InnovatorAccountsDashboard.jsp'><input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'><input name='DeleteInnovatorID' type='hidden' value='" + innID + "'></form></td></tr>"; 
				} 
	 
				con.close(); 
				// Complete the html table
				output += "</table>"; 
		} catch (Exception e) { 
			output = "Error while reading the details."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	//retrieve buyer account details
	public String readBuyerAccount() { 
		
		String output = ""; 
		
		try { 
			Connection con = connect(); 
			
			if (con == null) {
				return "Error while connecting to the database for reading."; } 
	 
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Innovator Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Action</th>"; 
				String query = "select * from buyers"; 
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
	 
				// iterate through the rows in the result set
	 
				while (rs.next()) { 
					String buyerID = Integer.toString(rs.getInt("buyerId"));
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String email = rs.getString("email");
					
					// Add into the html table
					output += "<tr><td>" + buyerID + "</td>"; 
					output += "<td>" + fname + "</td>"; 
					output += "<td>" + lname + "</td>"; 
					output += "<td>" + email + "</td>";
					
					// buttons
					output += "<td><form method='post' action='BuyerAccountsDashboard.jsp'><input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'><input name='DeleteBuyerID' type='hidden' value='" + buyerID + "'></form></td></tr>"; 
				} 
	 
				con.close(); 
				// Complete the html table
				output += "</table>"; 
		} catch (Exception e) { 
			output = "Error while reading the details."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	//create user
	public String insertAccountInnovator(String fname, String lname, String email, String password) { 
		
		String output = ""; 
		
		try { 
			Connection con = connect(); 
			
			if (con == null) {
				return "Error while connecting to the database for inserting."; } 
				
				// create a prepared statement
				String query;
			
				query = " insert into innovators (`innId`,`fname`,`lname`,`email`,`password`)" + " values (?, ?, ?, ?, ?)"; 
				PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				// binding values
				preparedStmt.setInt(1, 1); 
				preparedStmt.setString(2, fname); 
				preparedStmt.setString(3, lname); 
				preparedStmt.setString(4, email); 
				preparedStmt.setString(5, password); 
				// execute the statement
				preparedStmt.execute(); 
				
				con.close(); 
				output = "Inserted successfully"; 
		} catch (Exception e) { 
			output = "Error while inserting the details."; 
			System.err.println(e.getMessage()); 
		}
		return output; 
	}  
	
	//create user
		public String insertAccountBuyer(String fname, String lname, String email, String password) { 
			
			String output = ""; 
			
			try { 
				Connection con = connect(); 
				
				if (con == null) {
					return "Error while connecting to the database for inserting."; } 
					
					// create a prepared statement
					String query;

					query = " insert into buyers (`buyerId`,`fname`,`lname`,`email`,`password`)" + " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, 1); 
					preparedStmt.setString(2, fname); 
					preparedStmt.setString(3, lname); 
					preparedStmt.setString(4, email); 
					preparedStmt.setString(5, password); 
					// execute the statement
					preparedStmt.execute(); 

					con.close(); 
					output = "Inserted successfully"; 
			} catch (Exception e) { 
				output = "Error while inserting the details."; 
				System.err.println(e.getMessage()); 
			}
			return output; 
		}
	
	public String updateInnovator( String fname, String lname, String email, String password, String innId) { 
	 
		String output = ""; 
	 
		try { 
			Connection con = connect(); 
	 
			if (con == null) {
				return "Error while connecting to the database for updating."; } 
	 
			// create a prepared statement
			String query = "UPDATE innovators SET fname=?, lname=?, email=?, password=? WHERE innId=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// binding values
			preparedStmt.setString(1, fname); 
			preparedStmt.setString(2, lname); 
			preparedStmt.setString(3, email); 
			preparedStmt.setString(4, password); 
			preparedStmt.setInt(5, Integer.parseInt(innId)); 
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			
			output = "Updated successfully"; 
		 } catch (Exception e) { 
			 output = "Error while updating the details."; 
			 System.err.println(e.getMessage()); 
		 }
		 return output; 
	}
	
	public String updateBuyer( String fname, String lname, String email, String password, String buyerId) { 
		 
		String output = ""; 
	 
		try { 
			Connection con = connect(); 
	 
			if (con == null) {
				return "Error while connecting to the database for updating."; } 
	 
			// create a prepared statement
			String query = "UPDATE buyers SET fname=?, lname=?, email=?, password=? WHERE buyerId=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// binding values
			preparedStmt.setString(1, fname); 
			preparedStmt.setString(2, lname); 
			preparedStmt.setString(3, email); 
			preparedStmt.setString(4, password); 
			preparedStmt.setInt(5, Integer.parseInt(buyerId)); 
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			
			output = "Updated successfully"; 
		 } catch (Exception e) { 
			 output = "Error while updating the details."; 
			 System.err.println(e.getMessage()); 
		 }
		 return output; 
	}
	
	//delete innovator account
	public String deleteInnovator(String innId) {
		
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from innovators where innId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(innId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Innovator Account Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//delete buyer account
	public String deleteBuyer(String buyerId) {
		
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from buyers where buyerId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(buyerId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Buyer Account Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
