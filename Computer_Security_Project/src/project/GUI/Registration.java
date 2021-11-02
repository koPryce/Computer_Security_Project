package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame registrationFrame;
	private JPasswordField passwordField;
	private JTextField firstNameTextField;
	private JTextField emailtextField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.registrationFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registrationFrame = new JFrame();
		registrationFrame.setBounds(100, 100, 838, 480);
		registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrationFrame.getContentPane().setLayout(null);
		
		Panel headerPanel = new Panel();
		headerPanel.setBackground(new Color(0, 115, 188));
		headerPanel.setBounds(0, 0, 822, 50);
		registrationFrame.getContentPane().add(headerPanel);
		
		JLabel registrationLabel = new JLabel("Registration");
		registrationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registrationLabel.setForeground(new Color(30, 25, 39));
		registrationLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel minimizeLabel = new JLabel("-");
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrationFrame.setState(JFrame.ICONIFIED);
			}
		});
		minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLabel.setForeground(new Color(30, 25, 39));
		minimizeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(new Color(30, 25, 39));
		closeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_headerPanel = new GroupLayout(headerPanel);
		gl_headerPanel.setHorizontalGroup(
			gl_headerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headerPanel.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addComponent(registrationLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(224)
					.addComponent(minimizeLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
		);
		gl_headerPanel.setVerticalGroup(
			gl_headerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_headerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_headerPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(minimizeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(registrationLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		headerPanel.setLayout(gl_headerPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(48, 48, 247));
		panel.setBounds(0, 48, 822, 395);
		registrationFrame.getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setForeground(new Color(30, 25, 39));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean emailFlag = false, passwordFlag = false;
				String emailString = emailtextField.getText();
				String [] splitEmail = emailString.split("@");
				if(!splitEmail[1].equals("gmail.com")) {
					JOptionPane.showMessageDialog(btnRegister, "The email entered cannot be used. Please use an email ending with 'gmail.com'.");
				}else {
					emailFlag = true;
				}

				String p1 = passwordField.getText(),p2 = passwordField_1.getText();
				if(!p1.equals(p2)) {
					JOptionPane.showMessageDialog(btnRegister, "Passwords do not match.");
				}
				else {
					passwordFlag = true;
				}
				if(emailFlag == true && passwordFlag == true) {
					SecurityWindow sw = new SecurityWindow();
					sw.frame.setVisible(true);
					sw.frame.setLocationRelativeTo(null);
					sw.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					registrationFrame.dispose();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBackground(new Color(0, 173, 121));
		
		JButton button_1 = new JButton("CANCEL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameTextField.setText(null);
				emailtextField.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(new Color(30, 25, 39));
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		firstNameTextField = new JTextField();
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameTextField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(new Color(30, 25, 39));
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(new Color(30, 25, 39));
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		emailtextField = new JTextField();
		emailtextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailtextField.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(new Color(30, 25, 39));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setForeground(new Color(30, 25, 39));
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAlreadyRegisterClick = new JLabel("Already Registered? Click here to login!");
		lblAlreadyRegisterClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.loginFrame.setVisible(true);
				login.loginFrame.pack();
				login.loginFrame.setLocationRelativeTo(null);
				login.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				registrationFrame.dispose();
			}
		});
		lblAlreadyRegisterClick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(306)
					.addComponent(lblAlreadyRegisterClick, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(404))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addGap(32)
								.addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblEmailAddress, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(emailtextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(48)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRetypePassword)
								.addComponent(lblPhoneNumber)
								.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_3)
								.addComponent(passwordField_1)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblEmailAddress, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(emailtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRetypePassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(83)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(lblAlreadyRegisterClick, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel.setLayout(gl_panel);
	}
}