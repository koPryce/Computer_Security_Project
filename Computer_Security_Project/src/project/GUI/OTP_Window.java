package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import project.Database.DBConnection;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OTP_Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JPasswordField passwordField;
	private Timer timer;
	int seconds, minutes;
	String formatSeconds, formatMinutes;
	DecimalFormat decimalFormat = new DecimalFormat("00");
	private JLabel counterLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OTP_Window window = new OTP_Window();
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
	public OTP_Window() {
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
		
		JLabel lblWelcomeXyzManufactoring = new JLabel("One Time Password");
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
		panel_1.setBounds(0, 46, 814, 376);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("OTP was sent to your phone.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Boolean validate = DBConnection.validateOTP(passwordField.getText());
				Boolean status = DBConnection.getOTPStatus(DBConnection.getOTPID());
				if(validate) {
					if(!status) {
						DBConnection.updateOTPStatus("Used", DBConnection.getOTPID());
						Success_Window sw = new Success_Window();
						sw.frame.setVisible(true);
						sw.frame.setLocationRelativeTo(null);
						sw.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(btnOk, "OTP expired!");
					}
				}else {
					JOptionPane.showMessageDialog(btnOk, "Incorrect OTP entered");
				}
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		
		JLabel backButtonLabel = new JLabel("BACK");
		backButtonLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.loginFrame.setVisible(true);
				login.loginFrame.pack();
				login.loginFrame.setLocationRelativeTo(null);
				login.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		backButtonLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		counterLabel = new JLabel();
		counterLabel.setForeground(Color.RED);
		counterLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		counterLabel.setText("00:10");
		seconds = 10;
		minutes = 0;
		displayTimer();
		timer.start();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(218)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, 286, 286, 286)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
					.addGap(78)
					.addComponent(counterLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(backButtonLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(counterLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(backButtonLabel)
					.addGap(25))
		);
		panel_1.setLayout(gl_panel_1);
	}

	private void displayTimer() {
		timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				seconds --;
				formatSeconds = decimalFormat.format(seconds);
				formatMinutes = decimalFormat.format(minutes);
				counterLabel.setText(formatMinutes + ":" + formatSeconds);
				
				if(seconds == -1) {
					seconds = 59;
					minutes --;
					formatSeconds = decimalFormat.format(seconds);
					formatMinutes = decimalFormat.format(minutes);
					counterLabel.setText(formatMinutes + ":" + formatSeconds);
				}
				
				if(minutes == 0 && seconds == 0) {
					timer.stop();
					DBConnection.updateOTPStatus("Used", DBConnection.getOTPID());
					Login login = new Login();
					login.loginFrame.setVisible(true);
					login.loginFrame.pack();
					login.loginFrame.setLocationRelativeTo(null);
					login.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.dispose();
				}
			}
		});
		
	}
}
