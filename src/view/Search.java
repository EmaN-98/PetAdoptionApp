package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectionMake;
import control.UserOp;
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

public class Search extends JFrame {
	//private static Connection conn;
	//Statement stmt = null;
	private JPanel contentPane;
	//private JTextField jtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Search s=new Search();
		s.NewScreen();
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Search() {
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
		
		JLabel lblLogin = new JLabel("SEARCH");
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
		
		JLabel lblAreYouSearching = new JLabel("Are you searching for a dog or a cat? ^.^");
		lblAreYouSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSearching.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblAreYouSearching.setBounds(45, 11, 500, 55);
		panel_1.add(lblAreYouSearching);
		
		JButton btnDog = new JButton("DOG");
		btnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DogSearch nw=new DogSearch();
				nw.NewScreen();}
		});
		btnDog.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnDog.setBounds(55, 259, 120, 33);
		panel_1.add(btnDog);
		
		
		
		/*JLabel labell = new JLabel("New label");
		labell.setBounds(206, 258, 160, 106);
		panel_1.add(labell);
		
		jtf = new JTextField();
		jtf.setBounds(431, 301, 86, 20);
		panel_1.add(jtf);
		jtf.setColumns(10);*/
		
		JButton btnCat = new JButton("CAT");
		btnCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatSearch nw=new CatSearch();
				nw.NewScreen();}
		});
				/*try {
				
				
				}
				 catch (SQLException exc) {

						exc.printStackTrace();
						JOptionPane.showMessageDialog(null, "Sorry, NO image to display");

					} finally {
						ConnectionMake.close(stmt);
						ConnectionMake.close(conn);
					}
			}
		
		});*/
		btnCat.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnCat.setBounds(410, 259, 120, 33);
		panel_1.add(btnCat);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\22215-dog-icon.png"));
		label.setBounds(45, 97, 160, 151);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\22221-cat-icon.png"));
		label_1.setBounds(404, 97, 141, 151);
		panel_1.add(label_1);
		
		
		
		this.setLocationRelativeTo(null);
	}
}
