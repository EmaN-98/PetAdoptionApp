package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UserOp;
import model.User;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginForm log=new LoginForm();
		log.NewScreen();
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginForm() {
		initialize();
	}
	

	private void initialize() {
		
	
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
		
		JLabel lblLogin = new JLabel("LOGIN");
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
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 51));
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblUsername.setBounds(100, 70, 150, 40);
		panel_1.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsername.setToolTipText("");
		txtUsername.setForeground(new Color(204, 204, 204));
		txtUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtUsername.setBounds(313, 70, 200, 35);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(153, 0, 51));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel.setBounds(100, 170, 150, 35);
		panel_1.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(204, 204, 204));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(313, 170, 200, 35);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String username = txtUsername.getText();
			     String password = passwordField.getText();
			     boolean exist=UserOp.findLogin(username,password);
			     if(!exist) {JOptionPane.showMessageDialog(null, "Something is wrong...Please check again your username & password! ");
		    	 }else {JOptionPane.showMessageDialog(null, "Your login was a success :)");}
			     
			}
		});
		btnNewButton.setForeground(new Color(153, 0, 51));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		btnNewButton.setBounds(220, 259, 99, 35);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create new account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.setVisible(false);
				RegisterForm nw=new RegisterForm();
				nw.NewScreen();
			}
		});
		btnNewButton_1.setForeground(new Color(153, 0, 51));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 320, 215, 23);
		panel_1.add(btnNewButton_1);
		
		JButton button = new JButton("Login");
		button.setForeground(new Color(153, 0, 51));
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		button.setBounds(220, 259, 99, 35);
		panel_1.add(button);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
