import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class admin_page extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnMovies;
	private JButton btnTheater;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_page frame = new admin_page();
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
	private JButton btnDeleteUser;
	private JTextField txtu;
	public admin_page() {
		mycon=DBconnection.connectiondb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100,1024,768);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1006, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("users");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql="SELECT * FROM user_info";
					PreparedStatement ps=mycon.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
		JLabel lblUsername = new JLabel("User_id");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(432, 478, 89, 29);
		panel.add(lblUsername);
		btnNewButton.setBounds(68, 137, 135, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		
		btnMovies = new JButton("movies");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String sql="SELECT * FROM movie";
					PreparedStatement ps=mycon.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnMovies.setBounds(68, 215, 135, 36);
		btnMovies.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMovies.setBackground(Color.BLACK);
		btnMovies.setForeground(Color.WHITE);
		panel.add(btnMovies);
		
		btnTheater = new JButton("theater");
		btnTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="SELECT * FROM theater";
					PreparedStatement ps=mycon.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception er) {
					er.printStackTrace();
				}
			}
		});
		btnTheater.setBounds(68, 280, 135, 36);
		btnTheater.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTheater.setForeground(Color.WHITE);
		btnTheater.setBackground(Color.BLACK);
		panel.add(btnTheater);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setBounds(277, 86, 684, 356);
		panel.add(table);
		
		JButton btnBookHistory = new JButton("book history");
		btnBookHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="SELECT * FROM book_history";
					PreparedStatement ps=mycon.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception er) {
					er.printStackTrace();
				}
				
			}
		});
		
		txtu = new JTextField();
		txtu.setBounds(548, 475, 182, 36);
		panel.add(txtu);
		txtu.setColumns(10);
		btnBookHistory.setForeground(Color.WHITE);
		btnBookHistory.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBookHistory.setBackground(Color.BLACK);
		btnBookHistory.setBounds(68, 345, 135, 36);
		panel.add(btnBookHistory);
		
		btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="delete  from user_info where user_id=?";
				
				try {
					PreparedStatement ps=mycon.prepareStatement(sql);
					ps.setString(1,txtu.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "User deleted");
					ps.close();
					
					
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnDeleteUser.setForeground(Color.WHITE);
		btnDeleteUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteUser.setBackground(Color.BLACK);
		btnDeleteUser.setBounds(720, 545, 135, 36);
		panel.add(btnDeleteUser);
	
	}
}
