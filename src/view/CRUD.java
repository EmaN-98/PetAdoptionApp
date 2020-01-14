package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectionMake;
import control.CRUDop;
import control.UserOp;
import model.Cat;
import model.Dog;
import model.User;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class CRUD extends JFrame {
	static CRUD frame;
	//private static Connection conn;
	//Statement stmt = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	//private JTextField jtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CRUD c=new CRUD();
		c.NewScreen();
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CRUD() {
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
		
		JLabel lblLogin = new JLabel("CRUD");
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Foster");
		chckbxNewCheckBox.setBackground(Color.PINK);
		chckbxNewCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox.setBounds(10, 235, 97, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxAdopted = new JCheckBox("Adopted");
		chckbxAdopted.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		chckbxAdopted.setBackground(Color.PINK);
		chckbxAdopted.setBounds(130, 237, 97, 23);
		panel_1.add(chckbxAdopted);
		
		JRadioButton rdbtnCat = new JRadioButton("CAT");
		rdbtnCat.setBackground(Color.PINK);
		rdbtnCat.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		rdbtnCat.setBounds(493, 9, 66, 33);
		panel_1.add(rdbtnCat);
		
		JRadioButton rdbtnDog = new JRadioButton("DOG");
		rdbtnDog.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		rdbtnDog.setBackground(Color.PINK);
		rdbtnDog.setBounds(493, 48, 66, 33);
		panel_1.add(rdbtnDog);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					boolean Foster = false,Adopted = false;
				     String Name = textField.getText();
				     String Breed = textField_2.getText();
				     int Age = Integer.parseInt(textField_1.getText());
				     String Personality = textField_3.getText();
				       String Past = textField_4.getText();
				         String FurSize = textField_5.getText();
				     String EnvironmentNeeded = textField_6.getText();
				     if (chckbxNewCheckBox.isSelected()) { Foster= true;}
				     if (chckbxAdopted.isSelected()) { Adopted= true;}
				     try {
				    	 if(rdbtnCat.isSelected()) {
				    	 Cat c1=new Cat(Name,Breed,Age,Personality,Past,FurSize,EnvironmentNeeded,Foster,Adopted); 
				    	 
				    	 CRUDop.insertCat(c1);
				    	 }
				    	 else 
					    	 if(rdbtnDog.isSelected()) {
						    	 Dog d1=new Dog(Name,Breed,Age,Personality,Past,FurSize,EnvironmentNeeded,Foster,Adopted); 
						    	 
						    	 CRUDop.insertDog(d1);
						    	 }
					    	 else
				    	 JOptionPane.showMessageDialog(null, "Select either cat or dog ");
				    	 
				    	// frame.setVisible(false);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					System.out.println("cat/dog cannot be added to db");
					}
						
				}
			});
	
		
		btnInsert.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnInsert.setBounds(267, 195, 120, 33);
		panel_1.add(btnInsert);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\22221-cat-icon.png"));
		label_1.setBounds(394, 235, 141, 151);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 36, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(243, 36, 86, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 92, 470, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 148, 86, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(130, 148, 86, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(243, 148, 237, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 204, 237, 20);
		panel_1.add(textField_7);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\22215-dog-icon.png"));
		label.setBounds(463, 224, 160, 151);
		panel_1.add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(10, 11, 86, 14);
		panel_1.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblAge.setBounds(130, 11, 86, 14);
		panel_1.add(lblAge);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setHorizontalAlignment(SwingConstants.CENTER);
		lblBreed.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblBreed.setBounds(243, 11, 86, 14);
		panel_1.add(lblBreed);
		
		JLabel lblPersonality = new JLabel("Personality");
		lblPersonality.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonality.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblPersonality.setBounds(10, 67, 86, 14);
		panel_1.add(lblPersonality);
		
		JLabel lblPast = new JLabel("Past");
		lblPast.setHorizontalAlignment(SwingConstants.CENTER);
		lblPast.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblPast.setBounds(10, 123, 86, 14);
		panel_1.add(lblPast);
		
		JLabel lblFursize = new JLabel("Fur/Size");
		lblFursize.setHorizontalAlignment(SwingConstants.CENTER);
		lblFursize.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblFursize.setBounds(130, 123, 86, 14);
		panel_1.add(lblFursize);
		
		JLabel lblEnvironmentNeeded = new JLabel("Environment Needed");
		lblEnvironmentNeeded.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnvironmentNeeded.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblEnvironmentNeeded.setBounds(243, 125, 185, 14);
		panel_1.add(lblEnvironmentNeeded);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblPicture.setBounds(10, 179, 86, 14);
		panel_1.add(lblPicture);
		
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idd=Integer.parseInt(textField_9.getText());
				
			
				boolean Foster = false,Adopted = false;
			     String Name = textField.getText();
			     String Breed = textField_2.getText();
			     int Age = Integer.parseInt(textField_1.getText());
			     String Personality = textField_3.getText();
			       String Past = textField_4.getText();
			         String FurSize = textField_5.getText();
			     String EnvironmentNeeded = textField_6.getText();
			     if (chckbxNewCheckBox.isSelected()) { Foster= true;}
			     if (chckbxAdopted.isSelected()) { Adopted= true;}
			     try {
			    	 if(rdbtnCat.isSelected()) {
			    		 CRUDop.deleteCat(idd);
			    		 Cat c1=new Cat(Name,Breed,Age,Personality,Past,FurSize,EnvironmentNeeded,Foster,Adopted); 
				    	 
				    	 CRUDop.insertCat(c1);
			    	// CRUDop.insertCat(Name,Breed,Age,Personality,Past,Fur,EnvironmentNeeded,Foster,Adopted);
			    	 }
			    	 else 
				    	 if(rdbtnDog.isSelected()) {
				    		 CRUDop.deleteDog(idd);
					    	 Dog d1=new Dog(Name,Breed,Age,Personality,Past,FurSize,EnvironmentNeeded,Foster,Adopted); 
					    	 
					    	 CRUDop.insertDog(d1);
					    	 ///CRUDop.editDog(idCat,Name,Breed,Age,Personality,Past,Fur,EnvironmentNeeded,Foster,Adopted);
					    	 }
				    	 else
			    	 JOptionPane.showMessageDialog(null, "Select either cat or dog ");
			    	 
			    	// frame.setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				System.out.println("cat/dog cannot be edited in db");
				}
			}
		});
		btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnUpdate.setBounds(267, 280, 120, 33);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idDel=Integer.parseInt(textField_8.getText());
				 try {
			    	 if(rdbtnCat.isSelected()) {
			  //  	 Cat c1=new Cat(Name,Breed,Age,Personality,Past,Fur,EnvironmentNeeded,Foster,Adopted); 
			    	 
			  //  	 CRUDop.insertCat(c1);
			    	 CRUDop.deleteCat(idDel);
			    	 }
			    	 else 
				    	 if(rdbtnDog.isSelected()) {
//					    	 Dog d1=new Dog(Name,Breed,Age,Personality,Past,Size,EnvironmentNeeded,Foster,Adopted); 
					    	 
					    	 CRUDop.deleteDog(idDel);
					    	 }
				    	 else
			    	 JOptionPane.showMessageDialog(null, "Select either cat or dog ");
			    	 
			    	// frame.setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				System.out.println("cat/dog cannot be deleted from db");
				}
				
			}
		});
		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnDelete.setBounds(267, 330, 120, 33);
		panel_1.add(btnDelete);
		
		textField_8 = new JTextField();
		textField_8.setBounds(181, 339, 66, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblInsertIdTo = new JLabel("Insert ID to delete:");
		lblInsertIdTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertIdTo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblInsertIdTo.setBounds(10, 342, 161, 14);
		panel_1.add(lblInsertIdTo);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(0, 363, 89, 23);
		panel_1.add(btnNewButton);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(181, 289, 66, 20);
		panel_1.add(textField_9);
		
		JLabel lblInsertIdTo_1 = new JLabel("Insert ID to update:");
		lblInsertIdTo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertIdTo_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblInsertIdTo_1.setBounds(10, 292, 161, 14);
		panel_1.add(lblInsertIdTo_1);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
