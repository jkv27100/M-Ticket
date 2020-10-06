import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;
public class profile extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txteid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile frame = new profile();
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
	
	public profile()  {
		mycon=DBconnection.connectiondb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1018, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(profile.class.getResource("/logo.png")));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(390, 0, 200, 95);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home h1=new home();
				h1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(profile.class.getResource("/back.jpg")));
		btnNewButton.setBounds(0, 0, 100, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 142, 1018, 591);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(294, 13, 497, 522);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(profile.class.getResource("/profile.jpg")));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(213, 13, 140, 120);
		panel_2.add(lblNewLabel_2);
		
		txtusername = new JTextField();
		txtusername.setForeground(Color.WHITE);
		txtusername.setBackground(Color.BLACK);
		txtusername.setHorizontalAlignment(SwingConstants.CENTER);
		txtusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtusername.setBounds(223, 145, 116, 22);
		panel_2.add(txtusername);
		txtusername.setColumns(10);
		
		
	
		
		
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailId.setBounds(181, 210, 61, 22);
		panel_2.add(lblEmailId);
		
		txteid = new JTextField();
		txteid.setFont(new Font("Tahoma", Font.BOLD, 15));
		txteid.setForeground(Color.WHITE);
		txteid.setBackground(Color.BLACK);
		txteid.setBounds(181, 234, 286, 38);
		panel_2.add(txteid);
		txteid.setColumns(10);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset_pwd p=new reset_pwd();
				p.setVisible(true);
				dispose();
				
			}
		});
		btnChangePassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setBackground(Color.BLACK);
		btnChangePassword.setBounds(181, 285, 223, 38);
		panel_2.add(btnChangePassword);
		
		JButton btnBookingHistory = new JButton("Booking history");
		btnBookingHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					BookHistory b=new BookHistory();
					b.setVisible(true);
					dispose();
				} catch (SQLException | NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBookingHistory.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnBookingHistory.setForeground(Color.WHITE);
		btnBookingHistory.setBackground(Color.BLACK);
		btnBookingHistory.setBounds(181, 336, 223, 38);
		panel_2.add(btnBookingHistory);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home h=new home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(profile.class.getResource("/homeb.jpg")));
		btnNewButton_1.setBounds(199, 469, 60, 50);
		panel_2.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="update user_info set user_status=? where user_status=?";
				try {
					PreparedStatement p=mycon.prepareStatement(sql);
					p.setString(1,"deactive");
					p.setString(2,"active");
					p.executeUpdate();
					dispose();
					Loginframe.main(null);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		button_2.setIcon(new ImageIcon(profile.class.getResource("/logout.jpg")));
		button_2.setBounds(380, 469, 60, 50);
		panel_2.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(profile.class.getResource("/cp.jpg")));
		label.setBounds(401, 285, 63, 38);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(profile.class.getResource("/book.jpg")));
		label_1.setBounds(401, 336, 63, 38);
		panel_2.add(label_1);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from user_info where user_status=?";
				try {
					PreparedStatement ps=mycon.prepareStatement(sql);
					ps.setString(1, "active");
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						txtusername.setText(rs.getString("first_name"));
						txteid.setText(rs.getString("email_id"));
					}
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(256, 387, 97, 48);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(profile.class.getResource("/login_img.png")));
		lblNewLabel_1.setBounds(0, 0, 1018, 591);
		panel_1.add(lblNewLabel_1);
		
		
	}
}
