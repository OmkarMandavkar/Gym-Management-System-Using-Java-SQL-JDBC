import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
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
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class TrainerData {

	public JFrame Trainerframe, frame;
	private JTable table2;
	private JLabel lblNewLabel;
	private JLabel lblContactNo;
	private JLabel lblHeight;
	private JLabel lblAddress;
	private JLabel lblGender;
	private JLabel lblSpecialization;
	private JLabel lblShift;
	private JLabel lblJoiningDate_1;
	private JLabel lblNewLabel_1;
	private JTextField txt_tname;
	private JTextField txt_tnum;
	private JTextField txt_taddress;
	private JTextField txt_tage;
	private JTextField txt_tjdate;
	private JTextField txt_tsrc;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainerData window = new TrainerData();
					window.Trainerframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public TrainerData() {
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

	public void table_load()									//******** TO VIEW TABLE ********//
	{
		try 
		{
			pst = con.prepareStatement("select * from trainerdata");
			rs = pst.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	}

	/********** Initialize the contents of the frame **********/

	private void initialize() {
		Trainerframe = new JFrame();
		Trainerframe.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/zeus_logo.jpg"));
		Trainerframe.setBounds(100, 100, 1000, 600);
		Trainerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Trainerframe.getContentPane().setLayout(null);
		Trainerframe.setLocationRelativeTo(null);
		Trainerframe.setTitle("ZEUS FITNESS");  

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRATION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 50, 964, 160);
		Trainerframe.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(80, 27, 80, 25);
		panel.add(lblNewLabel);

		lblContactNo = new JLabel("CONTACT NO.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo.setBounds(264, 27, 80, 25);
		panel.add(lblContactNo);

		lblHeight = new JLabel("AGE");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeight.setBounds(88, 101, 80, 25);
		panel.add(lblHeight);

		lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(500, 27, 80, 25);
		panel.add(lblAddress);

		lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(733, 27, 80, 25);
		panel.add(lblGender);

		txt_tname = new JTextField();
		txt_tname.setColumns(10);
		txt_tname.setBounds(124, 25, 95, 30);
		panel.add(txt_tname);

		txt_tnum = new JTextField();
		txt_tnum.setColumns(10);
		txt_tnum.setBounds(354, 25, 95, 30);
		panel.add(txt_tnum);

		txt_taddress = new JTextField();
		txt_taddress.setColumns(10);
		txt_taddress.setBounds(565, 25, 95, 30);
		panel.add(txt_taddress);

		txt_tage = new JTextField();
		txt_tage.setColumns(10);
		txt_tage.setBounds(124, 99, 95, 30);
		panel.add(txt_tage);

		txt_tjdate = new JTextField();
		txt_tjdate.setColumns(10);
		txt_tjdate.setBounds(354, 96, 95, 30);
		panel.add(txt_tjdate);

		lblSpecialization = new JLabel("SPECIALIZATION");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialization.setBounds(688, 101, 110, 25);
		panel.add(lblSpecialization);

		lblShift = new JLabel("SHIFT");
		lblShift.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblShift.setBounds(519, 101, 80, 25);
		panel.add(lblShift);

		lblJoiningDate_1 = new JLabel("JOINING DATE");
		lblJoiningDate_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJoiningDate_1.setBounds(264, 101, 100, 25);
		panel.add(lblJoiningDate_1);

		JComboBox<String> tgender_combo = new JComboBox<>();
		tgender_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Male", "Female", "Others"}));
		tgender_combo.setBounds(796, 25, 95, 30);
		panel.add(tgender_combo);

		JComboBox<String> tshift_combo = new JComboBox<>();
		tshift_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Morning", "Evening"}));
		tshift_combo.setBounds(565, 96, 95, 30);
		panel.add(tshift_combo);

		JComboBox<String> tspc_combo = new JComboBox<>();
		tspc_combo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Strength Training", "Weight Loss", "Bodybuilding", "Sports Performance", "Pain Management", "Exercise Physiologist", "Nutrition"}));
		tspc_combo.setBounds(796, 96, 135, 30);
		panel.add(tspc_combo);


		JButton btnNewButton = new JButton("SAVE");									//******** SAVE BUTTON ********//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, contact, address, gender, age, date, shift, specialization ;

				name = txt_tname.getText();
				contact = txt_tnum.getText();
				address = txt_taddress.getText();
				gender = tgender_combo.getSelectedItem().toString();
				age = txt_tage.getText();
				date = txt_tjdate.getText();
				shift = tshift_combo.getSelectedItem().toString();
				specialization = tspc_combo.getSelectedItem().toString();

				try {
					pst = con.prepareStatement("insert into trainerdata(Name, Contact_No, Address, Gender, Age, Joining_Date, Shift, Specialization)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, gender);
					pst.setString(5, age);
					pst.setString(6, date);
					pst.setString(7, shift);
					pst.setString(8, specialization);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					table_load();

					txt_tname.setText("");
					txt_tnum.setText("");
					txt_taddress.setText("");
					tgender_combo.setSelectedIndex(0);
					txt_tage.setText("");
					txt_tjdate.setText("");
					tshift_combo.setSelectedIndex(0);
					tspc_combo.setSelectedIndex(0);
					txt_tsrc.setText("");
					txt_tname.requestFocus();
				}
				catch (SQLException e1) 
				{            
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setBounds(85, 227, 90, 30);
		Trainerframe.getContentPane().add(btnNewButton);


		JButton btnNewButton_1 = new JButton("UPDATE");									//******** UPDATE BUTTON ********//
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, contact, address, gender, age, date, shift, specialization, id ;

				name = txt_tname.getText();
				contact = txt_tnum.getText();
				address = txt_taddress.getText();
				gender = tgender_combo.getSelectedItem().toString();
				age = txt_tage.getText();
				date = txt_tjdate.getText();
				shift = tshift_combo.getSelectedItem().toString();
				specialization = tspc_combo.getSelectedItem().toString();
				id = txt_tsrc.getText();

				try {
					pst = con.prepareStatement("update trainerdata set Name = ?, Contact_No = ?, Address = ?, Gender = ?, Age = ?, Joining_Date = ?, Shift = ?, Specialization = ? where id = ?");		

					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, gender);
					pst.setString(5, age);
					pst.setString(6, date);
					pst.setString(7, shift);
					pst.setString(8, specialization);
					pst.setString(9, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();

					txt_tname.setText("");
					txt_tnum.setText("");
					txt_taddress.setText("");
					tgender_combo.setSelectedIndex(0);
					txt_tage.setText("");
					txt_tjdate.setText("");
					tshift_combo.setSelectedIndex(0);
					tspc_combo.setSelectedIndex(0);
					txt_tsrc.setText("");
					txt_tname.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(260, 227, 90, 30);
		Trainerframe.getContentPane().add(btnNewButton_1);


		JButton btnNewButton_2 = new JButton("DELETE");									//******** DELETE BUTTON ********//
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id;
				id  = txt_tsrc.getText();

				try {
					pst = con.prepareStatement("delete from trainerdata where id =?");

					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
					table_load();

					txt_tname.setText("");
					txt_tnum.setText("");
					txt_taddress.setText("");
					tgender_combo.setSelectedIndex(0);
					txt_tage.setText("");
					txt_tjdate.setText("");
					tshift_combo.setSelectedIndex(0);
					tspc_combo.setSelectedIndex(0);
					txt_tsrc.setText("");
					txt_tname.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(435, 227, 90, 30);
		Trainerframe.getContentPane().add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(398, 268, 187, 52);
		Trainerframe.getContentPane().add(panel_1);

		JLabel lblContactNo_1 = new JLabel("ID :");
		lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo_1.setBounds(22, 14, 28, 25);
		panel_1.add(lblContactNo_1);


		txt_tsrc = new JTextField();									//******** SEARCH BUTTON ********//
		txt_tsrc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					String id = txt_tsrc.getText();
					pst = con.prepareStatement("select Name, Contact_No, Address, Gender, Age, Joining_Date, Shift, Specialization from trainerdata where id = ?");
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
						String shift = rs.getString(7);
						String specialization = rs.getString(8);

						txt_tname.setText(name);
						txt_tnum.setText(contact);
						txt_taddress.setText(address);
						tgender_combo.setSelectedItem(gender);
						txt_tage.setText(age);
						txt_tjdate.setText(date);
						tshift_combo.setSelectedItem(shift);
						tspc_combo.setSelectedItem(specialization);
					}   

					else
					{
						txt_tname.setText("");
						txt_tnum.setText("");
						txt_taddress.setText("");
						tgender_combo.setSelectedIndex(0);
						txt_tage.setText("");
						txt_tjdate.setText("");
						tshift_combo.setSelectedIndex(0);
						tspc_combo.setSelectedIndex(0);
						txt_tsrc.setText("");
					}
				} 

				catch (SQLException ex) {
				}		
			}
		});
		txt_tsrc.setColumns(10);
		txt_tsrc.setBounds(60, 13, 98, 28);
		panel_1.add(txt_tsrc);


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
		Trainerframe.getContentPane().add(btnExit);

		
		JButton btnMemberData = new JButton("MEMBER DATA");									//******** MEMBER DATA BUTTON ********//
		btnMemberData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trainerframe.dispose();
				MemberData x3 = new MemberData();
				x3.memberframe.setVisible(true); 
			}
		});
		btnMemberData.setBounds(785, 227, 120, 30);
		Trainerframe.getContentPane().add(btnMemberData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 964, 219);
		Trainerframe.getContentPane().add(scrollPane);

		table2 = new JTable();
		scrollPane.setViewportView(table2);

		lblNewLabel_1 = new JLabel("TRAINER PAGE");
		lblNewLabel_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(440, 11, 120, 35);
		Trainerframe.getContentPane().add(lblNewLabel_1);
	}
}