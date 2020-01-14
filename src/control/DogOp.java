package control;

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

import connection.ConnectionMake;
import model.Dog;

public class DogOp {
	
	private static Connection conn;
	private final static String findStatementString = "SELECT * FROM dogs where Breed = ? and Age = ? and Size = ? ";//and Personality = ? ";			
	
	public static void findByBreedAgeSizePers(String Breed, int Age, String Size) {

		conn = ConnectionMake.getConnection();
		//Connection dbConnection = ConnectionMake.getConnection();
		PreparedStatement findStatement = null;
		ResultSet res = null;//ResultSet res2 = null;
		JTable table=null;
		try {
			findStatement = conn.prepareStatement(findStatementString);
			findStatement.setString(1, Breed);
			findStatement.setInt(2, Age);
			findStatement.setString(3, Size);
			//findStatement.setString(4, Pers);
			res = findStatement.executeQuery();
			
			res.beforeFirst();
			if(res.next())
			{
		//		res2 = findStatement.getGeneratedKeys();
		
	//		int catId=res.getInt("catId");
	//		String breed = res.getString("Breed");
	//	   	int age = res.getInt("Age");
	///			boolean Foster=res.getBoolean("Foster");
	///			boolean Adopted=res.getBoolean("Adopted");
	//		System.out.println(catId +" "+breed+" "+age);
			
	///		toReturn = new Cat("Name", Breed, Age, "Personality","Past", "Size", "Env");
			///ResultSet rs = findStatement.executeQuery("SELECT *\r\n" + "FROM userr\r\n");
			table = new JTable(buildTableModel(res));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry...we don't have any dog that matches your desires");
			//System.out.println("we don't have any cat that matches your desires");
			//System.out.println(catId +" "+breed+" "+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionMake.close(res);
			ConnectionMake.close(findStatement);
			ConnectionMake.close(conn);
		}
		///return toReturn;
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
