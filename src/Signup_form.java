import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup_form extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txteid;
	private JTextField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_form frame = new Signup_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection mycon=null;
	String Age;
	String loc;
	private JTextField txtphno;
	public Signup_form() {
		mycon=DBconnection.connectiondb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(Color.BLACK);
		panel_header.setBounds(0, 0, 1018, 144);
		contentPane.add(panel_header);
		panel_header.setLayout(null);
		
		JLabel label_logo = new JLabel("");
		label_logo.setIcon(new ImageIcon(Signup_form.class.getResource("/logo.png")));
		label_logo.setBounds(384, 13, 209, 118);
		panel_header.add(label_logo);
		
		JPanel panel_img = new JPanel();
		panel_img.setBackground(Color.BLACK);
		panel_img.setBounds(0, 143, 1018, 590);
		contentPane.add(panel_img);
		panel_img.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 10f));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(432, 13, 115, 70);
		panel_img.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(114, 96, 792, 424);
		panel_img.add(panel);
		panel.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(390, 224, 121, 26);
		panel.add(lblPhoneNumber);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(48, 46, 133, 41);
		panel.add(lblFirstName);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtFname.setBounds(48, 83, 289, 41);
		panel.add(txtFname);
		txtFname.setColumns(10);
		String fname=txtFname.getText();
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblLastName.setBounds(390, 53, 96, 26);
		panel.add(lblLastName);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLname.setBounds(390, 83, 238, 41);
		panel.add(txtLname);
		txtLname.setColumns(10);
		String lname=txtLname.getText();
		
		JLabel lblUsername = new JLabel("EMAIL ID");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblUsername.setBounds(48, 141, 88, 26);
		panel.add(lblUsername);
		
		txteid = new JTextField();
		txteid.setFont(new Font("Tahoma", Font.BOLD, 15));
		txteid.setBounds(48, 168, 289, 41);
		panel.add(txteid);
		txteid.setColumns(10);
		String email=txteid.getText();
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblPassword.setBounds(48, 228, 86, 19);
		panel.add(lblPassword);
		
		txtpwd = new JTextField();
		txtpwd.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpwd.setBounds(48, 260, 289, 41);
		panel.add(txtpwd);
		txtpwd.setColumns(10);
		String pwd=txtpwd.getText();
		
		JComboBox location = new JComboBox();
		location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 loc=location.getSelectedItem().toString();
				
			}
		});
		location.setBackground(Color.BLACK);
		location.setForeground(Color.WHITE);
		location.setFont(new Font("Tahoma", Font.BOLD, 13));
		location.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "MANGALORE", "KANNUR"}));
		location.setSelectedIndex(0);
		location.setBounds(390, 177, 133, 26);
		panel.add(location);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblLocation.setBounds(390, 148, 88, 16);
		panel.add(lblLocation);
		
		JComboBox age = new JComboBox();
		age.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				  Age=age.getSelectedItem().toString();
			}
		});
		age.setForeground(Color.WHITE);
		age.setBackground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD, 13));
		age.setModel(new DefaultComboBoxModel(new String[] {"SELECT AGE", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		age.setBounds(538, 177, 121, 26);
		panel.add(age);
		
		txtphno = new JTextField();
		txtphno.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtphno.setColumns(10);
		txtphno.setBounds(390, 260, 289, 41);
		panel.add(txtphno);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree with terms and conditions");
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxNewCheckBox.setBounds(411, 329, 260, 25);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblAlreadyAUsertry = new JLabel("Already a user?Try");
		lblAlreadyAUsertry.setForeground(Color.WHITE);
		lblAlreadyAUsertry.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlreadyAUsertry.setBounds(95, 333, 145, 16);
		panel.add(lblAlreadyAUsertry);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Signup_form.class.getResource("/login.jpg")));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   //contentPane.setVisible(false);  
				     dispose();
				    Loginframe.main(null);	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(140, 363, 88, 35);
		panel.add(btnNewButton);
		
		JButton btnCreateAccount = new JButton("");
		btnCreateAccount.setIcon(new ImageIcon(Signup_form.class.getResource("/crr.jpg")));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=null;
				PreparedStatement ps=null;
				String sql="INSERT INTO user_info(user_id,password,email_id,mobile_number,location,first_name,last_name,age) VALUES (?,?,?,?,?,?,?,?)";
				try {
					
					
					ps=mycon.prepareStatement(sql);
					ps.setString(1,null);
					ps.setString(2,txtpwd.getText());
					ps.setString(3,txteid.getText());
					ps.setString(4,txtphno.getText());
					ps.setString(5,location.getSelectedItem().toString());
					ps.setString(6,txtFname.getText());
					ps.setString(7,txtLname.getText());
					ps.setString(8,age.getSelectedItem().toString());
					ps.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
				JOptionPane.showMessageDialog(panel, "Account Created Successfully!");
				 dispose();
				 Loginframe.main(null);
			}
		});
		btnCreateAccount.setBackground(Color.BLACK);
		btnCreateAccount.setForeground(Color.BLACK);
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreateAccount.setBounds(475, 363, 100, 35);
		panel.add(btnCreateAccount);
		JLabel label_img = new JLabel("");
		label_img.setIcon(new ImageIcon(Signup_form.class.getResource("/login_img.png")));
		label_img.setBounds(0, 0, 1006, 578);
		panel_img.add(label_img);
	}
}
