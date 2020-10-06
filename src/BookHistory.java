import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class BookHistory extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtseat;
	private JTextField txtscreen;
	private JTextField txtshowtime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHistory frame = new BookHistory();
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
	Connection con=null;
	private JTextField txtname;
	private JTextField txtmovie;
	private JTextField txtticket;
	private JTextField txtamnt;
	public BookHistory() throws SQLException, NoSuchAlgorithmException {
		BlockChain blockChain = new BlockChain();
		con=DBconnection.connectiondb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100,1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1018, 144);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BookHistory.class.getResource("/logo.png")));
		label.setBounds(412, 13, 209, 118);
		panel.add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				profile p= new profile();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookHistory.class.getResource("/back.jpg")));
		btnNewButton.setBounds(0, 0, 100, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 143, 1006, 578);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtamnt = new JTextField();
		txtamnt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtamnt.setBounds(694, 209, 150, 47);
		panel_1.add(txtamnt);
		txtamnt.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(465, 140, 150, 130);
		panel_1.add(label_2);
		label_2.setIcon(new ImageIcon(BookHistory.class.getResource("/qrcode.jpg")));
		
		txtticket = new JTextField();
		txtticket.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtticket.setBounds(256, 343, 81, 34);
		panel_1.add(txtticket);
		txtticket.setColumns(10);
		
		JLabel lblNoOfTickets = new JLabel("No of tickets");
		lblNoOfTickets.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoOfTickets.setForeground(Color.WHITE);
		lblNoOfTickets.setBounds(256, 320, 122, 16);
		panel_1.add(lblNoOfTickets);
		
		txtmovie = new JTextField();
		txtmovie.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtmovie.setBounds(441, 283, 194, 37);
		panel_1.add(txtmovie);
		txtmovie.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtname.setBounds(436, 80, 225, 39);
		panel_1.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblTheaterName = new JLabel("Theater Name");
		lblTheaterName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTheaterName.setForeground(Color.WHITE);
		lblTheaterName.setBounds(441, 48, 163, 39);
		panel_1.add(lblTheaterName);
		
		txtshowtime = new JTextField();
		txtshowtime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtshowtime.setBounds(256, 179, 81, 30);
		panel_1.add(txtshowtime);
		txtshowtime.setColumns(10);
		
		JLabel lblShowTime = new JLabel("Show time");
		lblShowTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblShowTime.setForeground(Color.WHITE);
		lblShowTime.setBounds(256, 140, 109, 26);
		panel_1.add(lblShowTime);
		
		txtscreen = new JTextField();
		txtscreen.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtscreen.setBounds(256, 264, 81, 30);
		panel_1.add(txtscreen);
		txtscreen.setColumns(10);
		
		JLabel lblScreen_1 = new JLabel("Screen");
		lblScreen_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblScreen_1.setForeground(Color.WHITE);
		lblScreen_1.setBounds(256, 235, 81, 16);
		panel_1.add(lblScreen_1);
		
		txtseat = new JTextField();
		txtseat.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtseat.setBounds(256, 85, 81, 30);
		panel_1.add(txtseat);
		txtseat.setColumns(10);
		
		
		
		
		JLabel lblSeatNo = new JLabel("Seat No");
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeatNo.setForeground(Color.WHITE);
		lblSeatNo.setBounds(256, 48, 109, 39);
		panel_1.add(lblSeatNo);
		
		JButton btnShow = new JButton("show");
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(Color.BLACK);
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String sql="select * from book_history";
				String query="select * from user_info where user_status=?";
				try {
					Random r=new Random();
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,"active");
					ResultSet rq=ps.executeQuery();
					if(rq.next())
					{
						
						
					
					PreparedStatement p=con.prepareStatement(sql);
					ResultSet rs=p.executeQuery();
					while(rs.next())
					{
						txtscreen.setText("Screen 4");
						txtseat.setText("12B");
						txtshowtime.setText(rs.getString("show_time"));
						txtmovie.setText(rs.getString("movie_name"));
						txtname.setText(rs.getString("theater_name"));
						txtticket.setText(rs.getString("no_tickets"));
						txtamnt.setText("Rs."+rs.getString("amount"));
						blockChain.addBlock(new Block(rs.getString("show_time"),rs.getString("movie_name")+" "+rs.getString("theater_name")+" "+rs.getString("no_tickets")+" "+rs.getString("amount")));
						
						
						
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not logged in");
						
					}
					
					
				} catch (SQLException | NoSuchAlgorithmException e) {
				
					e.printStackTrace();
				}
				
				System.out.println(blockChain.chain);
			}
		
		});
		btnShow.setBounds(502, 357, 109, 47);
		panel_1.add(btnShow);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BookHistory.class.getResource("/login_img.png")));
		label_1.setBounds(0, 0, 1006, 578);
		panel_1.add(label_1);
	}
}
