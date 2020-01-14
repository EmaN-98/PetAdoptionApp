package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.CatOp;
import control.DogOp;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DogSearch extends JFrame {

	private JPanel contentPane;
	private JTextField breedTF;
	private JTextField textField;
	static DogSearch frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DogSearch ds=new DogSearch();
		ds.NewScreen();
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DogSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DogSearch() {
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
		
		JLabel lblLogin = new JLabel("DOG SEARCH");
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
		
		JLabel lblNewLabel_1 = new JLabel("click to see the results of your search:");
		lblNewLabel_1.setBounds(357, 0, 217, 23);
		panel_1.add(lblNewLabel_1);
		
		breedTF = new JTextField();
		breedTF.setBounds(40, 50, 140, 31);
		panel_1.add(breedTF);
		breedTF.setColumns(10);
		
		JLabel lblSearchCatBy = new JLabel("Search dog by breed:");
		lblSearchCatBy.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblSearchCatBy.setForeground(new Color(128, 0, 0));
		lblSearchCatBy.setBounds(40, 21, 160, 30);
		panel_1.add(lblSearchCatBy);
		
		JLabel lblNewLabel = new JLabel("Search dog by ~age(months):");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblNewLabel.setBounds(40, 101, 215, 31);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(40, 132, 140, 31);
		panel_1.add(textField);
		
		JLabel lblSearchCatBy_1 = new JLabel("Search dog by personality:");
		lblSearchCatBy_1.setForeground(new Color(128, 0, 0));
		lblSearchCatBy_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblSearchCatBy_1.setBounds(40, 233, 205, 30);
		panel_1.add(lblSearchCatBy_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(" Social and Affectionate");
		chckbxNewCheckBox.setBackground(new Color(255, 192, 203));
		chckbxNewCheckBox.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxNewCheckBox.setBounds(40, 270, 205, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxActiveAndPlayful = new JCheckBox("Active and Playful");
		chckbxActiveAndPlayful.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxActiveAndPlayful.setBackground(new Color(255, 192, 203));
		chckbxActiveAndPlayful.setBounds(40, 297, 205, 23);
		panel_1.add(chckbxActiveAndPlayful);
		
		JCheckBox chckbxHighlyIntelligentwell = new JCheckBox("Highly Intelligent & well trained");
		chckbxHighlyIntelligentwell.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxHighlyIntelligentwell.setBackground(new Color(255, 192, 203));
		chckbxHighlyIntelligentwell.setBounds(40, 323, 205, 23);
		panel_1.add(chckbxHighlyIntelligentwell);
		
		JCheckBox chckbxLoveTheOutdoors = new JCheckBox("Love the Outdoors ");
		chckbxLoveTheOutdoors.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxLoveTheOutdoors.setBackground(new Color(255, 192, 203));
		chckbxLoveTheOutdoors.setBounds(40, 349, 205, 23);
		panel_1.add(chckbxLoveTheOutdoors);
		
		JCheckBox chckbxLoveTheIndoors = new JCheckBox("Love the Indoors ");
		chckbxLoveTheIndoors.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxLoveTheIndoors.setBackground(new Color(255, 192, 203));
		chckbxLoveTheIndoors.setBounds(290, 349, 205, 23);
		panel_1.add(chckbxLoveTheIndoors);
		
		JCheckBox chckbxRatherLazy = new JCheckBox("Rather lazy");
		chckbxRatherLazy.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxRatherLazy.setBackground(new Color(255, 192, 203));
		chckbxRatherLazy.setBounds(290, 297, 205, 23);
		panel_1.add(chckbxRatherLazy);
		
		JCheckBox chckbxMostlyIndependent = new JCheckBox("Mostly independent");
		chckbxMostlyIndependent.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxMostlyIndependent.setBackground(new Color(255, 192, 203));
		chckbxMostlyIndependent.setBounds(290, 323, 205, 23);
		panel_1.add(chckbxMostlyIndependent);
		
		JCheckBox chckbxCanManageBeing = new JCheckBox("Can manage being alone for longer periods");
		chckbxCanManageBeing.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		chckbxCanManageBeing.setBackground(new Color(255, 192, 203));
		chckbxCanManageBeing.setBounds(290, 270, 264, 23);
		panel_1.add(chckbxCanManageBeing);
		
		JLabel lblSize = new JLabel("Size? :)");
		lblSize.setForeground(new Color(128, 0, 0));
		lblSize.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblSize.setBounds(40, 184, 80, 30);
		panel_1.add(lblSize);
		
		JRadioButton rdbtnSize = new JRadioButton("small");
		rdbtnSize.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnSize.setBackground(new Color(255, 192, 203));
		rdbtnSize.setForeground(new Color(0, 0, 0));
		rdbtnSize.setBounds(97, 189, 80, 23);
		panel_1.add(rdbtnSize);
		
		JRadioButton rdbtnLessFur = new JRadioButton("big");
		rdbtnLessFur.setForeground(Color.BLACK);
		rdbtnLessFur.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnLessFur.setBackground(new Color(255, 192, 203));
		rdbtnLessFur.setBounds(261, 189, 80, 23);
		panel_1.add(rdbtnLessFur);
		
		JRadioButton rdbtnSizeM = new JRadioButton("medium");
		rdbtnSizeM.setForeground(Color.BLACK);
		rdbtnSizeM.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		rdbtnSizeM.setBackground(new Color(255, 192, 203));
		rdbtnSizeM.setBounds(179, 189, 80, 23);
		panel_1.add(rdbtnSizeM);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				 String Breed = breedTF.getText();
			     int Age = Integer.parseInt(textField.getText());
			     String Size=""; String Pers="";
			     if(rdbtnSize.isSelected()) {Size="small";}
			     else if(rdbtnSizeM.isSelected()) {Size="medium";}
			     else {Size="big";};
			     if(chckbxNewCheckBox.isSelected()) {Pers+="social and affectionate; ";}
			     else if(chckbxCanManageBeing.isSelected()) {Pers+="can manage being alone for longer periods; ";}
			     if(chckbxActiveAndPlayful.isSelected()) {Pers+="active and playful; ";}
			     else if(chckbxRatherLazy.isSelected()) {Pers+="rather lazy; ";}
			     if(chckbxHighlyIntelligentwell.isSelected()) {Pers+="highly intelligent and well trained; ";}
			     else if(chckbxMostlyIndependent.isSelected()) {Pers+="mostly independent; ";}
			     if(chckbxLoveTheOutdoors.isSelected()) {Pers+="love the outdoors; ";}
			     else if(chckbxLoveTheIndoors.isSelected()) {Pers+="love the indoors; ";}
			
			     
			     try {
			    	 //Cat c1=new User(name,email,username,password); 
			    	 
			    	DogOp.findByBreedAgeSizePers(Breed,Age,Size);
			    	// if(CatOp.findByBreedAndAge(Breed,Age)==true) {JOptionPane.showMessageDialog(null, "Your search is a success :) ");
			    	// }else {JOptionPane.showMessageDialog(null, "Oups! no kitty found :(");}
			    	 FosterAdopt nw=new FosterAdopt();
						nw.NewScreen();
			    	 frame.setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				System.out.println("we don't have any dog that matches your desires");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Ema ^_^\\Java\\PetAdoption\\22215-dog-icon.png"));
		btnNewButton.setBounds(369, 21, 205, 164);
		panel_1.add(btnNewButton);
		
		
		JLabel lblVs = new JLabel("vs");
		lblVs.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblVs.setBounds(259, 311, 25, 14);
		panel_1.add(lblVs);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnBack.setBounds(501, 352, 73, 23);
		panel_1.add(btnBack);
		

		this.setLocationRelativeTo(null);
	}
}
