package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class Welcome {

	private JFrame GUI;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField course1Field;
	private JTextField course2Field;
	private JTextField course3Field;
	private JTextField course4Field;
	private JTextField course5Field;
	private JTextField course6Field;
	private JTextField grade1Field;
	private JTextField grade2Field;
	private JTextField grade3Field;
	private JTextField grade4Field;
	private JTextField grade5Field;
	private JTextField grade6Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.GUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GUI = new JFrame();
		GUI.getContentPane().setBackground(Color.WHITE);
		GUI.setBackground(Color.WHITE);
		GUI.setBounds(100, 100, 1152, 648);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel welcomePanel = new JPanel();
		GUI.getContentPane().add(welcomePanel, "name_211259512205400");
		welcomePanel.setLayout(null);

		JPanel dashboardPanel = new JPanel();
		GUI.getContentPane().add(dashboardPanel, "name_212157125978200");
		dashboardPanel.setLayout(null);

		JPanel taskbarPanel = new JPanel();
		taskbarPanel.setBounds(0, 0, 210, 609);
		dashboardPanel.add(taskbarPanel);
		taskbarPanel.setLayout(null);

		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(210, 0, 926, 609);
		dashboardPanel.add(displayPanel);
		displayPanel.setLayout(new CardLayout(0, 0));

		JPanel introPanel = new JPanel();
		displayPanel.add(introPanel, "name_145715419535900");
		introPanel.setLayout(null);

		JPanel accountPanel = new JPanel();
		displayPanel.add(accountPanel, "name_146038955817600");
		accountPanel.setLayout(null);

		JPanel accountEditPanel = new JPanel();
		displayPanel.add(accountEditPanel, "name_88444699251600");
		accountEditPanel.setLayout(null);

		JPanel resultsPanel = new JPanel();
		displayPanel.add(resultsPanel, "name_89913177948100");
		resultsPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Welcome to app name");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Georgia", Font.PLAIN, 48));
		titleLabel.setBounds(0, 112, 1136, 95);
		welcomePanel.add(titleLabel);

		JLabel descriptionLabel = new JLabel("Description of app");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		descriptionLabel.setBounds(-10, 218, 1136, 150);
		welcomePanel.add(descriptionLabel);

		JButton quitButton = new JButton("Quit\r\n");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		quitButton.setBounds(585, 486, 150, 30);
		welcomePanel.add(quitButton);

		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		helpButton.setBounds(400, 486, 150, 30);
		welcomePanel.add(helpButton);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(616, 13, 80, 25);
		welcomePanel.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(876, 13, 80, 25);
		welcomePanel.add(passwordLabel);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(706, 13, 160, 25);
		welcomePanel.add(usernameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(966, 13, 160, 25);
		welcomePanel.add(passwordField);

		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});
		signInButton.setBounds(796, 49, 160, 25);
		welcomePanel.add(signInButton);

		JButton createAccountButton = new JButton("Create an account");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});
		createAccountButton.setBounds(966, 49, 160, 25);
		welcomePanel.add(createAccountButton);

		JLabel directionsLabel = new JLabel("Please sign in or create an account to continue");
		directionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		directionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		directionsLabel.setBounds(0, 380, 1136, 73);
		welcomePanel.add(directionsLabel);

		JLabel logoLabel = new JLabel("Logo");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(0, 20, 211, 35);
		taskbarPanel.add(logoLabel);

		JButton accountButton = new JButton("My Account");
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introPanel.setVisible(false);
				accountPanel.setVisible(true);
			}
		});
		accountButton.setBounds(25, 180, 160, 23);
		taskbarPanel.add(accountButton);

		JButton quizButton = new JButton("Take Quiz");
		quizButton.setBounds(25, 240, 160, 23);
		taskbarPanel.add(quizButton);

		JButton resultsButton = new JButton("View Results");
		resultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				resultsPanel.setVisible(true);
			}
		});
		resultsButton.setBounds(25, 300, 160, 23);
		taskbarPanel.add(resultsButton);

		JButton helpButton2 = new JButton("Help");
		helpButton2.setBounds(45, 500, 120, 23);
		taskbarPanel.add(helpButton2);

		JButton signOutButton = new JButton("Sign Out");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		signOutButton.setBounds(45, 550, 120, 23);
		taskbarPanel.add(signOutButton);

		JButton uniInfoButton = new JButton("University Information");
		uniInfoButton.setBounds(25, 116, 160, 23);
		taskbarPanel.add(uniInfoButton);

		JLabel titleLabel2 = new JLabel("App Name");
		titleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel2.setBounds(0, 33, 926, 90);
		introPanel.add(titleLabel2);

		JLabel quoteLabel = new JLabel("Quote");
		quoteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quoteLabel.setBounds(0, 158, 926, 76);
		introPanel.add(quoteLabel);

		JLabel creatorLabel = new JLabel("Created By:");
		creatorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		creatorLabel.setBounds(20, 550, 896, 59);
		introPanel.add(creatorLabel);

		JLabel personsLabel = new JLabel("Person's Account");
		personsLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		personsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personsLabel.setBounds(50, 30, 280, 65);
		accountPanel.add(personsLabel);

		JLabel courseCaptionLabel = new JLabel("Courses and Grades");
		courseCaptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseCaptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		courseCaptionLabel.setBounds(30, 130, 200, 75);
		accountPanel.add(courseCaptionLabel);

		JLabel course1Label = new JLabel("Course 1 + Grade");
		course1Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course1Label.setBounds(30, 216, 200, 40);
		accountPanel.add(course1Label);

		JLabel course2Label = new JLabel("Course 2 + Grade");
		course2Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course2Label.setBounds(30, 267, 200, 40);
		accountPanel.add(course2Label);

		JLabel course3Label = new JLabel("Course 3 + Grade");
		course3Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course3Label.setBounds(30, 318, 200, 40);
		accountPanel.add(course3Label);

		JLabel course4Label = new JLabel("Course 4 + Grade");
		course4Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course4Label.setBounds(30, 369, 200, 40);
		accountPanel.add(course4Label);

		JLabel course5Label = new JLabel("Course 5 + Grade");
		course5Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course5Label.setBounds(30, 420, 200, 40);
		accountPanel.add(course5Label);

		JLabel course6Label = new JLabel("Course 6 + Grade");
		course6Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course6Label.setBounds(30, 471, 200, 40);
		accountPanel.add(course6Label);

		JLabel proximityLabel = new JLabel("Proximity:");
		proximityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		proximityLabel.setBounds(330, 180, 75, 25);
		accountPanel.add(proximityLabel);

		JLabel cultureLabel = new JLabel("University Culture:");
		cultureLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cultureLabel.setBounds(330, 318, 150, 25);
		accountPanel.add(cultureLabel);

		JLabel tuitionLabel = new JLabel("Tuition:");
		tuitionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuitionLabel.setBounds(654, 180, 75, 25);
		accountPanel.add(tuitionLabel);

		JLabel uniSizeLabel = new JLabel("University Size:");
		uniSizeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uniSizeLabel.setBounds(654, 318, 150, 25);
		accountPanel.add(uniSizeLabel);

		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				accountEditPanel.setVisible(true);
			}
		});
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setBounds(750, 60, 100, 25);
		accountPanel.add(editButton);

		JLabel cultureValueLabel = new JLabel("Party");
		cultureValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cultureValueLabel.setBounds(330, 354, 150, 30);
		accountPanel.add(cultureValueLabel);

		JLabel proximityValueLabel = new JLabel("~ 50 km");
		proximityValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		proximityValueLabel.setBounds(330, 216, 150, 30);
		accountPanel.add(proximityValueLabel);

		JLabel tuitionValueLabel = new JLabel("~ $5,000");
		tuitionValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tuitionValueLabel.setBounds(654, 216, 150, 30);
		accountPanel.add(tuitionValueLabel);

		JLabel uniSizeValueLabel = new JLabel("~ 3,000");
		uniSizeValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uniSizeValueLabel.setBounds(654, 354, 150, 30);
		accountPanel.add(uniSizeValueLabel);

		JSlider proximitySlider = new JSlider();
		proximitySlider.setBounds(330, 210, 200, 30);
		accountEditPanel.add(proximitySlider);

		JLabel proximityLabel_1 = new JLabel("Proximity:");
		proximityLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		proximityLabel_1.setBounds(330, 180, 75, 25);
		accountEditPanel.add(proximityLabel_1);

		JLabel cultureLabel_1 = new JLabel("University Culture:");
		cultureLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cultureLabel_1.setBounds(330, 318, 150, 25);
		accountEditPanel.add(cultureLabel_1);

		JSlider tuitionSlider = new JSlider();
		tuitionSlider.setBounds(654, 210, 200, 30);
		accountEditPanel.add(tuitionSlider);

		JLabel tuitionLabel_1 = new JLabel("Tuition:");
		tuitionLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuitionLabel_1.setBounds(654, 180, 75, 25);
		accountEditPanel.add(tuitionLabel_1);

		JSlider uniSizeSlider = new JSlider();
		uniSizeSlider.setBounds(654, 348, 200, 30);
		accountEditPanel.add(uniSizeSlider);

		JLabel uniSizeLabel_1 = new JLabel("University Size:");
		uniSizeLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uniSizeLabel_1.setBounds(654, 318, 150, 25);
		accountEditPanel.add(uniSizeLabel_1);

		JComboBox cultureList = new JComboBox();
		cultureList.setBounds(330, 348, 200, 30);
		accountEditPanel.add(cultureList);

		JButton reverseEditButton = new JButton("Edit");
		reverseEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountEditPanel.setVisible(false);
				accountPanel.setVisible(true);
			}
		});
		reverseEditButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reverseEditButton.setBounds(750, 60, 100, 25);
		accountEditPanel.add(reverseEditButton);

		JLabel personsLabel_1 = new JLabel("Person's Account");
		personsLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		personsLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		personsLabel_1.setBounds(50, 30, 280, 65);
		accountEditPanel.add(personsLabel_1);

		JLabel courseCaptionLabel_1 = new JLabel("Courses and Grades");
		courseCaptionLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		courseCaptionLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseCaptionLabel_1.setBounds(30, 130, 200, 75);
		accountEditPanel.add(courseCaptionLabel_1);

		course1Field = new JTextField();
		course1Field.setBounds(30, 216, 120, 40);
		accountEditPanel.add(course1Field);
		course1Field.setColumns(10);

		course2Field = new JTextField();
		course2Field.setColumns(10);
		course2Field.setBounds(30, 267, 120, 40);
		accountEditPanel.add(course2Field);

		course3Field = new JTextField();
		course3Field.setColumns(10);
		course3Field.setBounds(30, 322, 120, 40);
		accountEditPanel.add(course3Field);

		course4Field = new JTextField();
		course4Field.setColumns(10);
		course4Field.setBounds(30, 373, 120, 40);
		accountEditPanel.add(course4Field);

		course5Field = new JTextField();
		course5Field.setColumns(10);
		course5Field.setBounds(30, 424, 120, 40);
		accountEditPanel.add(course5Field);

		course6Field = new JTextField();
		course6Field.setColumns(10);
		course6Field.setBounds(30, 475, 120, 40);
		accountEditPanel.add(course6Field);

		grade1Field = new JTextField();
		grade1Field.setColumns(10);
		grade1Field.setBounds(160, 216, 70, 40);
		accountEditPanel.add(grade1Field);

		grade2Field = new JTextField();
		grade2Field.setColumns(10);
		grade2Field.setBounds(160, 267, 70, 40);
		accountEditPanel.add(grade2Field);

		grade3Field = new JTextField();
		grade3Field.setColumns(10);
		grade3Field.setBounds(160, 322, 70, 40);
		accountEditPanel.add(grade3Field);

		grade4Field = new JTextField();
		grade4Field.setColumns(10);
		grade4Field.setBounds(160, 373, 70, 40);
		accountEditPanel.add(grade4Field);

		grade5Field = new JTextField();
		grade5Field.setColumns(10);
		grade5Field.setBounds(160, 424, 70, 40);
		accountEditPanel.add(grade5Field);

		grade6Field = new JTextField();
		grade6Field.setColumns(10);
		grade6Field.setBounds(160, 475, 70, 40);
		accountEditPanel.add(grade6Field);

		JLabel title3Label = new JLabel("Application Name/Logo");
		title3Label.setFont(new Font("Tahoma", Font.PLAIN, 48));
		title3Label.setHorizontalAlignment(SwingConstants.CENTER);
		title3Label.setBounds(0, 29, 926, 81);
		resultsPanel.add(title3Label);

		JLabel resultsLabel = new JLabel("Your Results");
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resultsLabel.setBounds(0, 121, 926, 25);
		resultsPanel.add(resultsLabel);

		JLabel captionLabel = new JLabel("Based on your answers, the following programs are best suited for you");
		captionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setBounds(0, 157, 926, 25);
		resultsPanel.add(captionLabel);

		JLabel uniLabel = new JLabel("#1 Institution Name");
		uniLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uniLabel.setBounds(30, 193, 150, 25);
		resultsPanel.add(uniLabel);

		JLabel uni2Label = new JLabel("#2 Institution Name");
		uni2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uni2Label.setBounds(30, 385, 150, 25);
		resultsPanel.add(uni2Label);

		JLabel uni3Label = new JLabel("#3 Institution Name");
		uni3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uni3Label.setBounds(509, 385, 150, 25);
		resultsPanel.add(uni3Label);

		JLabel averageLabel = new JLabel("Admission Average:");
		averageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		averageLabel.setBounds(30, 260, 250, 25);
		resultsPanel.add(averageLabel);

		JLabel average2Label = new JLabel("Admission Average:");
		average2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		average2Label.setBounds(30, 421, 250, 25);
		resultsPanel.add(average2Label);

		JLabel average3Label = new JLabel("Admission Average:");
		average3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		average3Label.setBounds(509, 421, 250, 25);
		resultsPanel.add(average3Label);

		JLabel coursesLabel = new JLabel("Courses Required:");
		coursesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		coursesLabel.setBounds(30, 320, 250, 25);
		resultsPanel.add(coursesLabel);

		JLabel courses2Label = new JLabel("Courses Required:");
		courses2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		courses2Label.setBounds(30, 457, 250, 25);
		resultsPanel.add(courses2Label);

		JLabel courses3Label = new JLabel("Courses Required:");
		courses3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		courses3Label.setBounds(509, 457, 250, 25);
		resultsPanel.add(courses3Label);

		JLabel distanceLabel = new JLabel("Distance:");
		distanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distanceLabel.setBounds(409, 260, 250, 25);
		resultsPanel.add(distanceLabel);

		JLabel programTuitionLabel = new JLabel("Tuition (Annually):");
		programTuitionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		programTuitionLabel.setBounds(409, 320, 250, 25);
		resultsPanel.add(programTuitionLabel);

		JLabel distance2Label = new JLabel("Distance:");
		distance2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distance2Label.setBounds(30, 493, 250, 25);
		resultsPanel.add(distance2Label);

		JLabel programTuition2Label = new JLabel("Tuition (Annually):");
		programTuition2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		programTuition2Label.setBounds(30, 529, 250, 25);
		resultsPanel.add(programTuition2Label);

		JLabel distance3Label = new JLabel("Distance:");
		distance3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distance3Label.setBounds(509, 493, 250, 25);
		resultsPanel.add(distance3Label);

		JLabel programTuition3Label = new JLabel("Tuition (Annually):");
		programTuition3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		programTuition3Label.setBounds(509, 536, 250, 25);
		resultsPanel.add(programTuition3Label);
	}
}
