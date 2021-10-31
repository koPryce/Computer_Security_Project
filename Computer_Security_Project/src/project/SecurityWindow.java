package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecurityWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityWindow window = new SecurityWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecurityWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 827, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 115, 188));
		panel.setBounds(0, 0, 814, 50);
		frame.getContentPane().add(panel);
		
		JLabel lblWelcomeXyzManufactoring = new JLabel("Choose your mode of Security Confirmation");
		lblWelcomeXyzManufactoring.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeXyzManufactoring.setForeground(new Color(30, 25, 39));
		lblWelcomeXyzManufactoring.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(30, 25, 39));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("X");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(30, 25, 39));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addComponent(lblWelcomeXyzManufactoring, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWelcomeXyzManufactoring, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(48, 48, 247));
		panel_1.setBounds(0, 46, 814, 452);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("QR CODE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registration = new Registration();
				registration.registrationFrame.setVisible(true);
				registration.registrationFrame.setLocationRelativeTo(null);
				registration.registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		
		JButton btnLogIn = new JButton("One Time Password (OTP)");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.loginFrame.setVisible(true);
				login.loginFrame.pack();
				login.loginFrame.setLocationRelativeTo(null);
				login.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(253)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(93)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
