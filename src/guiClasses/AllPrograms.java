  
package guiClasses;

import main.UniversitiesInformation;
import main.University;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllPrograms extends JFrame implements ActionListener{

    private JLabel title = new JLabel("All Programs");
    private JButton nextBtn = new JButton();
    private JButton backBtn = new JButton();
    private JComboBox<String> combobox1 = new JComboBox<>();
    private JComboBox<String> combobox2 = new JComboBox<>();
    private JLabel sortBy = new JLabel("Sort by:");
    private JLabel picture = new JLabel();
    private ArrayList<University> uniArrayCopy;
    private int currentPage = 0;
    private boolean reversed = false;
    UniversitiesInformation uniClass = new UniversitiesInformation();
    private JTextField keyword = new JTextField();
    private JButton searchButton = new JButton("Search");
    private JLabel searchLabel = new JLabel("Search");
    private JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL,0,1,0,14);
    private String[] sorting = new String[]{"Alpha: A-Z", "Alpha: Z-A", "Average: Low to High", "Average: High to Low"};
    private JPanel uniPanel;
    private ArrayList<University> customList = new ArrayList<>(0);
    private int maxIndex = 14;
    private JLabel searchFailed = new JLabel();
    private boolean searchFailedTF;
    private JButton resetButton = new JButton();

    //constructor to setup the GUI screen
    public AllPrograms() {
        //Setting up the GUI panel
        uniArrayCopy = uniClass.getUniversities();
        setSize(1152, 864);
        setLayout(null);
        uniPanel = createUniPanel(uniArrayCopy.get(0));
        uniPanel.setBounds(800, 0, 400, 300);
        add(uniPanel);
        uniPanel.setVisible(true);

        //setting up combobox1, with the names of all the unis
        for (University uni : uniArrayCopy) {
            combobox1.addItem(uni.getName());
        }
        //setting up the picture
        picture.setIcon(uniArrayCopy.get(0).getIcon());
        picture.setBounds(350,300,700 ,500);
        add(picture);

        //setting up the combobox
        combobox1.setBounds(350, 50, 200, 40);
        combobox1.addActionListener(this);
        combobox1.setVisible(true);
        add(combobox1);

        //setting up the sorting combobox(adding the options)
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

        //setting up the buttons for forward and back
        nextBtn.setText("Next");
        nextBtn.setBounds(350, 200, 100, 50);
        nextBtn.addActionListener(this);
        nextBtn.setVisible(true);
        add(nextBtn);

        backBtn.setText("Back");
        backBtn.setBounds(450, 200, 100, 50);
        backBtn.addActionListener(this);
        backBtn.setVisible(true);
        add(backBtn);


        resetButton.setText("Reset");
        resetButton.setBounds(660 , 30, 80, 30);
        resetButton.addActionListener(this);
        resetButton.setVisible(true);
        add(resetButton);

        keyword.setBounds(600, 60, 150,40);
        keyword.addActionListener(this);
        add(keyword);

        searchLabel.setBounds(600,30,50,30);
        add(searchLabel);

        searchButton.setBounds(600,100,100,35);
        searchButton.addActionListener(this);
        add(searchButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Override Method
    @Override
    public void actionPerformed(ActionEvent event) {
        //COMBOBOX2 is the Sorting combobox, changes the uniarraycopy based on which sorting the user chose
        if (event.getSource() == combobox2) {

            if (combobox2.getSelectedIndex() == 0) {            // if its A-Z
                alphaSort();
                reversed = false;
            }
            else if (combobox2.getSelectedIndex() == 1) {                //if its Z-A
                alphaSort();
                reverse();
                reversed = true;
                currentPage = 0;
            }
            else if (combobox2.getSelectedIndex() == 2) {                //Low to High, Average
                insertionSort();
            }

            else if (combobox2.getSelectedIndex() == 3) {               //high to low, average
                    insertionSort();
                    reverse();
                    reversed = true;
                }
            currentPage = 0;
            remove(uniPanel);

            //creates a new unipanel(top right corner), and changes the picture
            uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
            uniPanel.setBounds(800,0,400,300);
            add(uniPanel);

            repaint();
        }

        //COMBOBOX1 is the combobox where you can individually select a university to look at
        if (event.getSource() == combobox1) {
            reversed = false;
            uniArrayCopy = new ArrayList<>(uniClass.getUniversities());
            alphaSort();
            int comboboxIndex = combobox1.getSelectedIndex();
            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(comboboxIndex));
            uniPanel.setBounds(800,0,500,500);
            scrollBar.setValue(comboboxIndex);
            currentPage = comboboxIndex;
            add(uniPanel);

            repaint();
        }

        //"next" button
        if (event.getSource() == nextBtn) {
            currentPage += 1;
            if (currentPage== maxIndex) {
                currentPage = 0;
            }
            if (currentPage == -1) {
                currentPage = maxIndex;
            }
            remove(uniPanel);

            uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
            uniPanel.setBounds(800, 0, 400, 300);
            add(uniPanel);
            combobox1.setSelectedItem(uniArrayCopy.get(currentPage));
            repaint();
        }
        //"back" button
        if (event.getSource() == backBtn) {

                currentPage -= 1;
            if (currentPage == -1) {
                currentPage = maxIndex-1;
            }
            if (currentPage== maxIndex) {
                currentPage = 0;
            }
            remove(uniPanel);

            uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
            uniPanel.setBounds(800, 0, 400, 300);
            add(uniPanel);
            combobox1.setSelectedItem(uniClass.getUniversities().get(currentPage));
            repaint();
        }
        if (event.getSource() == resetButton) {
            maxIndex = 14;
            uniArrayCopy = new ArrayList<>(uniClass.getUniversities());
            keyword.setText("");
            currentPage = 0;
            remove(uniPanel);

            //creates a new unipanel(top right corner), and changes the picture
            uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
            uniPanel.setBounds(800,0,400,300);
            add(uniPanel);

            repaint();
        }

        //button to start search
        if (event.getSource() == searchButton) {
            customList.clear();
            //tempnames is the names of the university without the "university of" and lowercase, ex. University of Toronto --> toronto
            ArrayList<String> tempNames = new ArrayList<>();
            for (University uni : uniClass.getUniversities()){
                tempNames.add(uni.getName());
            }
            for (int x = 0; x < tempNames.size(); x++) {
                tempNames.set(x, replaceFiller(tempNames.get(x)));
            }
            currentPage = 0;

            String text = keyword.getText();
            text = replaceFiller(text);

            //checks if what the user entered is the university name
            for (int i = 0; i < tempNames.size(); i++) {
                if (text.equalsIgnoreCase(tempNames.get(i))){
                    customList.add(uniClass.getUniversities().get(i));
                }
            }

            //checks if what the user entered falls into a list of keywords associated with the university
            for (University unis : uniClass.getUniversities()) {
                String keywords;
                keywords = unis.getKeywords();

                if (keywords.contains(text)){
                    if (customList.size() != 0) {
                        for (int i = 0; i < customList.size(); i++) {
                            if ((!unis.getName().equals(customList.get(i).getName()))) {
                                customList.add(unis);
                                break;
                            }
                        }
                    }
                    else {
                        customList.add(unis);
                    }
                }
            }
            //shows a no matches label if there are no matches
            if (customList.size() == 0){
                searchFailed.setText("No Matches");
                searchFailed.setBounds(600, 150, 100, 30);
                searchFailed.setVisible(true);
                add(searchFailed);
                searchFailedTF = true;
                uniArrayCopy = new ArrayList<>(uniClass.getUniversities());
            }
            else if (text.equalsIgnoreCase("")) {
                maxIndex = 14;
                uniArrayCopy = new ArrayList<>(uniClass.getUniversities());
            }

            //updates the uriarraycopy with the matching universities
            else {
                if (searchFailedTF)
                    remove(searchFailed);
                searchFailedTF = false;
                currentPage = 0;
                uniArrayCopy = new ArrayList<>(customList);
                maxIndex = customList.size();
                remove(uniPanel);
                uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
                uniPanel.setBounds(800, 0, 400, 300);
                combobox2.setSelectedIndex(0);
                add(uniPanel);

            }
            repaint();

        }
    }

    //reverses the uniarraycopy
    public void reverse() {
        ArrayList<University> temp = new ArrayList<>(14);

        for (int i = uniArrayCopy.size(); i > 0; i--) {
            temp.add(uniArrayCopy.get(i-1));
        }
        uniArrayCopy = temp;
    }

    //creates the text info and the pictures of each uni
    public JPanel createUniPanel(University uni) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300, 500);
        JLabel nameLabel = new JLabel(uni.getName());
        JLabel infoLabel = new JLabel("<html>" + uni.getDescription() + "<html>");
        JLabel nationalRankLabel = new JLabel("Rank: " + uni.getNationalRank());


        nameLabel.setBounds(0, 0, 500, 80);
        nameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        nationalRankLabel.setBounds(0, 30, 500, 80);
        nationalRankLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 14));
        infoLabel.setBounds(0, 50, 300, 350);
        infoLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 12));
        panel.setOpaque(false);
        panel.add(nameLabel);
        panel.add(nationalRankLabel);
        panel.add(infoLabel);
        picture.setIcon(uniArrayCopy.get(currentPage).getIcon());
        picture.setVisible(true);
        repaint();
        return panel;

    }

    public void insertionSort() {
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

    public void swap(ArrayList<University> universities, int x, int smallest) {
        University temp = universities.get(x);
        universities.set(x, universities.get(smallest));
        universities.set(smallest, temp);
    }

    public void alphaSort() {
        University temp;
        for (int i = 0; i < uniArrayCopy.size(); i++) {
            for (int j = i + 1; j < uniArrayCopy.size(); j++) {
                if (uniArrayCopy.get(i).getName().compareTo(uniArrayCopy.get(j).getName()) > 0) {
                    temp = uniArrayCopy.get(i);
                    uniArrayCopy.set(i, uniArrayCopy.get(j));
                    uniArrayCopy.set(j,temp);
                }
            }
        }
    }

    public String replaceFiller(String text) {
        text = text.toLowerCase();
        text = text.replace("university", "");
        text = text.replace("of", "");
        while (text.contains(" ")) {
            text = text.replace(" ", "");
        }
        return text;
    }
}