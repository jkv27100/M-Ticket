import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.sql.*;
public class reset_pwd extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpwd;
	private JTextField txtnpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reset_pwd frame = new reset_pwd();
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
	Connection mycon=null;
	public reset_pwd() {
		mycon=DBconnection.connectiondb();
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1006, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(277, 250, 446, 313);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current password");
		lblCurrentPassword.setForeground(Color.WHITE);
		lblCurrentPassword.setBackground(Color.BLACK);
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentPassword.setBounds(58, 70, 170, 25);
		panel_2.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setBackground(Color.BLACK);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(58, 170, 133, 30);
		panel_2.add(lblNewPassword);
		
		txtcpwd = new JTextField();
		txtcpwd.setBounds(57, 107, 364, 43);
		panel_2.add(txtcpwd);
		txtcpwd.setColumns(10);
		
		txtnpwd = new JTextField();
		txtnpwd.setBounds(58, 213, 363, 43);
		panel_2.add(txtnpwd);
		txtnpwd.setColumns(10);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="update user_info set password=? where user_status=?";
				try {
					PreparedStatement p=mycon.prepareStatement(sql);
					p.setString(1,txtnpwd.getText());
					p.setString(2,"active");
					p.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "password changed");
					
				}catch(Exception e)
				
				{
					e.printStackTrace();
				}
				
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setBackground(Color.BLACK);
		btnChangePassword.setBounds(251, 269, 170, 44);
		panel_2.add(btnChangePassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1019, 141);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(reset_pwd.class.getResource("/logo.png")));		
		lblNewLabel_1.setBounds(387, 26, 200, 115);
		panel_1.add(lblNewLabel_1);
		
		JButton btn_back = new JButton("");
		btn_back.setIcon(new ImageIcon(reset_pwd.class.getResource("/back.jpg")));
		btn_back.setForeground(Color.WHITE);
		btn_back.setBackground(Color.WHITE);
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profile p=new profile();
				p.setVisible(true);
				dispose();
		
			}
		});
		btn_back.setBounds(0, 0, 100, 35);
		panel_1.add(btn_back);		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(reset_pwd.class.getResource("/login_img.png")));
		
		lblNewLabel.setBounds(0, 141, 1019, 580);
		panel.add(lblNewLabel);
	}
}
