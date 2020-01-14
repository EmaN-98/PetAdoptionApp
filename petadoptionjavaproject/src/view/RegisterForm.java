package view;
import model.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.UserOp;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RegisterForm extends JFrame {

    
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	
	static RegisterForm frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 102));
		panel.setBounds(0, 0, 584, 75);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("Register");
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
		
		JLabel lblUsername = new JLabel("Name");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 51));
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblUsername.setBounds(100, 0, 150, 40);
		panel_1.add(lblUsername);
		
		JLabel label = new JLabel("Username");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(153, 0, 51));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label.setBounds(100, 99, 150, 40);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(153, 0, 51));
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_1.setBounds(100, 150, 150, 35);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(153, 0, 51));
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_2.setBounds(100, 174, 150, 35);
		panel_1.add(label_2);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(new Color(204, 204, 204));
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(338, 5, 200, 35);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setForeground(new Color(204, 204, 204));
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(338, 104, 200, 35);
		panel_1.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(204, 204, 204));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(338, 152, 200, 35);
		panel_1.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			     String username = textField_1.getText();
			     String password = passwordField.getText();
			     String email = textField_2.getText();
			     String name = textField.getText();
			     
			     try {
			    	 User u1=new User(name,email,username,password); 
			    	 
			    	 UserOp.insertUser(u1);
			    	 JOptionPane.showMessageDialog(null, "Your register has been a success :) \n You can now use the app ");
			    	 
			    	 frame.setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				System.out.println("userul nu poate fi inregistrat");
				}
					
			}
		});
		btnRegister.setForeground(new Color(153, 0, 51));
		btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnRegister.setBounds(240, 220, 120, 35);
		panel_1.add(btnRegister);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(153, 0, 51));
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblEmail.setBounds(100, 51, 150, 40);
		panel_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setForeground(new Color(204, 204, 204));
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(338, 53, 200, 35);
		panel_1.add(textField_2);
		
		
		
		this.setLocationRelativeTo(null);
		

	}

}
