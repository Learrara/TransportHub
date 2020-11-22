

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;				////if there is free time resolve issues here
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

//import yeet.AddUpdateOrderPage;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class contains code for the Add/Update Order Page.
 * 
 * @author John Tex Lear O. Rara
 */

public class AddUpdateOrderPage {

    final String url = "jdbc:mysql:///testdb";					//replace url from testdb to actual database
    final String user = "root";
    final String password = "xXx69bruh420xXx";
    
    private int accountnumber = 1;
    
	JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scroll;
	
	private ArrayList<String> items;
	private ArrayList<Integer> quantity;
	
	private JLabel lola1;
	private JLabel lola2;
	private JLabel lola3;
	private JLabel lola4;
	private JLabel lola5;
	private JLabel lola6;
	private JLabel lola7;
	private JLabel lola8;
	
	private JLabel dala1;
	private JLabel dala2;
	private JLabel dala3;
	private JLabel dala4;
	private JLabel dala5;
	private JLabel dala6;
	private JLabel dala7;
	private JLabel dala8;
	
	private JLabel stala1;
	private JLabel stala2;
	private JLabel stala3;
	private JLabel stala4;
	private JLabel stala5;
	private JLabel stala6;
	private JLabel stala7;
	private JLabel stala8;
	
	private static int orderIdNum;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launches the application.
	 * @param args Inputs of the user
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUpdateOrderPage window = new AddUpdateOrderPage();
					window.frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * Creates the application.
	 */
	public AddUpdateOrderPage() {
		initialize();
	}
//////////////////////////////////////////////////////////////////////////////// Program Frame Initialization code begins here
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		items = new ArrayList<String>();
		quantity = new ArrayList<Integer>();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setBounds(1, 0, 1199, 30);
		frame.getContentPane().add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Container frame = lblNewLabel.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});
		lblNewLabel.setBounds(1176, 10, 13, 13);
		header.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(1154, 10, 22, 13);
		header.add(lblNewLabel_5);
		
		
		
		JPanel body = new JPanel();
		body.setBounds(1, 30, 1199, 730);
		frame.getContentPane().add(body);
		body.setBackground(new Color(51, 37, 78));
		body.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Order Number");
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1.setBounds(10, 40, 119, 13);
		body.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setToolTipText("Enter only Integer values");
		textField.addKeyListener(new KeyAdapter() {
		
		});
		textField.setBounds(140, 40, 360, 20);
		body.add(textField);
		textField.setColumns(10);
																						/////////////////////////Track order button code begins here
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					display();
				} catch(Exception ex)	{
				textField.setText("Incorrect Input");
				}
				}
			
			}
		);																				/////////////////////////Track order button code ends here
		btnNewButton.setBounds(510, 35, 100, 30);
		body.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Order Item/s");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(240, 255, 240));
		lblNewLabel_2.setBounds(10, 84, 119, 13);
		body.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order Status");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(253, 245, 230));
		lblNewLabel_3.setBounds(260, 260, 85, 30);
		body.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 290, 600, 270);
		body.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_location = new JPanel();
		panel_location.setBounds(0, 0, 100, 30);
		panel_location.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_location.setBackground(SystemColor.control);
		panel_2.add(panel_location);
		
		JLabel lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_location.add(lblNewLabel_4);
				
		JPanel panel_location_1_1 = new JPanel();
		panel_location_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_1.setBackground(SystemColor.menu);
		panel_location_1_1.setBounds(0, 30, 100, 30);
		panel_2.add(panel_location_1_1);
		
		stala1 = new JLabel(" ");
		stala1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_1.add(stala1);
		
		JPanel panel_location_1_2 = new JPanel();
		panel_location_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_2.setBackground(SystemColor.menu);
		panel_location_1_2.setBounds(0, 60, 100, 30);
		panel_2.add(panel_location_1_2);
		
		stala2 = new JLabel(" ");
		stala2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_2.add(stala2);
		
		JPanel panel_location_1_3 = new JPanel();
		panel_location_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_3.setBackground(SystemColor.menu);
		panel_location_1_3.setBounds(0, 90, 100, 30);
		panel_2.add(panel_location_1_3);
		
		stala3 = new JLabel(" ");
		stala3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_3.add(stala3);
		
		JPanel panel_location_1_4 = new JPanel();
		panel_location_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_4.setBackground(SystemColor.menu);
		panel_location_1_4.setBounds(0, 120, 100, 30);
		panel_2.add(panel_location_1_4);
		
		stala4 = new JLabel(" ");
		stala4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_4.add(stala4);
		
		JPanel panel_location_1_5 = new JPanel();
		panel_location_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_5.setBackground(SystemColor.menu);
		panel_location_1_5.setBounds(0, 150, 100, 30);
		panel_2.add(panel_location_1_5);
		
		stala5 = new JLabel(" ");
		stala5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_5.add(stala5);
		
		JPanel panel_location_1_6 = new JPanel();
		panel_location_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_6.setBackground(SystemColor.menu);
		panel_location_1_6.setBounds(0, 180, 100, 30);
		panel_2.add(panel_location_1_6);
		
		stala6 = new JLabel(" ");
		stala6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_6.add(stala6);
		
		JPanel panel_location_1_7 = new JPanel();
		panel_location_1_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_7.setBackground(SystemColor.menu);
		panel_location_1_7.setBounds(0, 210, 100, 30);
		panel_2.add(panel_location_1_7);
		
		stala7 = new JLabel(" ");
		stala7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_7.add(stala7);
		
		JPanel panel_location_1_8 = new JPanel();
		panel_location_1_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_location_1_8.setBackground(SystemColor.menu);
		panel_location_1_8.setBounds(0, 240, 100, 30);
		panel_2.add(panel_location_1_8);
		
		stala8 = new JLabel(" ");
		stala8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_location_1_8.add(stala8);
		
		JPanel panel_date = new JPanel();
		panel_date.setBounds(100, 0, 80, 30);
		panel_date.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_date.setBackground(SystemColor.menu);
		panel_2.add(panel_date);
		
		JLabel lblNewLabel_4_1 = new JLabel("Date");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_date.add(lblNewLabel_4_1);		
		
		JPanel panel_date_1_1 = new JPanel();
		panel_date_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_1.setBackground(SystemColor.menu);
		panel_date_1_1.setBounds(100, 30, 80, 30);
		panel_2.add(panel_date_1_1);
		
		dala1 = new JLabel(" ");
		dala1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_1.add(dala1);
		
		JPanel panel_date_1_2 = new JPanel();
		panel_date_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_2.setBackground(SystemColor.menu);
		panel_date_1_2.setBounds(100, 60, 80, 30);
		panel_2.add(panel_date_1_2);
		
		dala2 = new JLabel(" ");
		dala2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_2.add(dala2);
		
		JPanel panel_date_1_3 = new JPanel();
		panel_date_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_3.setBackground(SystemColor.menu);
		panel_date_1_3.setBounds(100, 90, 80, 30);
		panel_2.add(panel_date_1_3);
		
		dala3 = new JLabel(" ");
		dala3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_3.add(dala3);
		
		JPanel panel_date_1_4 = new JPanel();
		panel_date_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_4.setBackground(SystemColor.menu);
		panel_date_1_4.setBounds(100, 120, 80, 30);
		panel_2.add(panel_date_1_4);
		
		dala4 = new JLabel(" ");
		dala4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_4.add(dala4);
		
		JPanel panel_date_1_5 = new JPanel();
		panel_date_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_5.setBackground(SystemColor.menu);
		panel_date_1_5.setBounds(100, 150, 80, 30);
		panel_2.add(panel_date_1_5);
		
		dala5 = new JLabel(" ");
		dala5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_5.add(dala5);
		
		JPanel panel_date_1_6 = new JPanel();
		panel_date_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_6.setBackground(SystemColor.menu);
		panel_date_1_6.setBounds(100, 180, 80, 30);
		panel_2.add(panel_date_1_6);
		
		dala6 = new JLabel(" ");
		dala6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_6.add(dala6);
		
		JPanel panel_date_1_7 = new JPanel();
		panel_date_1_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_7.setBackground(SystemColor.menu);
		panel_date_1_7.setBounds(100, 210, 80, 30);
		panel_2.add(panel_date_1_7);
		
		dala7 = new JLabel(" ");
		dala7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_7.add(dala7);
		
		JPanel panel_date_1_8 = new JPanel();
		panel_date_1_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_date_1_8.setBackground(SystemColor.menu);
		panel_date_1_8.setBounds(100, 240, 80, 30);
		panel_2.add(panel_date_1_8);
		
		dala8 = new JLabel(" ");
		dala8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_date_1_8.add(dala8);
			
		JPanel panel_status = new JPanel();
		panel_status.setBounds(180, 0, 420, 30);
		panel_status.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_status.setBackground(SystemColor.menu);
		panel_2.add(panel_status);
		
		JLabel lblNewLabel_4_2 = new JLabel("Location");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status.add(lblNewLabel_4_2);
		
		JPanel panel_status_1_1 = new JPanel();
		panel_status_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_1.setBackground(SystemColor.menu);
		panel_status_1_1.setBounds(180, 30, 420, 30);
		panel_2.add(panel_status_1_1);
		
		lola1 = new JLabel(" ");
		lola1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_1.add(lola1);
		
		JPanel panel_status_1_2 = new JPanel();
		panel_status_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_2.setBackground(SystemColor.menu);
		panel_status_1_2.setBounds(180, 60, 420, 30);
		panel_2.add(panel_status_1_2);
		
		lola2 = new JLabel(" ");
		lola2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_2.add(lola2);
		
		JPanel panel_status_1_3 = new JPanel();
		panel_status_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_3.setBackground(SystemColor.menu);
		panel_status_1_3.setBounds(180, 90, 420, 30);
		panel_2.add(panel_status_1_3);
		
		lola3 = new JLabel(" ");
		lola3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_3.add(lola3);
		
		JPanel panel_status_1_4 = new JPanel();
		panel_status_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_4.setBackground(SystemColor.menu);
		panel_status_1_4.setBounds(180, 120, 420, 30);
		panel_2.add(panel_status_1_4);
		
		lola4 = new JLabel(" ");
		lola4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_4.add(lola4);
		
		JPanel panel_status_1_5 = new JPanel();
		panel_status_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_5.setBackground(SystemColor.menu);
		panel_status_1_5.setBounds(180, 150, 420, 30);
		panel_2.add(panel_status_1_5);
		
		lola5 = new JLabel(" ");
		lola5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_5.add(lola5);
		
		JPanel panel_status_1_6 = new JPanel();
		panel_status_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_6.setBackground(SystemColor.menu);
		panel_status_1_6.setBounds(180, 180, 420, 30);
		panel_2.add(panel_status_1_6);
		
		lola6 = new JLabel(" ");
		lola6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_6.add(lola6);
		
		JPanel panel_status_1_7 = new JPanel();
		panel_status_1_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_7.setBackground(SystemColor.menu);
		panel_status_1_7.setBounds(180, 210, 420, 30);
		panel_2.add(panel_status_1_7);
		
		lola7 = new JLabel(" ");
		lola7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_7.add(lola7);
		
		JPanel panel_status_1_8 = new JPanel();
		panel_status_1_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_status_1_8.setBackground(SystemColor.menu);
		panel_status_1_8.setBounds(180, 240, 420, 30);
		panel_2.add(panel_status_1_8);
		
		lola8 = new JLabel(" ");
		lola8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_status_1_8.add(lola8);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 300, -101, 25);
		body.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 80, 360, 60);
		body.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(10, 580, 100, 30);
		body.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(110, 580, 80, 30);
		body.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 580, 420, 30);
		body.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Update Status");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUpdateOrderPage yeets = new AddUpdateOrderPage();
				orderIdNum = Integer.parseInt(textField.getText());
				String OrderStat = textField_1.getText();
				String OrderDate = textField_2.getText();
				String OrderLoca = textField_3.getText();
				try {
					yeets.insertstatus(orderIdNum, accountnumber, OrderStat, OrderDate, OrderLoca);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				display();
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(490, 620, 120, 30);
		body.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Name");
		lblNewLabel_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 151, 119, 13);
		body.add(lblNewLabel_1_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(140, 150, 360, 20);
		body.add(textField_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Customer Address");
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 180, 119, 13);
		body.add(lblNewLabel_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(140, 180, 360, 20);
		body.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 214, 119, 13);
		body.add(lblNewLabel_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(140, 210, 360, 20);
		body.add(textField_6);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Customer Name");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(700, 40, 119, 13);
		body.add(lblNewLabel_1_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(829, 44, 360, 20);
		body.add(textField_7);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Customer Address");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(700, 84, 119, 13);
		body.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(829, 83, 360, 20);
		body.add(textField_8);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(700, 121, 119, 13);
		body.add(lblNewLabel_1_1_1_1_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(829, 120, 360, 20);
		body.add(textField_9);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Order Item/s");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(700, 151, 119, 13);
		body.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(829, 156, 358, 58);
		body.add(textArea_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Item");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(786, 237, 42, 13);
		body.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(829, 230, 220, 20);
		body.add(textField_10);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setBounds(1055, 231, 62, 20);
		body.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(1127, 230, 60, 20);
		body.add(textField_11);
		
		JButton btnNewButton_2 = new JButton("Add Item");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
			try {
			quantity.add(Integer.parseInt(textField_11.getText()));
			items.add(textField_10.getText());
			textField_10.setText("");
			textField_11.setText("");
			} catch (NumberFormatException ye) {
				textField_10.setText("Please information in correct");
				textField_11.setText("format"); 
			}
			
			System.out.println("------------");
			for (int i = 0; i < items.size(); i++) {
				System.out.print(items.get(i)+" ");
				System.out.println(quantity.get(i)); 
			    }
			 System.out.println("-----------");
			 
			
			 String infolist = "";
			for (int i = 0; i < items.size(); i++) {
				infolist = infolist + items.get(i) + " - " + quantity.get(i) + ", ";
				System.out.print(items.get(i)+" ");
				System.out.println(quantity.get(i)); 
			    }
			 textArea_1.setText(infolist);
			}
			
			
			
		});
		btnNewButton_2.setBounds(1049, 262, 140, 30);
		body.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Add Order");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				System.out.println("Add Order Button");
				
				System.out.println("------------");
				for (int i = 0; i < items.size(); i++) {				//// Add code that will return an error message and reset textfields
					System.out.print(items.get(i)+" ");					//// if order is added with any 
					System.out.println(quantity.get(i));
				    
				    }
				 System.out.println("-----------");
				 
				 String name = textField_7.getText();
				 String address = textField_8.getText();
				 String number = textField_9.getText();
				 
				 System.out.println("Name:"+name);
				 System.out.println("Address:"+address);
				 System.out.println("Number:"+number);
				 
				 try {
				 insertcustomerinfo(name, address, number, items, quantity);
				 } catch(Exception ex) {
				 System.out.println("Something went terribly wrong");
				 }
			
				 textField_7.setText("");
				 textField_8.setText("");
				 textField_9.setText("");
				 textArea_1.setText("");
				 
				items = new ArrayList<String>();
				quantity = new ArrayList<Integer>();
			}
		});
		btnNewButton_2_1.setBounds(1049, 329, 140, 30);
		body.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Order Number is:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setBounds(819, 332, 125, 20);
		body.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(939, 335, 100, 20);
		body.add(textField_12);
	
	}
	
	//////////////////////////////////////////////////////////////////////////// Program frame code ends here
	
	//////////////////////////////////////////////////////////////////////////// MySQL database interfacing code starts here
	
	
	/**
     * This method displays order information.
     * <p>
     * It does this by using their respective retrieve methods
     * and setting them to their respective textfields.
     
     */
    public void display(){
		try {
		AddUpdateOrderPage yeet = new AddUpdateOrderPage();
		orderIdNum = Integer.parseInt(textField.getText());
		ArrayList<String> yeetstat = yeet.retrievestatusstat(orderIdNum);
		ArrayList<String> yeetdate = yeet.retrievestatusdate(orderIdNum);
		ArrayList<String> yeetlocation = yeet.retrievestatuslocation(orderIdNum);

		stala1.setText(yeetstat.get(0));
		stala2.setText(yeetstat.get(1));
		stala3.setText(yeetstat.get(2));
		stala4.setText(yeetstat.get(3));
		stala5.setText(yeetstat.get(4));
		stala6.setText(yeetstat.get(5));
		stala7.setText(yeetstat.get(6));
		stala8.setText(yeetstat.get(7));
		
		dala1.setText(yeetdate.get(0));
		dala2.setText(yeetdate.get(1));
		dala3.setText(yeetdate.get(2));
		dala4.setText(yeetdate.get(3));
		dala5.setText(yeetdate.get(4));
		dala6.setText(yeetdate.get(5));
		dala7.setText(yeetdate.get(6));
		dala8.setText(yeetdate.get(7));
		
		lola1.setText(yeetlocation.get(0));
		lola2.setText(yeetlocation.get(1));
		lola3.setText(yeetlocation.get(2));
		lola4.setText(yeetlocation.get(3));
		lola5.setText(yeetlocation.get(4));
		lola6.setText(yeetlocation.get(5));
		lola7.setText(yeetlocation.get(6));
		lola8.setText(yeetlocation.get(7));
		
		String ORIT = yeet.retrieveitem(orderIdNum);				
		textArea.setText(ORIT);
		
		String CUNA = yeet.retrievecustomername(orderIdNum);
		textField_4.setText(CUNA);
		
		String CUAD = yeet.retrievecustomeraddress(orderIdNum);
		textField_5.setText(CUAD);
		
		String CUPH = yeet.retrievecustomerphone(orderIdNum);
		textField_6.setText(CUPH);
		
		} catch(Exception ex)	{
		textField.setText("Incorrect Input");
		}
		}
	
    /**
     * Creates an order 
     * <p>
     * This method creates and order and returns an integer signifying the
     * id number of the created order.
     * 
     * @return      The Id number of the created order.
     */
    
    public Integer createorder() {
    	int ordernumb = 0;
    	try {
    	Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement=connection.prepareStatement("insert into orders(account_id_num, date) values(?,?)");
    	long millis=System.currentTimeMillis();  
    	java.sql.Date date=new java.sql.Date(millis); 
    	preparedStatement.setInt(1, 1);
    	preparedStatement.setDate(2, date);
    	preparedStatement.executeUpdate();
    	System.out.println("code run succesfully");
    	}catch (SQLException e) {
    	System.out.println(e);
    	System.out.println("error in: createorder()");
    	}
    	
    	try {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	PreparedStatement preparedStatement=connection.prepareStatement("select * from orders order by order_id_num desc limit 1");
    	ResultSet resultSet=preparedStatement.executeQuery();
    	resultSet.next();
    	
    	ordernumb = Integer.parseInt(resultSet.getString(1));
    	
    	}catch(SQLException e) {
	    	System.out.println(e);
	    	System.out.println("error in: createorder()");
	    	}
    return ordernumb;
    }
  
    /**
     * Inserts customer information into the database. 
     * <p>
     * The method first creates an order using the createorder() method.
     * It then uses the ID number the createorder() method returned as a 
     * foreign key. It then inputs customer information. It then inputs 
     * the ordered items using the insertitems() method.
     *
     * @param  	name  The name of the customer
     * @param  	address The address of the customer
     * @param  	number The phone number of the customer.
     * @param  	items An arraylist containing the items ordered by the customer.
     * @param	quantity An arraylist containing the quantities of the items in the items parameter.
     * @throws	Exception Occurs when information inputted does not match database format.
     * @see    	createorder()	
     * @see		insertitems(int oin, String name, int quantity)
     */
	public void insertcustomerinfo(String name, String address, String number, ArrayList<String> items, ArrayList<Integer> quantity) throws Exception {
				
		createorder();
		
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Crating PreparedStatement object
	 PreparedStatement preparedStatement=connection.prepareStatement("insert into customer (order_id_num, customername, address, customerphone)  values(?,?,?,?)");
	 int oin = createorder();
	 textField_12.setText(Integer.toString(oin));
	 //Setting values for Each Parameter
	 		 
	 		 preparedStatement.setInt(1, oin);
	 		 preparedStatement.setString(2,name);
	         preparedStatement.setString(3,address);
	         preparedStatement.setString(4,number);
	         //Executing Query
	         preparedStatement.executeUpdate();
	         System.out.println("data inserted successfully");
	 
	         try {
	         for (int m = 0; m < items.size(); m++) {
	        	 insertitems(oin, items.get(m), quantity.get(m));
		        	}
	         } catch (SQLException yeet) {
	        	   
	        	}
	         
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Data Insert Failed - customer info");
	 
	 }
	 }
	
	 /**
     * Inserts item information into the database
     * <p>
     * Inserts the information passed to it into the database. It uses the order ID number to 
     * determine which table to insert the information into.
     *
     * @param  	oin  The order ID number 
     * @param  	name The name of the item to be delivered.
     * @param  	quantity The number of items ordered.
     * @throws	Exception Occurs when information inputted does not match database format.
     */
	public void insertitems(int oin, String name, int quantity) throws Exception {
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 System.out.println("Connected With the database successfully - insert");
	 //Crating PreparedStatement object
	 PreparedStatement preparedStatement=connection.prepareStatement("insert into order_item(order_id_num, item_name, quantity) values(?,?,?)"); 
	 //Setting values for Each Parameter
	 		 preparedStatement.setInt(1, oin);
	 		 preparedStatement.setString(2,name);
	         preparedStatement.setInt(3,quantity);
	         preparedStatement.executeUpdate();
	         System.out.println("data inserted successfully");
	 
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Data Insert Failed");
	 
	 }
	 }
	
	/**
     * Inserts order update information into the database.
     * <p>
     * Using the Id number passed to it, the method determines which status
     * record in which to insert information in. It the inserts the information 
     * the rest of the parameters into their respective records.
     * as a foreign key for the inputed information. 
     *
     * @param  	orid	The ID number of the selected order.
     * @param  	acco	The Account number of the manager that created the status update.
     * @param  	stat 	Status information of the selected order.
     * @param 	date 	The date when the status information was added.
     * @param	loca	The location of the order at the time the status update was published.
     * @throws	Exception Occurs when information inputted does not match database format.
     */
	public void insertstatus(int orid, int acco, String stat, String date, String loca) throws Exception {
		
		System.out.println("Date is:"+ date);				
		
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Crating PreparedStatement object
	 PreparedStatement preparedStatement=connection.prepareStatement("insert into order_status (account_id_num, order_id_num, status, date, location)  values(?,?,?,?,?)");

	 
	 //Setting values for Each Parameter
	 		 preparedStatement.setInt(1,acco);
	         preparedStatement.setInt(2,orid);
	         preparedStatement.setString(3,stat);
	         preparedStatement.setDate(4, Date.valueOf(date));
	         preparedStatement.setString(5,loca);
	         //Executing Query
	         preparedStatement.executeUpdate();
	         System.out.println("data inserted successfully");
	 
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Data Insert Failed");
	 
	 }
	 }
	
	/**
     * Retrieves status information from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which status record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return 	An ArrayList containing the status information.
     */												
	public ArrayList<String> retrievestatusstat(int i) throws Exception {		
	
		ArrayList<String> status = new ArrayList<String>();
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from order_status where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        
	        for (int m = 0; m < 8; m++) {
	        	try {
	        	  resultSet.next();
	        	  status.add(resultSet.getString(4));
	        	} catch (SQLException yeet) {
	        	  status.add(" ");
	        	}
	        	}
	        

	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievestatusstat");
	 } 

	 return status;   
	 }

	/**
     * Retrieves status date information from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which status record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return 	An ArrayList containing the status date information.
     */	
	public ArrayList<String> retrievestatusdate(int i) throws Exception {
		
		ArrayList<String> date = new ArrayList<String>();
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from order_status where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        
	        for (int m = 0; m < 8; m++) {
	        	try {
	        	  resultSet.next();
	        	  date.add(resultSet.getString(5));
	        	} catch (SQLException yeet) {
	        	  date.add(" ");
	        	}
	        	}
	        
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievestatusdate");
	 }
	 return date;   
	 }
	
	/**
     * Retrieves status location information from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which status record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return 	An ArrayList containing the status location information.
     */	
	public ArrayList<String> retrievestatuslocation(int i) throws Exception {
		
		ArrayList<String> location = new ArrayList<String>();
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from order_status where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        
	        for (int m = 0; m < 8; m++) {
	        	try {
	        	  resultSet.next();
	        	  location.add(resultSet.getString(6));
	        	} catch (SQLException yeet) {
	        	  location.add(" ");
	        	}
	        	}

	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievestatuslocation");
	 }
	 return location;   
	 }																				
																			
	/**
     * Retrieves item information from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which item records to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return	A String containing item information.
     */	
	public String retrieveitem(int i) throws Exception {
		 String itemlist = "itemlist initial value/ if this appears then something went wrong - terribly wrong";
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from order_item where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        itemlist = "";
	        while(resultSet.next()){
	             String orderitemidnum=resultSet.getString(1);
	             String orderidnum=resultSet.getString(2);
	             String itemname=resultSet.getString(3);
	             String quantity=resultSet.getString(4);
	             itemlist = itemlist + itemname + " - " + quantity + ", ";   
	        }
	   
	 
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrieveitem");
	 
	 }
		return itemlist;
	 }
	
	/**
     * Retrieves customer name from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which customer record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return 	A string containing the name of the customer.
     */	
	public String retrievecustomername(int i) throws Exception {
		 String customername = "customername initial value/ if this appears then something went wrong - terribly wrong";
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select customername from customer where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        resultSet.next();
	        customername=resultSet.getString(1);

	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievecustomername");
	 
	 }
		return customername;
	 }
	/**
     * Retrieves customer's address from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which customer record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return  A String containing customer address information.
     */	
	public String retrievecustomeraddress(int i) throws Exception {
		 String customeraddress = "customeraddress initial value/ if this appears then something went wrong - terribly wrong";
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select address from customer where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        resultSet.next();
	        customeraddress=resultSet.getString(1);
	 
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievecustomeraddress");
	 
	 }
		return customeraddress;
	 }	
	
	/**
     * Retrieves the customer's phone number from the database.
     * <p>
     * Method uses the order ID number passed to it to determine
     * which customer record to retrieve information from.
     *
     * @param 	i	The ID number of the order selected.
     * @throws	Exception Occurs when information inputed does not match database format.
     * @return 	A String containing the customer's phone number.
     */	
	public String retrievecustomerphone(int i) throws Exception {
		 String customerphone = "customerphone initial value/ if this appears then something went wrong - terribly wrong";
	    try {
	 Connection connection = DriverManager.getConnection(url, user, password);//Establishing connection
	 //Using SQL SELECT Query
	        PreparedStatement preparedStatement=connection.prepareStatement("select customerphone from customer where order_id_num = ?");
	        preparedStatement.setInt(1, i);
	        //Creating Java ResultSet object
	        ResultSet resultSet=preparedStatement.executeQuery();
	        resultSet.next();
	        customerphone=resultSet.getString(1);
	 
	 } catch (SQLException e) {
	 System.out.println(e);
	 System.out.println("Error while connecting to the database - retrievecustomerphone");
	 
	 }
		return customerphone;
	 }
}
