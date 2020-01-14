package control;

import java.awt.Image;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import connection.ConnectionMake;
import model.Cat;
import model.Dog;
import model.User;

public class CRUDop {

	private static Connection conn;
	private final static String insertCat = "INSERT INTO cats (catId,Name,Breed,Age,Personality,Past,Fur,EnvironmentNeeded,Foster,Adopted)" + " VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM cats";		
	private final static String findStatementStringCat = "SELECT * FROM cats where Name = ? and Breed = ?";
	private final static String findStatementStringDog = "SELECT * FROM cats where Name = ? and Breed = ?";
	private final static String editCat = "UPDATE cats SET Name=?, Breed=?, Age=?, Personality=?, Past=?, Fur=?, EnvironmentNeeded=?,  Foster=?, Adopted=?\r\n" + 
			"WHERE catId=?";
	private final static String deleteCat = "DELETE FROM cats WHERE catId = ? ";
	private final static String deleteDog = "DELETE FROM dogs WHERE dogId = ? ";
	private final static String insertDog = "INSERT INTO dogs (dogId,Name,Breed,Age,Personality,Past,Size,EnvironmentNeeded,Foster,Adopted)" + " VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final static String findStatementString2 = "SELECT * FROM dogs";											
	private final static String editDog = "UPDATE dogs SET Name=?, Breed=?, Age=10, Personality=?, Past=?, Fur=?, EnvironmentNeeded=?, Foster=?, Adopted=?\r\n" + 
			"WHERE dogId=?";
	
	public static int insertCat(Cat c) {
		String fileName="";
		try {										
			fileName = "keepIDcat.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(Cat.countC);
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
		int catId=1;
		try {
			conn = ConnectionMake.getConnection();
			catId=c.getCatId();
			String Name=c.getName();
			String Breed=c.getBreed();
			int Age=c.getAge();
			String Personality=c.getPersonality();
			String Past=c.getPast();
			String Fur=c.getFur();
			String EnvironmentNeeded=c.getEnvironmentNeeded();
			//String picture=c.getPersonality();
			boolean Foster=c.isFoster();
			boolean Adopted=c.isAdopted();
			stmt = conn.prepareStatement(insertCat, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, catId);
			stmt.setString(2, Name);
			stmt.setString(3, Breed);
			stmt.setInt(4, Age);
			stmt.setString(5, Personality);
			stmt.setString(6, Past);
			stmt.setString(7, Fur);
			stmt.setString(8, EnvironmentNeeded);
			stmt.setBoolean(9,Foster);
			stmt.setBoolean(10,Adopted);
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM cats\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

			//ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM userr\r\n");
			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));

			//ResultSet rs = stmt.executeQuery("SELECT picture\r\n" + "FROM cats\r\n" + "WHERE Name="Kitty"\r\n ");
			/*ResultSet rs = stmt.executeQuery("SELECT picture FROM cats");
			if(rs.next()) {
				byte[] img= rs.getBytes("picture");
				ImageIcon image=new ImageIcon(img);
				Image im=image.getImage();
				Image myImg=im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage=new ImageIcon(myImg);
			}*/
			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));
			


			
		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert cat.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return catId;
	}
	

	public static int insertDog(Dog c) {
		String fileName="";
		try {										
			fileName = "keepIDdog.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(Dog.countD);
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
		int dogId=1;
		try {
			conn = ConnectionMake.getConnection();
			dogId=c.getDogId();
			String Name=c.getName();
			String Breed=c.getBreed();
			int Age=c.getAge();
			String Personality=c.getPersonality();
			String Past=c.getPast();
			String Size=c.getSize();
			String EnvironmentNeeded=c.getEnvironmentNeeded();
		
			boolean Foster=c.isFoster();
			boolean Adopted=c.isAdopted();
			stmt = conn.prepareStatement(insertDog, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, dogId);
			stmt.setString(2, Name);
			stmt.setString(3, Breed);
			stmt.setInt(4, Age);
			stmt.setString(5, Personality);
			stmt.setString(6, Past);
			stmt.setString(7, Size);
			stmt.setString(8, EnvironmentNeeded);
			stmt.setBoolean(9,Foster);
			stmt.setBoolean(10,Adopted);
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM dogs\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

			
		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert dog.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return dogId;
	}
	
	
	public static void deleteCat(int id) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteCat, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM cats\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete cat.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static void deleteDog(int id) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteDog, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM dogs\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete dog.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static void editCat(int catId,String Name,String Breed,int Age,String Personality,String Past,String Fur,String EnvironmentNeeded,boolean Foster,boolean Adopted) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editCat, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(10, catId);
			stmt.setString(1, Name);
			stmt.setString(2, Breed);
			stmt.setInt(3, Age);
			stmt.setString(4, Personality);
			stmt.setString(5, Past);
			stmt.setString(6, Fur);
			stmt.setString(7, EnvironmentNeeded);
			stmt.setBoolean(8,Foster);
			stmt.setBoolean(9,Adopted);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM cats\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot edit cat.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static void editDog(int dogId,String Name,String Breed,int Age,String Personality,String Past,String Size,String EnvironmentNeeded,boolean Foster,boolean Adopted) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editDog, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(10, dogId);
			stmt.setString(1, Name);
			stmt.setString(2, Breed);
			stmt.setInt(3, Age);
			stmt.setString(4, Personality);
			stmt.setString(5, Past);
			stmt.setString(6, Size);
			stmt.setString(7, EnvironmentNeeded);
			stmt.setBoolean(8,Foster);
			stmt.setBoolean(9,Adopted);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM dogs\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot edit dog.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	
	public static int findCat(String Name, String Breed) {
		//boolean toReturn = false;
		int catId=0;
		conn = ConnectionMake.getConnection();
		//Connection dbConnection = ConnectionMake.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = conn.prepareStatement(findStatementStringCat, Statement.RETURN_GENERATED_KEYS);
			findStatement.setString(1, Name);
			findStatement.setString(2, Breed);
			rs = findStatement.executeQuery();
			rs.next();
			catId=rs.getInt("catId");
	
			System.out.println(catId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionMake.close(rs);
			ConnectionMake.close(findStatement);
			ConnectionMake.close(conn);
		}
		//return toReturn;
		return catId;
	}
	
	public static int findDog(String Name, String Breed) {
		//boolean toReturn = false;
		int dogId=0;
		conn = ConnectionMake.getConnection();
		//Connection dbConnection = ConnectionMake.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = conn.prepareStatement(findStatementStringDog);
			findStatement.setString(1, Name);
			findStatement.setString(2, Breed);
			rs = findStatement.executeQuery();
	//		rs.next();
			dogId=rs.getInt("dogId");
	
			System.out.println(dogId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionMake.close(rs);
			ConnectionMake.close(findStatement);
			ConnectionMake.close(conn);
		}
		//return toReturn;
		return dogId;
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
