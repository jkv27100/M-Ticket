import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class home extends JFrame {

	private JPanel contentPane;
	//JLabel slide;
	Timer tm;
	int i=1;
	String[] list= {"/s1.jpg","/s2.jpg","/s3.jpg","/s4.jpg","/s5.jpg"};
	private JTextField txtRating;
	private JTextField txtRating_1;
	private JTextField txtRatng;
	private JTextField txtRating_2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100,1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(Color.BLACK);
		panel_header.setBounds(0, 0, 1018, 113);
		contentPane.add(panel_header);
		panel_header.setLayout(null);
		
		JLabel label_logo = new JLabel("");
		label_logo.setIcon(new ImageIcon(home.class.getResource("/logo.png")));
		label_logo.setBounds(392, 13, 203, 87);
		panel_header.add(label_logo);
		
		JButton btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(home.class.getResource("/sign.jpg")));
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup_form s2=new Signup_form();
				s2.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignUp.setBounds(885, 13, 100, 35);
		panel_header.add(btnSignUp);
		
		JButton btnProfile = new JButton("");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profile p1=new profile();
				p1.setVisible(true);
				dispose();
				
			}
		});
		btnProfile.setIcon(new ImageIcon(home.class.getResource("/pro.jpg")));
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBackground(Color.BLACK);
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProfile.setBounds(12, 13, 50, 35);
		panel_header.add(btnProfile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 113, 1018, 620);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTicket bt=new BookTicket();
				bt.setVisible(true);
				dispose();
			}
		});
		button.setBackground(Color.BLACK);
		button.setIcon(new ImageIcon(home.class.getResource("/booknow.jpg")));
		button.setBounds(388, 365, 250, 65);
		panel_1.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1006, 265);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/img1.jpg")));
		lblNewLabel.setBounds(0, 0, 220, 220);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(home.class.getResource("/img2.jpg")));
		label.setBounds(232, 0, 220, 220);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(home.class.getResource("/img3.jpg")));
		label_1.setBounds(470, 0, 220, 220);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(home.class.getResource("/img4.jpg")));
		label_2.setBounds(713, 0, 220, 220);
		panel.add(label_2);
		
		txtRating = new JTextField();
		txtRating.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating.setBackground(Color.BLACK);
		txtRating.setForeground(Color.WHITE);
		txtRating.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtRating.setText("Rating 9.0");
		txtRating.setBounds(44, 233, 97, 22);
		panel.add(txtRating);
		txtRating.setColumns(10);
		
		txtRating_1 = new JTextField();
		txtRating_1.setForeground(Color.WHITE);
		txtRating_1.setBackground(Color.BLACK);
		txtRating_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtRating_1.setText("Rating 8.0");
		txtRating_1.setBounds(280, 233, 97, 22);
		panel.add(txtRating_1);
		txtRating_1.setColumns(10);
		
		txtRatng = new JTextField();
		txtRatng.setForeground(Color.WHITE);
		txtRatng.setBackground(Color.BLACK);
		txtRatng.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtRatng.setText("Ratng 8.5");
		txtRatng.setBounds(517, 233, 86, 22);
		panel.add(txtRatng);
		txtRatng.setColumns(10);
		
		txtRating_2 = new JTextField();
		txtRating_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating_2.setForeground(Color.WHITE);
		txtRating_2.setBackground(Color.BLACK);
		txtRating_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtRating_2.setText("Rating 8.5");
		txtRating_2.setBounds(764, 233, 86, 22);
		panel.add(txtRating_2);
		txtRating_2.setColumns(10);
		
		JLabel imgsec = new JLabel("");
		imgsec.setBackground(Color.BLACK);
		imgsec.setIcon(new ImageIcon(home.class.getResource("/login_img.png")));
		imgsec.setBounds(0, 0, 1006, 608);
		panel_1.add(imgsec);
		
		
		
			
	}
}


