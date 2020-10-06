import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;

public class BookTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textamount;
	private JTextField txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTicket frame = new BookTicket();
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
	public BookTicket() {
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
		panel.setBounds(0, 0, 1006, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BookTicket.class.getResource("/logo.png")));
		label.setBounds(387, 13, 218, 118);
		panel.add(label);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(BookTicket.class.getResource("/back.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home h=new home();
				h.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(0, 0, 100, 35);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 144, 1006, 577);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK TICKET");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(413, 41, 163, 50);
		panel_1.add(lblNewLabel_1);
		
		txt = new JTextField();
		txt.setForeground(Color.WHITE);
		txt.setBackground(Color.BLACK);
		txt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt.setText("AMOUNT");
		txt.setBounds(512, 323, 73, 22);
		panel_1.add(txt);
		txt.setColumns(10);
	    
		
		JComboBox combono = new JComboBox();
		combono.setForeground(Color.WHITE);
		combono.setBackground(Color.BLACK);
		combono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no=combono.getSelectedItem().toString();
				String a=textamount.getText();
				int b=Integer.parseInt(a);
				switch(no)
				{
				case "1": b*=1;
						  textamount.setText(Integer.toString(b));
						  break;
				case "2":b*=2;
				textamount.setText(Integer.toString(b));
				break;
				case "3":b*=3;
				textamount.setText(Integer.toString(b));
				break;
				case "4": b*=4;
				  textamount.setText(Integer.toString(b));
				  break;
				case "5": b*=5;
				  textamount.setText(Integer.toString(b));
				  break;
				
				
				
				
				}
				
			}
		});
		combono.setFont(new Font("Tahoma", Font.BOLD, 15));
		combono.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		combono.setBounds(512, 268, 50, 28);
		panel_1.add(combono);
		
		
		JComboBox screen = new JComboBox();
		screen.setForeground(Color.WHITE);
		screen.setBackground(Color.BLACK);
		screen.setFont(new Font("Tahoma", Font.BOLD, 15));
		screen.setModel(new DefaultComboBoxModel(new String[] {"SELECT SCREEN", "BIG CINEMAS", "CINEPOLIS", "SUCHITHRA", "ALINKEL", "CLASSIC", "CROWN"}));
		screen.setBounds(512, 180, 163, 36);
		panel_1.add(screen);
		
		JComboBox movie = new JComboBox();
		movie.setForeground(Color.WHITE);
		movie.setBackground(Color.BLACK);
		movie.setFont(new Font("Tahoma", Font.BOLD, 15));
		movie.setModel(new DefaultComboBoxModel(new String[] {"SELECT MOVIE", "LUCIFER", "KGF", "WAR", "AVENGERS ENDGAME"}));
		movie.setBounds(226, 180, 163, 36);
		panel_1.add(movie);
		
		
		
		textamount = new JTextField();
		textamount.setForeground(Color.WHITE);
		textamount.setBackground(Color.BLACK);
		textamount.setFont(new Font("Tahoma", Font.BOLD, 15));
		textamount.setBounds(512, 354, 182, 36);
		panel_1.add(textamount);
		textamount.setColumns(10);
		
		JComboBox combocl = new JComboBox();
		combocl.setForeground(Color.WHITE);
		combocl.setBackground(Color.BLACK);
		
		combocl.setFont(new Font("Tahoma", Font.BOLD, 15));
		combocl.setModel(new DefaultComboBoxModel(new String[] {"SELECT CLASS", "SILVER", "GOLD", "PLATINUM"}));
		combocl.setSelectedIndex(0);
		combocl.setBounds(226, 260, 163, 36);
		panel_1.add(combocl);
		combocl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected=combocl.getSelectedItem().toString();
				switch(selected)
				{
				case "SILVER":textamount.setText("100");
								break;
				case "GOLD":textamount.setText("150");
								break;
				case "PLATINUM":textamount.setText("200");
								break;
				default:textamount.setText("");
				}
			}
		});
		
		JComboBox show = new JComboBox();
		show.setModel(new DefaultComboBoxModel(new String[] {"SHOW TIME", "9.00 AM", "11.00 AM", "2.00 PM", "5.00 PM", "8.00 PM", "  "}));
		show.setSelectedIndex(0);
		show.setForeground(Color.WHITE);
		show.setFont(new Font("Tahoma", Font.BOLD, 15));
		show.setBackground(Color.BLACK);
		show.setBounds(226, 324, 163, 36);
		panel_1.add(show);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="INSERT INTO book_history(book_id,user_id,movie_name,theater_name,class,show_time,no_tickets,amount) VALUES (?,?,?,?,?,?,?,?)";
				String query="select * from user_info where user_status=?";
				
				
				try {
					PreparedStatement p=mycon.prepareStatement(query);
					p.setString(1,"active");
					ResultSet rs=p.executeQuery();
					while(rs.next())
					{
						String uid=rs.getString("user_id");
					
				    PreparedStatement ps=mycon.prepareStatement(sql);
					
					ps.setString(1,null);
					ps.setString(2, uid);
					ps.setString(3,movie.getSelectedItem().toString());
					ps.setString(4,screen.getSelectedItem().toString());
					ps.setString(5,combocl.getSelectedItem().toString());
					ps.setString(6,show.getSelectedItem().toString());
					ps.setString(7,combono.getSelectedItem().toString());
					ps.setString(8,textamount.getText());
					ps.executeUpdate();
					
					BookHistory bh;
					bh = new BookHistory();
					bh.setVisible(true);
					JOptionPane.showMessageDialog(null,"Ticket Booked!");
					dispose();
					
					}
					} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		
		
		btnNewButton.setIcon(new ImageIcon(BookTicket.class.getResource("/pay.jpg")));
		btnNewButton.setBounds(512, 403, 113, 41);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookTicket.class.getResource("/login_img.png")));
		lblNewLabel.setBounds(0, 0, 1006, 577);
		panel_1.add(lblNewLabel);
	}
}
