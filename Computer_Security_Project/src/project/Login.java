package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JButton;


public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame loginFrame;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		loginFrame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setBounds(100, 100, 450, 392);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel headerPanel = new Panel();
		headerPanel.setBackground(new Color(0, 115, 188));
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(48, 48, 247));
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginLabel.setForeground(new Color(30, 25, 39));
		GroupLayout groupLayout = new GroupLayout(loginFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
		);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(30, 25, 39));
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(new Color(30, 25, 39));
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton LoginButton = new JButton("LOGIN");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginButton.setBackground(new Color(0, 173, 121));
		
		JButton CancelButton = new JButton("CANCEL");
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel RegistrationLabel = new JLabel("Not Registered? Click here to create a new account!");
		RegistrationLabel.setForeground(new Color(30, 25, 39));
		RegistrationLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration registration = new Registration();
				registration.registrationFrame.setVisible(true);
				registration.registrationFrame.setLocationRelativeTo(null);
				registration.registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				loginFrame.dispose();
			}
		});
		RegistrationLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(RegistrationLabel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameLabel)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CancelButton))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(usernameTextField, Alignment.LEADING)
									.addComponent(passwordField, Alignment.LEADING, 213, 213, Short.MAX_VALUE)))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(CancelButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(RegistrationLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(new Color(30, 25, 39));
		closeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel minimizeLabel = new JLabel("-");
		minimizeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setState(JFrame.ICONIFIED);
			}
		});
		minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLabel.setForeground(new Color(30, 25, 39));
		minimizeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_headerPanel = new GroupLayout(headerPanel);
		gl_headerPanel.setHorizontalGroup(
			gl_headerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headerPanel.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
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
							.addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		headerPanel.setLayout(gl_headerPanel);
		loginFrame.getContentPane().setLayout(groupLayout);
	}
}
