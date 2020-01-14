package control;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import connection.ConnectionMake;

import model.User;

public class UserOp {

	private static Connection conn;
	private final static String insertUser = "INSERT INTO userr (userId,name,email,username,password)" + " VALUES (?,?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM userr where username = ? and password = ?";											
	
	public static int insertUser(User uu) {
		String fileName="";
		try {										
			fileName = "keepID.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(User.count);
			bufferedWriter.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		PreparedStatement stmt = null;
		ResultSet res;
		int userId=1;
		try {
			conn = ConnectionMake.getConnection();
			userId=uu.getUserId();
			String name=uu.getName();
			String email=uu.getEmail();
			String username=uu.getUsername();
			String password=uu.getPassword();
			stmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, userId);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM userr\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert user. You could try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return userId;
	}
	
	
	public static boolean findLogin(String username, String password) {
		boolean toReturn = false;
		conn = ConnectionMake.getConnection();
		//Connection dbConnection = ConnectionMake.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = conn.prepareStatement(findStatementString);
			findStatement.setString(1, username);
			findStatement.setString(2, password);
			rs = findStatement.executeQuery();
			rs.next();
			int userId=rs.getInt("userId");
			String name = rs.getString("name");
			String email = rs.getString("email");
			
			toReturn =true;
			//System.out.println(userId+" "+name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionMake.close(rs);
			ConnectionMake.close(findStatement);
			ConnectionMake.close(conn);
		}
		return toReturn;
	}
	

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		java.sql.ResultSetMetaData metaData = (java.sql.ResultSetMetaData) rs.getMetaData();
		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}
		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}
	

}
