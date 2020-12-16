
package guiClasses;

import objects.UniversitiesInformation;
import objects.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllPrograms extends JPanel implements ActionListener {
	UniversitiesInformation uniClass = new UniversitiesInformation();
	private JLabel title = new JLabel("All Programs");
	private JButton nextBtn = new JButton();
	private JButton backBtn = new JButton();
	private JComboBox<String> combobox1 = new JComboBox<>();
	private JComboBox<String> combobox2 = new JComboBox<>();
	private JLabel sortBy = new JLabel("Sort by:");
	private JLabel picture = new JLabel();
	private ArrayList<University> uniArrayCopy = uniClass.getUniversities();
	private int currentPage = 0;
	private boolean reversed = false;
	private int oldLocation = 0;
	private JTextField keyword = new JTextField();
	private JButton searchButton = new JButton("Search");
	private JLabel searchLabel = new JLabel("Search");
	private JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 14);
	private String[] sorting = new String[] { "Alpha: A-Z", "Alpha: Z-A", "Average: Low to High",
			"Average: High to Low" };
	private String info = "insert info about uni ~~this uni was founded in xxxx~~";
	private JPanel uniPanel;
	public static JPanel overallPanel = new JPanel();
	private ImageIcon[] icons = new ImageIcon[14];
	private boolean resetPage = false;
	private String[] names = new String[14];
	private ArrayList<University> customList = new ArrayList<>(14);

	public AllPrograms() {

		setIcons();

		overallPanel.setBounds(210, 0, 920, 610);
		overallPanel.setLayout(null);
		overallPanel.setVisible(true);

		uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), uniArrayCopy.get(0).getDescription());
		uniPanel.setBounds(500, 0, 400, 300);
		overallPanel.add(uniPanel);
		uniPanel.setVisible(true);

		for (University uni : uniArrayCopy) {
			combobox1.addItem(uni.getName());
		}

		picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/Carleton University.jpg"));
		picture.setBounds(50, 300, 700, 500);
		overallPanel.add(picture);

		combobox1.setBounds(50, 50, 200, 40);
		combobox1.addActionListener(this);
		combobox1.setVisible(true);
		overallPanel.add(combobox1);

		for (String sorting : sorting) {
			combobox2.addItem(sorting);
		}
		combobox2.setBounds(50, 120, 200, 50);
		combobox2.addActionListener(this);
		combobox2.setVisible(true);
		overallPanel.add(combobox2);

		sortBy.setBounds(50, 90, 100, 30);
		sortBy.setVisible(true);
		overallPanel.add(sortBy);

		title.setBounds(50, 0, 200, 50);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		overallPanel.add(title);

		nextBtn.setText("Next");
		nextBtn.setBounds(50, 200, 100, 50);
		nextBtn.addActionListener(this);
		nextBtn.setVisible(true);
		overallPanel.add(nextBtn);

		backBtn.setText("Back");
		backBtn.setBounds(150, 200, 100, 50);
		backBtn.addActionListener(this);
		backBtn.setVisible(true);
		overallPanel.add(backBtn);

		keyword.setBounds(300, 60, 150, 40);
		keyword.addActionListener(this);
		overallPanel.add(keyword);

		searchLabel.setBounds(300, 30, 50, 30);
		overallPanel.add(searchLabel);

		searchButton.setBounds(300, 100, 100, 35);
		searchButton.addActionListener(this);
		overallPanel.add(searchButton);

		setVisible(true);
	}

	// Override Method
	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == combobox2) {

			if (combobox2.getSelectedIndex() == 0) { // if its A-Z
				uniArrayCopy = uniClass.getUniversities();
				currentPage = 0;
				reversed = false;
			} else if (combobox2.getSelectedIndex() == 1) { // if its Z-A
				uniArrayCopy = uniClass.getUniversities();
				reverse();
				currentPage = 0;
				reversed = true;
			}

			else if (combobox2.getSelectedIndex() == 2 || combobox2.getSelectedIndex() == 3) { // Low to High, Average
				uniArrayCopy = uniClass.getUniversities();
				insertionSort();
				if (combobox2.getSelectedIndex() == 3) {
					uniArrayCopy = uniClass.getUniversities();
					insertionSort();
					reverse();
					reversed = true;
				}
				currentPage = 0;
			}

			resetPage = true;
			remove(uniPanel);
			uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), uniArrayCopy.get(0).getDescription());
			uniPanel.setBounds(800, 0, 400, 300);
			uniPanel.repaint();

			add(uniPanel);
			uniPanel.setVisible(true);
			picture.setIcon(uniArrayCopy.get(currentPage).getIcon());
			picture.setVisible(true);
			repaint();
		}

		if (event.getSource() == combobox1) {
			reversed = false;
			int comboboxIndex = combobox1.getSelectedIndex();
			if (reversed) {
				comboboxIndex = 13 - comboboxIndex;
			}
			remove(uniPanel);
			uniPanel = createUniPanel(uniArrayCopy.get(comboboxIndex).getName(),
					uniArrayCopy.get(comboboxIndex).getDescription());
			uniPanel.setBounds(800, 0, 500, 500);

			scrollBar.setValue(comboboxIndex);
			currentPage = comboboxIndex;
			uniPanel.repaint();
			uniPanel.setVisible(true);
			add(uniPanel);
			picture.setIcon(uniArrayCopy.get(comboboxIndex).getIcon());
			picture.setVisible(true);
			repaint();
		}
		if (event.getSource() == nextBtn) {
			System.out.println(reversed);
			currentPage += 1;
			if (currentPage == 14) {
				currentPage = 0;
			}
			if (currentPage == -1) {
				currentPage = 13;
			}
			System.out.println(currentPage);
			remove(uniPanel);
			uniPanel = createUniPanel(uniArrayCopy.get(currentPage).getName(),
					uniClass.getUniversities().get(currentPage).getDescription());
			uniPanel.setBounds(800, 0, 400, 300);
			uniPanel.setVisible(true);
			add(uniPanel);
			picture.setIcon(uniArrayCopy.get(currentPage).getIcon());
			picture.setVisible(true);
			repaint();
		}

		if (event.getSource() == backBtn) {

			currentPage -= 1;
			if (currentPage == -1) {
				currentPage = 13;
			}
			if (currentPage == 14) {
				currentPage = 0;
			}
			remove(uniPanel);
			uniPanel = createUniPanel(uniArrayCopy.get(currentPage).getName(),
					uniArrayCopy.get(currentPage).getDescription());

			uniPanel.setBounds(800, 0, 400, 300);
			uniPanel.setVisible(true);
			add(uniPanel);
			picture.setIcon(uniArrayCopy.get(currentPage).getIcon());

			picture.setVisible(true);
			repaint();
		}

		if (event.getSource() == searchButton) {
			String text = keyword.getText();
		}
	}

	public void reverse() {
		ArrayList<University> temp = new ArrayList<University>(14);

		for (int i = uniArrayCopy.size(); i > 0; i--) {
			temp.add(uniArrayCopy.get(i - 1));
		}
		uniArrayCopy = temp;
	}

	public JPanel createUniPanel(String name, String info) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(300, 500);
		JLabel nameLabel = new JLabel(name);
		JLabel infoLabel = new JLabel("<html>" + info + "<html>");

		nameLabel.setBounds(0, 0, 500, 80);
		nameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		infoLabel.setBounds(0, 50, 300, 350);
		infoLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 12));
		panel.setOpaque(false);
		panel.add(nameLabel);
		panel.add(infoLabel);

		return panel;

	}

	public void insertionSort() {
		// Runs for every index of the array except the first
		for (int x = 1; x < uniArrayCopy.size(); x++) {
			/*
			 * In the for loop below it will... take the value in the index x (which is one
			 * greater in each iteration) and continue to "shift" it until the value is
			 * greater than the value of the contents in index y thus moving it into its
			 * sorted place in the array
			 */
			for (int y = x - 1; y >= 0; y--) {
				if (uniArrayCopy.get(x).getAverage() < uniArrayCopy.get(y).getAverage()) {
					swap(uniArrayCopy, x--, y);
				} else {
					break;
				}
			}
		}

	}

	public void swap(ArrayList<University> universities, int x, int smallest) {
		University temp = universities.get(x);
		universities.set(x, universities.get(smallest));
		universities.set(smallest, temp);
	}

	public void setIcons() {
		for (int i = 0; i < 14; i++) {
			names[i] = uniArrayCopy.get(i).getName();
		}
	}
}