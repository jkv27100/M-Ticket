import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusr;
	private JTextField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
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
	public Admin_Login() {
		mycon=DBconnection.connectiondb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024,768);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1006, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Admin_Login.class.getResource("/logo.png")));
		label.setBounds(394, 13, 218, 96);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 107, 1006, 614);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(442, 111, 136, 120);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin_Login.class.getResource("/profile.jpg")));
		label_1.setBounds(0, 0, 136, 120);
		panel_2.add(label_1);
		
		txtpwd = new JTextField("password");
		txtpwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpwd.setText("");
			}
		});
		txtpwd.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpwd.setColumns(10);
		txtpwd.setBounds(336, 342, 361, 41);
		panel_1.add(txtpwd);
		
		txtusr = new JTextField("username");
		txtusr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtusr.setText("");
			}
		});
		txtusr.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtusr.setBounds(336, 273, 361, 41);
		panel_1.add(txtusr);
		txtusr.setColumns(10);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setBounds(407, 35, 225, 63);
		panel_1.add(lblAdminLogin);
		
		JButton btnSignIn = new JButton("");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ResultSet rs=null;
				PreparedStatement ps=null;
				String sql="call getAdmin()";
				try
				{
					ps=mycon.prepareStatement(sql);
					rs=ps.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Welcome admin");
						admin_page p=new admin_page();
						p.setVisible(true);
						dispose();
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnSignIn.setBackground(Color.BLACK);
		btnSignIn.setIcon(new ImageIcon(Admin_Login.class.getResource("/login.jpg")));
		btnSignIn.setBounds(466, 406, 122, 47);
		panel_1.add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin_Login.class.getResource("/login_img.png")));
		lblNewLabel.setBounds(0, 5, 1006, 609);
		panel_1.add(lblNewLabel);
	}
}
