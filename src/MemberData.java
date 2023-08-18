import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class MemberData {

	public JFrame memberframe, frame;
	private JTable table;
	private JTextField txtname;
	private JTextField txtcontact;
	private JTextField txtaddress;
	private JTextField txtdate;
	private JTextField txtage;
	private JTextField txtmid;
	JTextComponent textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberData window = new MemberData();
					window.memberframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberData() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect()									//******** DATABASE SETUP ********//
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/gymdata";
			String UserName = "root";
			String Password = "root";

			con = DriverManager.getConnection(url, UserName, Password);
		}
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
	}

	public void table_load()									//******** TO VIEW TABLE DATA ********//
	{
		try 
		{
			pst = con.prepareStatement("select * from memberdata");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		memberframe = new JFrame();
		memberframe.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/zeus_logo.jpg"));
		memberframe.getContentPane().setBackground(UIManager.getColor("Button.background"));
		memberframe.getContentPane().setForeground(new Color(255, 255, 255));
		memberframe.setBounds(100, 100, 1000, 600);
		memberframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberframe.getContentPane().setLayout(null);
		memberframe.setLocationRelativeTo(null);
		memberframe.setTitle("ZEUS FITNESS");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 56, 964, 160);
		memberframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(72, 29, 80, 25);
		panel.add(lblNewLabel);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(713, 29, 80, 25);
		panel.add(lblGender);

		JLabel lblContactNo = new JLabel("CONTACT NO.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo.setBounds(256, 29, 80, 25);
		panel.add(lblContactNo);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(492, 29, 80, 25);
		panel.add(lblAddress);

		JLabel lblJoiningDate = new JLabel("DATE");
		lblJoiningDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJoiningDate.setBounds(296, 103, 80, 25);
		panel.add(lblJoiningDate);

		JLabel lblMembershipPeriod = new JLabel("MEMBERSHIP");
		lblMembershipPeriod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMembershipPeriod.setBounds(476, 103, 80, 25);
		panel.add(lblMembershipPeriod);

		JLabel lblHeight = new JLabel("AGE");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeight.setBounds(80, 103, 80, 25);
		panel.add(lblHeight);

		JLabel lblWeight = new JLabel("PAYMENT");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWeight.setBounds(708, 103, 80, 25);
		panel.add(lblWeight);

		txtname = new JTextField();
		txtname.setBounds(116, 27, 95, 30);
		panel.add(txtname);
		txtname.setColumns(10);

		txtcontact = new JTextField();
		txtcontact.setColumns(10);
		txtcontact.setBounds(346, 27, 95, 30);
		panel.add(txtcontact);

		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(557, 27, 95, 30);
		panel.add(txtaddress);

		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(346, 101, 95, 30);
		panel.add(txtdate);

		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(116, 101, 95, 30);
		panel.add(txtage);

		JComboBox<String> gender_combo = new JComboBox<>();
		gender_combo.setForeground(new Color(0, 0, 0));
		gender_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Male", "Female", "Others"}));
		gender_combo.setBounds(772, 27, 95, 30);
		panel.add(gender_combo);

		JComboBox<String> mship_combo = new JComboBox<>();
		mship_combo.setForeground(new Color(0, 0, 0));
		mship_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "12 Months", "6 Months", "3 Months", "1 Month"}));
		mship_combo.setBounds(557, 101, 95, 30);
		panel.add(mship_combo);

		JComboBox<String> pay_combo = new JComboBox<>();
		pay_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Full Paid", "Half Paid"}));
		pay_combo.setBounds(772, 101, 95, 30);
		panel.add(pay_combo);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(696, 11, 258, 322);
		panel.add(textArea);
		textArea.setFont(new Font("Monospaced", Font.ITALIC, 15));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0) , 1 ));
		textArea.setVisible(false);

		
		JButton btnNewButton = new JButton("SAVE");							//******** SAVE BUTTON ********//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, contact, address, gender, age, date, membership, payment ;

				name = txtname.getText();
				contact = txtcontact.getText();
				address = txtaddress.getText();
				gender = gender_combo.getSelectedItem().toString();
				age = txtage.getText();
				date = txtdate.getText();
				membership = mship_combo.getSelectedItem().toString();
				payment = pay_combo.getSelectedItem().toString();

				try {
					pst = con.prepareStatement("insert into memberdata(NAME, CONTACT_NO, ADDRESS, GENDER, AGE, DATE, MEMBERSHIP, PAYMENT) values(?,?,?,?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, gender);
					pst.setString(5, age);
					pst.setString(6, date);
					pst.setString(7, membership);
					pst.setString(8, payment);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					table_load();

					txtname.setText("");
					txtcontact.setText("");
					txtaddress.setText("");
					gender_combo.setSelectedIndex(0);
					txtage.setText("");
					txtdate.setText("");
					mship_combo.setSelectedIndex(0);
					pay_combo.setSelectedIndex(0);
					txtname.requestFocus();
				}
				catch (SQLException e1) 
				{            
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setBounds(85, 227, 90, 30);
		memberframe.getContentPane().add(btnNewButton);


		JButton btnNewButton_1 = new JButton("UPDATE");							//******** EDIT BUTTON ********//
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, contact, address, gender, age, date, membership, payment, id ;

				name = txtname.getText();
				contact = txtcontact.getText();
				address = txtaddress.getText();
				gender = gender_combo.getSelectedItem().toString();
				age = txtage.getText();
				date = txtdate.getText();
				membership = mship_combo.getSelectedItem().toString();
				payment = pay_combo.getSelectedItem().toString();
				id = txtmid.getText();

				try {
					pst = con.prepareStatement("update memberdata set NAME = ?, CONTACT_NO = ?, ADDRESS = ?, GENDER = ?, AGE = ?, DATE = ?, MEMBERSHIP = ?, PAYMENT = ? where id = ?");		

					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, gender);
					pst.setString(5, age);
					pst.setString(6, date);
					pst.setString(7, membership);
					pst.setString(8, payment);
					pst.setString(9, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();

					txtname.setText("");
					txtcontact.setText("");
					txtaddress.setText("");
					gender_combo.setSelectedIndex(0);
					txtage.setText("");
					txtdate.setText("");
					mship_combo.setSelectedIndex(0);
					pay_combo.setSelectedIndex(0);
					txtmid.setText("");
					txtname.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(260, 227, 90, 30);
		memberframe.getContentPane().add(btnNewButton_1);


		JButton btnNewButton_2 = new JButton("DELETE");							//******** DELETE BUTTON ********//
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id;
				id  = txtmid.getText();

				try {
					pst = con.prepareStatement("delete from memberdata where id =?");

					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
					table_load();

					txtname.setText("");
					txtcontact.setText("");
					txtaddress.setText("");
					gender_combo.setSelectedIndex(0);
					txtage.setText("");
					txtdate.setText("");
					mship_combo.setSelectedIndex(0);
					pay_combo.setSelectedIndex(0);
					txtmid.setText("");
					txtname.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(435, 227, 90, 30);
		memberframe.getContentPane().add(btnNewButton_2);


		JButton btnExit = new JButton("EXIT");									//******** EXIT BUTTON ********//
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame = new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit Button", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(610, 227, 90, 30);
		memberframe.getContentPane().add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 338, 964, 212);
		memberframe.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(296, 275, 187, 52);
		memberframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblContactNo_1 = new JLabel("ID :");
		lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo_1.setBounds(10, 14, 28, 25);
		panel_1.add(lblContactNo_1);


		txtmid = new JTextField();												//******** SEARCH FIELD ********//
		txtmid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					String id = txtmid.getText();
					pst = con.prepareStatement("select NAME, CONTACT_NO, ADDRESS, GENDER, AGE, DATE, MEMBERSHIP, PAYMENT from memberdata where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					if(rs.next()==true)
					{
						String name = rs.getString(1);
						String contact = rs.getString(2);
						String address = rs.getString(3);
						String gender = rs.getString(4);
						String age = rs.getString(5);
						String date = rs.getString(6);
						String membership = rs.getString(7);
						String fees = rs.getString(8);

						txtname.setText(name);
						txtcontact.setText(contact);
						txtaddress.setText(address);
						gender_combo.setSelectedItem(gender);
						txtage.setText(age);
						txtdate.setText(date);
						mship_combo.setSelectedItem(membership);
						pay_combo.setSelectedItem(fees);
					}   

					else
					{
						txtname.setText("");
						txtcontact.setText("");
						txtaddress.setText("");
						gender_combo.setSelectedIndex(0);
						txtage.setText("");
						txtdate.setText("");
						mship_combo.setSelectedIndex(0);
						pay_combo.setSelectedIndex(0);
					}
				} 

				catch (SQLException ex) {
				}		
			}
		});

		txtmid.setColumns(10);
		txtmid.setBounds(60, 13, 98, 28);
		panel_1.add(txtmid);

		JLabel lblNewLabel_1 = new JLabel("MEMBER PAGE");
		lblNewLabel_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(440, 11, 120, 35);
		memberframe.getContentPane().add(lblNewLabel_1);


		JButton btnBack = new JButton("TRAINER DATA");									//******** TRAINER DATA BUTTON ********//
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberframe.dispose();
				TrainerData x2 = new TrainerData();
				x2.Trainerframe.setVisible(true); 
			}
		});
		btnBack.setBounds(785, 227, 120, 30);
		memberframe.getContentPane().add(btnBack);

		
		JButton btnNewButton_3 = new JButton("GENERATE BILL");							//******** GENERATE BILL DATA BUTTON ********//
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtArea_1.setIcon(new ImageIcon("Images/mainframe.jpg"));
				textArea.setText(textArea.getText() + "	  ****      ZEUS FITNESS      ****\n");
				textArea.setText(textArea.getText() + "\n	  ----:   PAYMENT RECEIPT   :----\n");
				
				textArea.setText(textArea.getText() + "\n		Name: " + txtname.getText() + "\n");
				textArea.setText(textArea.getText() + "		Contact No: " + txtcontact.getText() + "\n");
				textArea.setText(textArea.getText() + "		Address: " + txtaddress.getText() + "\n");
				textArea.setText(textArea.getText() + "  		Gender: " + gender_combo.getSelectedItem().toString() + "\n");
				textArea.setText(textArea.getText() + "		Age: " + txtage.getText() + "\n");
				textArea.setText(textArea.getText() + "		Date: " + txtdate.getText() + "\n");
				textArea.setText(textArea.getText() + "		Membership: " + mship_combo.getSelectedItem().toString() + "\n");
				textArea.setText(textArea.getText() + "		Payment: " + pay_combo.getSelectedItem().toString() + "\n");
				textArea.setText(textArea.getText() + "\n\n\n       	                        Signature \n");

				frame = new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "Print Receipt", "Print Button", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					try {
						textArea.print();
						System.exit(0);
					} 
					catch (PrinterException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		btnNewButton_3.setBounds(527, 286, 130, 30);
		memberframe.getContentPane().add(btnNewButton_3);
	}
}