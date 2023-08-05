import java.awt.*;          //In-Built Packages and sub-packages
import java.awt.event.*;
import javax.swing.*;

class pageone extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel l1, l2, l3,  bg;
	Font fn, fn1, fn2;
	JTextField tf1, tf2;
	JButton b1,b2;
	ImageIcon img;

	pageone()                                          // Constructor
	{
		setTitle("ZEUS FITNESS");                               // set Title

		img = new ImageIcon("Images/2904.jpg");       //background-image

		bg = new JLabel("", img, JLabel.CENTER);        //BG-image set size
		bg.setBounds(0, 0, 1000, 650);

		fn = new Font("Times New Roman", Font.PLAIN, 20);   //font styles
		fn1 = new Font("Centeria Script", Font.BOLD, 45);
		fn2 = new Font("Times New Roman", Font.PLAIN, 17);

		l1 = new JLabel();
		l1.setText("USERNAME :");
		l1.setBounds(500, 200, 250, 40);
		l1.setFont(fn);

		l2 = new JLabel();
		l2.setText("PASSWORD :");
		l2.setBounds(500, 280, 250, 40);
		l2.setFont(fn);

		l3 = new JLabel();
		l3.setText(" WELCOME TO ZEUS FITNESS ");
		l3.setBounds(150, 50, 900, 100);
		l3.setFont(fn1);

		tf1 = new JTextField();
		tf1.setBounds(630, 200, 250, 35);
		tf1.setFont(fn);

		tf2 = new JTextField();
		tf2.setBounds(630, 280, 250, 35);
		tf2.setFont(fn);

		b1 = new JButton("Login");
		b1.setBounds(550, 380, 120, 30);
		b1.setFont(fn2);

		b2 = new JButton("Exit");
		b2.setBounds(720, 380, 120, 30);
		b2.setFont(fn2);

		bg.add(l1);
		bg.add(l2);
		bg.add(l3);
		bg.add(tf1);
		bg.add(tf2);
		add(bg);
		bg.add(b1);
		bg.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);

		setSize(1000, 650);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// end of pageone constructor 

	public void actionPerformed(ActionEvent e)          //Action-Listener
	{    
		String s1 = tf1.getText();
		String s2 = tf2.getText();


		if(e.getSource()==b1) {

			if( s1.contains("Zeus") && s2.contains("Pass") ) {
				JOptionPane.showMessageDialog(bg,"Welcome to the System: " + s1);
				setVisible(false);
				memberdata x1 = new memberdata();
				x1.memberframe.setVisible(true); 	
			}

			else if(!(s1.equals(s2))) {
				JOptionPane.showMessageDialog(bg,"Enter proper credentials !!");
			}
		}

		if(e.getSource()==b2)                           //EXIT- Button logic
		{	 System.exit(0); 	}

	} // end of actionperformed 
} // end of pageone class

class loginpage
{
	public static void main (String args[])
	{
		new pageone();
	} //end of main
} //end of miniprojectjava class