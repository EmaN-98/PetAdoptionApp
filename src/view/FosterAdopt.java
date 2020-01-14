package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import connection.ConnectionMake;
import control.CatOp;
import control.DogOp;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FosterAdopt extends JFrame {
private static Connection conn;
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField nameTF;
	static FosterAdopt frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FosterAdopt fa=new FosterAdopt();
		fa.NewScreen();
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FosterAdopt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FosterAdopt() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 102));
		panel.setBounds(0, 0, 584, 75);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("FOSTER / ADOPT");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		//lblLogin.setBackground(Color.WHITE);
		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(0, 75, 584, 386);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBasedOnCatdogs = new JLabel("based on cat/dog's ID*");
		lblBasedOnCatdogs.setForeground(new Color(100, 149, 237));
		lblBasedOnCatdogs.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblBasedOnCatdogs.setBounds(347, 70, 205, 30);
		panel_1.add(lblBasedOnCatdogs);
		
		JLabel lblNewLabel_1 = new JLabel("click to see picture");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setBounds(347, 54, 227, 23);
		panel_1.add(lblNewLabel_1);
		
		idTF = new JTextField();
		idTF.setBounds(40, 50, 140, 31);
		panel_1.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblSearchCatBy = new JLabel("Choose cat/dog's ID:");
		lblSearchCatBy.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblSearchCatBy.setForeground(new Color(128, 0, 0));
		lblSearchCatBy.setBounds(40, 21, 160, 30);
		panel_1.add(lblSearchCatBy);
		
		JLabel lblNewLabel = new JLabel("Choose cat/dog's name:");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblNewLabel.setBounds(40, 101, 215, 31);
		panel_1.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(40, 132, 140, 31);
		panel_1.add(nameTF);
		
		JLabel lblSearchFA = new JLabel("Choose to foster or to adopt:");
		lblSearchFA.setForeground(new Color(128, 0, 0));
		lblSearchFA.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblSearchFA.setBounds(40, 233, 205, 30);
		panel_1.add(lblSearchFA);
		
		JRadioButton rdbtnCat = new JRadioButton("cat");
		rdbtnCat.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnCat.setBackground(new Color(255, 192, 203));
		rdbtnCat.setForeground(new Color(0, 0, 0));
		rdbtnCat.setBounds(97, 189, 80, 23);
		panel_1.add(rdbtnCat);
		
		JRadioButton rdbtnDog = new JRadioButton("dog");
		rdbtnDog.setForeground(Color.BLACK);
		rdbtnDog.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnDog.setBackground(new Color(255, 192, 203));
		rdbtnDog.setBounds(179, 189, 80, 23);
		panel_1.add(rdbtnDog);
		

		JLabel label = new JLabel("");
		label.setBounds(347, 111, 174, 123);
		panel_1.add(label);

		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			     PreparedStatement stmt = null;
		
		ResultSet rs;
		try {

			
			conn = ConnectionMake.getConnection();
			int idd=Integer.parseInt(idTF.getText());
			  String sql ="SELECT image FROM cats where catId='"+idd+"' ";
			  if (rdbtnDog.isSelected()){sql = "SELECT image FROM dogs where dogId='"+idd+"' ";}
              PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
              rs=st.executeQuery();
			
			if(rs.next()) {
				byte[] img= rs.getBytes("image");
				ImageIcon image=new ImageIcon(img);
				Image im=image.getImage();
				Image myImg=im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage=new ImageIcon(myImg);
				label.setIcon(newImage);
			}
		}catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot find image");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		}	
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\animal-prints.png"));
		btnNewButton.setBounds(337, 54, 205, 46);
		panel_1.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnBack.setBounds(40, 352, 73, 23);
		panel_1.add(btnBack);
		
		JRadioButton rdbtnFoster = new JRadioButton("foster");
		rdbtnFoster.setForeground(Color.BLACK);
		rdbtnFoster.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnFoster.setBackground(new Color(255, 192, 203));
		rdbtnFoster.setBounds(40, 270, 80, 23);
		panel_1.add(rdbtnFoster);
		
		JRadioButton rdbtnAdopt = new JRadioButton("adopt");
		rdbtnAdopt.setForeground(Color.BLACK);
		rdbtnAdopt.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnAdopt.setBackground(new Color(255, 192, 203));
		rdbtnAdopt.setBounds(40, 309, 80, 23);
		panel_1.add(rdbtnAdopt);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs; PreparedStatement  st = null;
				try {

					conn = ConnectionMake.getConnection();
					int idd=Integer.parseInt(idTF.getText());
					String sql = null;
					if(rdbtnAdopt.isSelected()){
					   sql ="UPDATE cats\r\n" + 
					  		"SET Adopted=1\r\n" + 
					  		"WHERE catId='"+idd+"';";}
					else if(rdbtnFoster.isSelected()){
						  sql ="UPDATE cats\r\n" + 
							  		"SET Foster=1\r\n" + 
							  		"WHERE catId='"+idd+"';";}
		              st = (PreparedStatement) conn.prepareStatement(sql);
		              rs=st.executeQuery();
					
				}catch (SQLException exc) {

					exc.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot find image");

				} finally {
					ConnectionMake.close(st);
					ConnectionMake.close(conn);
				}
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		button.setBounds(337, 245, 205, 110);
		panel_1.add(button);
				
		

		this.setLocationRelativeTo(null);
	}
}
