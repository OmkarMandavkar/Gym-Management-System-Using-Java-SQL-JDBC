import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginPage {

	private JFrame loginframe;
	private JTextField textuname;
	private JTextField textpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/zeus_logo.jpg"));
		loginframe.setBounds(0, 0, 1000, 650);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		loginframe.setLocationRelativeTo(null);

		JLabel lblNewLabel_1 = new JLabel("WELCOME TO ZEUS FITNESS");
		lblNewLabel_1.setFont(new Font("Poppins Semibold", Font.BOLD, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 46, 984, 56);
		loginframe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(515, 215, 100, 30);
		loginframe.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(515, 291, 115, 30);
		loginframe.getContentPane().add(lblPassword);

		textuname = new JTextField();
		textuname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textuname.setBounds(645, 210, 186, 30);
		loginframe.getContentPane().add(textuname);
		textuname.setColumns(10);

		textpass = new JTextField();
		textpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textpass.setColumns(10);
		textpass.setBounds(645, 290, 186, 30);
		loginframe.getContentPane().add(textpass);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s1 = textuname.getText();
				String s2 = textpass.getText();

				if( s1.contains("Zeus") && s2.contains("Pass") ) {
					JOptionPane.showMessageDialog(loginframe, "Welcome to the System: " + s1);
					loginframe.setVisible(false);
					MemberData x1 = new MemberData();
					x1.memberframe.setVisible(true); 	
				}

				else if(!(s1.equals(s2))) {
					JOptionPane.showMessageDialog(loginframe, "C did not match our records !!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(567, 399, 90, 30);
		loginframe.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.setBounds(714, 399, 90, 30);
		loginframe.getContentPane().add(btnExit);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Images/mainframe.jpg"));
		lblNewLabel_2.setBounds(0, 0, 984, 611);
		loginframe.getContentPane().add(lblNewLabel_2);

		//JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("Images/mainframe.jpg"));
		//lblNewLabel.setBounds(0, 0, 984, 611);
		//loginframe.getContentPane().add(lblNewLabel);
	}
}
