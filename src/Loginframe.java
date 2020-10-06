import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Loginframe {

	private JFrame login;
	private JTextField text_eid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginframe window = new Loginframe();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}
	
	
	Connection mycon=null;
	
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Loginframe() throws SQLException {
		initialize();
		mycon=DBconnection.connectiondb();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	
	private void initialize() throws SQLException {
		
		login = new JFrame();
		login.getContentPane().setBackground(Color.WHITE);
		login.setBackground(Color.WHITE);
		login.setTitle("M-TICKET  Book movie tickets");
		login.setForeground(Color.WHITE);
		
		login.setBounds(100, 100, 1024,768);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setResizable(false);
		login.getContentPane().setLayout(null);
		
		JPanel panel_img = new JPanel();
		panel_img.setBounds(0, 141, 1006, 580);
		login.getContentPane().add(panel_img);
		panel_img.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(278, 44, 464, 389);
		panel_img.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 12f));
		lblNewLabel.setBounds(178, 13, 102, 84);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel_1.setBounds(69, 180, 80, 35);
		panel.add(lblNewLabel_1);
		
		text_eid = new JTextField();
		text_eid.setFont(new Font("Tahoma", Font.BOLD, 15));
		text_eid.setBounds(179, 180, 273, 35);
		panel.add(text_eid);
		text_eid.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel_2.setBounds(69, 228, 80, 35);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(178, 228, 274, 35);
		panel.add(passwordField);
	
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Loginframe.class.getResource("/login.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="SELECT * FROM user_info WHERE password=? and  email_id=?";
				try
				{
					ResultSet rs=null;
					PreparedStatement ps=mycon.prepareStatement(sql);
					ps.setString(2,text_eid.getText());
					ps.setString(1,passwordField.getText());
					rs=ps.executeQuery();
					
					boolean b=rs.next();
					System.out.println("rs="+b);
					
				
					if(b)
					{
						JOptionPane.showMessageDialog(null, "Login Successfull");
						String query="UPDATE user_info SET user_status=? WHERE email_id=?";
						PreparedStatement p=mycon.prepareStatement(query);
						p.setString(1,"active");
						p.setString(2,text_eid.getText());
						p.executeUpdate();
						home h=new home();
						h.setVisible(true);
						login.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid username or password");

					}
				}
				
				catch(Exception er)
				{
					er.printStackTrace();
				}
							
							
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(183, 307, 100, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Loginframe.class.getResource("/sign.jpg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup_form f1=new Signup_form();
				f1.setVisible(true);
				login.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(318, 307, 93, 28);
		panel.add(btnNewButton_1);
		
		JLabel img_label = new JLabel("");
		img_label.setIcon(new ImageIcon(Loginframe.class.getResource("/login_img.png")));
		img_label.setBounds(0, 0, 1006, 580);
		panel_img.add(img_label);
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(Color.BLACK);
		panel_header.setBounds(0, 0, 1006, 144);
		login.getContentPane().add(panel_header);
		panel_header.setLayout(null);
		
		JLabel label_logo = new JLabel("");
		label_logo.setIcon(new ImageIcon(Loginframe.class.getResource("/logo.png")));
		label_logo.setBounds(407, 0, 219, 157);
		panel_header.add(label_logo);
		
		
		
	}
	
}
