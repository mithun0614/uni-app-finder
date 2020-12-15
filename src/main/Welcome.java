package main;

import tools.Colour;

import javax.swing.*;

import java.awt.Font;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Welcome {

	public static JFrame GUI;
	public static JPanel welcomePanel;
	public static JTextField usernameField;
	public static JPasswordField passwordField;

	/*
	 * @wbp.parser.entryPoint
	 * ^^ Allows me to use window builder
	 */
	public static void CreateWelcome() {

		// Create JFrame
		GUI = new JFrame();
		GUI.getContentPane().setBackground(Color.WHITE);
		GUI.setBounds(100, 100, 1152, 648);
		GUI.getContentPane().setLayout(new CardLayout(0, 0));
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create Welcome JPanel
		welcomePanel = new JPanel();
		welcomePanel.setLayout(null);
		welcomePanel.setBackground(Colour.bg);
		GUI.getContentPane().add(welcomePanel);

		ImageIcon programLogo = new ImageIcon("./resources/misc/program-logo.png");

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(programLogo.getImage().getScaledInstance(programLogo.getIconWidth()/3, programLogo.getIconHeight()/3, 0)));
		logo.setBounds(50, 175, 600, 300);
		welcomePanel.add(logo);

		// Create title label
		JLabel titleLabel = new JLabel("Welcome to");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Georgia", Font.PLAIN, 36));
		titleLabel.setForeground(Colour.highlight);
		titleLabel.setBounds(75, 50, 500, 100);
		welcomePanel.add(titleLabel);

		// Create username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setForeground(Colour.highlight);
		usernameLabel.setBounds(725, 100, 80, 25);
		welcomePanel.add(usernameLabel);

		// Create username textbox
		usernameField = new JTextField();
		usernameField.setBounds(725, 150, 300, 25);
		welcomePanel.add(usernameField);

		// Create password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setForeground(Colour.highlight);
		passwordLabel.setBounds(725, 200, 80, 25);
		welcomePanel.add(passwordLabel);

		// Create password textbox
		passwordField = new JPasswordField();
		passwordField.setBounds(725, 250, 300, 25);
		welcomePanel.add(passwordField);

		// Create sign in button
		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (VerifyLogin.verifyLogin(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
					welcomePanel.setVisible(false);
					Dashboard.CreateDashboard();
					Dashboard.dashboardPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(welcomePanel, "Invalid Login");
				}
			}
		});
		signInButton.setForeground(Colour.strongHighlight);
		signInButton.setBackground(Colour.lightBg);
		signInButton.setBorderPainted(false);
		signInButton.setFocusPainted(false);
		/*
		goToMap.setText("BACK");
        goToMap.setFont(new Font("Tahoma", Font.PLAIN, 32));
        goToMap.setBounds(775, 500, 100, 50);
        goToMap.setForeground(highlight);
        goToMap.setBackground(strongHighlight);
        goToMap.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        goToMap.setBorderPainted(false);
        goToMap.setFocusPainted(false);
        goToMap.addActionListener(this);
        distancePanel.add(goToMap);
		 */
		signInButton.setBounds(725, 300, 300, 30);
		welcomePanel.add(signInButton);

		// Create create account button
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount();
				
			}
		});
		createAccountButton.setForeground(Colour.highlight);
		createAccountButton.setBackground(Colour.strike);
		createAccountButton.setBorderPainted(false);
		createAccountButton.setFocusPainted(false);
		createAccountButton.setBounds(725, 350, 300, 30);
		welcomePanel.add(createAccountButton);

		// Create help button
		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		helpButton.setBounds(725, 450, 140, 30);
		welcomePanel.add(helpButton);

		// Create quit button
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		quitButton.setBounds(885, 450, 140, 30);
		welcomePanel.add(quitButton);

	}
}
