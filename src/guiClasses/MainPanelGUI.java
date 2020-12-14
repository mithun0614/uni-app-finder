package guiClasses;

import main.BookmarkedUniversities;
import main.UniversitiesInformation;
import main.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class MainPanelGUI extends JFrame implements ActionListener, AdjustmentListener{
    public static JLabel title = new JLabel("All Programs");
    public static JButton nextBtn = new JButton();
    public static JButton backBtn = new JButton();
    public static JComboBox<String> combobox1 = new JComboBox<>();
    public static JComboBox<String> combobox2 = new JComboBox<>();
    public static JLabel sortBy = new JLabel("Sort by:");
    public static JLabel picture = new JLabel();
    public static ArrayList<University> uniArrayCopy = UniversitiesInformation.universities;
    public static int currentPage = 0;
    public static boolean reversed = false;
    private static int oldLocation = 0;
    private static JTextField keyword = new JTextField();
    private static JButton searchButton = new JButton("Search");
    private JLabel searchLabel = new JLabel("Search");
    private JButton bookmarkBtn = new JButton("Bookmark University");
    private JButton bookmarkedBtn = new JButton("University Bookmarked");

    public static JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL,0,1,0,14);
    String[] sorting = new String[]{"Alpha: A-Z", "Alpha: Z-A", "Average: Low to High", "Average: High to Low"};
    String info = "insert info about uni ~~this uni was founded in xxxx~~";
    JPanel uniPanel;

    public MainPanelGUI() {
        UniversitiesInformation.setUniversities();

        setSize(1152, 864);
        setLayout(null);


        uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), info);
        uniPanel.setBounds(800, 0, 400, 400);
        add(uniPanel);
        uniPanel.setVisible(true);

        for (University uni : uniArrayCopy) {
            combobox1.addItem(uni.getName());
        }

        picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/Carleton University.jpg"));
        picture.setBounds(300,300,700,500);
        picture.setVisible(true);
        add(picture);

        combobox1.setBounds(350, 50, 200, 40);
        combobox1.addActionListener(this);
        combobox1.setVisible(true);
        add(combobox1);

        for (String sorting : sorting) {
            combobox2.addItem(sorting);
        }
        combobox2.setBounds(350, 120, 200, 50);
        combobox2.addActionListener(this);
        combobox2.setVisible(true);
        add(combobox2);

        sortBy.setBounds(350,90,100,30);
        sortBy.setVisible(true);
        add(sortBy);

        title.setBounds(350, 0, 200, 50);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        add(title);


        scrollBar.setBounds(565,50,30,120);
        scrollBar.addAdjustmentListener((AdjustmentListener) this);
        add(scrollBar);

        keyword.setBounds(600, 60, 150,40);
        keyword.addActionListener(this);
        add(keyword);

        searchLabel.setBounds(600,30,50,30);
        add(searchLabel);

        searchButton.setBounds(600,100,100,35);
        searchButton.addActionListener(this);
        add(searchButton);

        bookmarkSection();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Override Method
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == combobox2) {


            if (combobox2.getSelectedIndex() == 0) {            // if its A-Z
                uniArrayCopy = UniversitiesInformation.universities;
                currentPage = 0;
            }
            else if (combobox2.getSelectedIndex() == 1) {                //if its Z-A
                uniArrayCopy = UniversitiesInformation.universities;
                reverse();
                currentPage = 0;
            }


            else if (combobox2.getSelectedIndex() == 2 || combobox2.getSelectedIndex() == 3) {                //Low to High, Average
                uniArrayCopy = UniversitiesInformation.universities;
                insertionSort();
                if (combobox2.getSelectedIndex() == 3) {
                    uniArrayCopy = UniversitiesInformation.universities;
                    insertionSort();
                    reverse();
                }
                currentPage = 0;
            }


            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), info);
            picture.setIcon(new ImageIcon("resources/uniPictures/"+uniArrayCopy.get(0).getName()+".jpg"));
            picture.repaint();
            uniPanel.setBounds(800,0,500,500);
            uniPanel.repaint();

            add(uniPanel);
            uniPanel.setVisible(true);

            repaint();
        }
        int comboboxIndex = combobox1.getSelectedIndex();
        if (reversed) {
            comboboxIndex = 13 - comboboxIndex;
        }

        if (event.getSource() == combobox1) {
            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(comboboxIndex).getName(), info);
            picture.setIcon(new ImageIcon("resources/uniPictures/"+uniArrayCopy.get(comboboxIndex).getName()+" .jpg"));
            picture.setVisible(true);
            add(picture);
            picture.repaint();

            uniPanel.setBounds(800,0,500,500);
            currentPage = comboboxIndex;
            uniPanel.repaint();
            uniPanel.setVisible(true);
            add(uniPanel);

            repaint();
        }

        if (event.getSource() == searchButton) {
            String text = keyword.getText();
        }
        
        if (event.getSource() == bookmarkBtn) {
        	remove(bookmarkBtn);
        	bookmarkedBtn.setBounds(50, 350, 150, 50);
        	add(bookmarkedBtn);
        	bookmarkedBtn.addActionListener(this);
        	BookmarkedUniversities.editBookmarks(UniversitiesInformation.universities.get(currentPage), 0);
        }
        
        if (event.getSource() == bookmarkedBtn) {
        	remove(bookmarkedBtn);
        	bookmarkBtn.setBounds(50, 350, 150, 50);
        	add(bookmarkBtn);
        	bookmarkBtn.addActionListener(this);
        	BookmarkedUniversities.editBookmarks(UniversitiesInformation.universities.get(currentPage), 1);
        }
    }

    static void reverse() {
        ArrayList<University> temp = new ArrayList<University>(14);

        for (int i = uniArrayCopy.size(); i > 0; i--) {
            temp.add(uniArrayCopy.get(i-1));
        }
        uniArrayCopy = temp;
    }
    
    public void bookmarkSection() {
    	JLabel bookmarkTitle = new JLabel();
    	JLabel cutoff = new JLabel();
    	JLabel admissionAverage = new JLabel();
    	JLabel tuition = new JLabel();
    	JLabel classSize = new JLabel();
    	
    	bookmarkTitle.setText(UniversitiesInformation.universities.get(currentPage).getName() + " Information");
    	bookmarkTitle.setBounds(50, 100, 200, 50);
    	add(bookmarkTitle);
    	
    	cutoff.setText("Cutoff: " + UniversitiesInformation.universities.get(currentPage).getCutoff() + "%");
    	cutoff.setBounds(50, 150, 200, 50);
    	add(cutoff);
    	
    	admissionAverage.setText("Admission Average: " + UniversitiesInformation.universities.get(currentPage).getAverage() + "%");
    	admissionAverage.setBounds(50, 200, 200, 50);
    	add(admissionAverage);
    	
    	tuition.setText("Tuition: $" + UniversitiesInformation.universities.get(currentPage).getTuition());
    	tuition.setBounds(50, 250, 150, 50);
    	add(tuition);
    	
    	classSize.setText("Average Class Size: " + UniversitiesInformation.universities.get(currentPage).getClassSize());
    	classSize.setBounds(50, 300, 150, 50);
    	add(classSize);
    	
    	bookmarkBtn.setBounds(50, 350, 150, 50);
    	add(bookmarkBtn);
    	bookmarkBtn.addActionListener(this);
    	
    }


    public static JPanel createUniPanel(String name, String info) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300, 300);
        JLabel nameLabel = new JLabel(name);
        JLabel infoLabel = new JLabel(info);

        nameLabel.setBounds(0, 0, 500, 150);
        nameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        infoLabel.setBounds(0, 50, 500, 150);
        panel.add(nameLabel);
        panel.add(infoLabel);

        return panel;

    }

    public static void insertionSort() {
        //Runs for every index of the array except the first
        for (int x = 1; x < uniArrayCopy.size(); x++) {
            /* In the for loop below it will...
             * take the value in the index x (which is one greater in each iteration)
             * and continue to "shift" it until the value is greater than the value of the contents in index y
             * thus moving it into its sorted place in the array
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


    private static void swap(ArrayList<University> universities, int x, int smallest) {
        University temp = universities.get(x);
        universities.set(x, universities.get(smallest));
        universities.set(smallest, temp);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

        int difference = e.getValue() - oldLocation;
        oldLocation = e.getValue();
        currentPage += difference;
        if (currentPage== 14) {
            currentPage = 0;
        }
        remove(uniPanel);
        uniPanel = createUniPanel(uniArrayCopy.get(currentPage).getName(), info);
        uniPanel.setBounds(800,0,500,500);
        picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/"+uniArrayCopy.get(currentPage).getName()+".jpg"));
        System.out.println(uniArrayCopy.get(currentPage).getName()+".jpg");

        combobox1.setSelectedItem(uniArrayCopy.get(currentPage).getName());
        combobox1.repaint();
        uniPanel.setVisible(true);

        add(uniPanel);

        repaint();
    }
}