package guiClasses;

import main.UniversitiesInformation;
import main.University;

import javax.swing.*;
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
    private int oldLocation = 0;
    private JTextField keyword = new JTextField();
    private JButton searchButton = new JButton("Search");
    private JLabel searchLabel = new JLabel("Search");
    private JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL,0,1,0,14);
    private String[] sorting = new String[]{"Alpha: A-Z", "Alpha: Z-A", "Average: Low to High", "Average: High to Low"};
    private String info = "insert info about uni ~~this uni was founded in xxxx~~";
    private JPanel uniPanel;
    private ImageIcon[] icons = new ImageIcon[14];
    private boolean resetPage = false;
    private String[] names = new String[14];
    private ArrayList<University> customList = new ArrayList<>(0);
    private int maxIndex = 13;
    public AllPrograms() {

        uniArrayCopy = uniClass.getUniversities();
        for (University uni : uniClass.getUniversities()) {
            System.out.println(uni.getKeywords());
        }

        setSize(1152, 864);
        setLayout(null);
        uniPanel = createUniPanel(uniArrayCopy.get(0));
        uniPanel.setBounds(800, 0, 400, 300);
        add(uniPanel);
        uniPanel.setVisible(true);

        for (University uni : uniArrayCopy) {
            combobox1.addItem(uni.getName());
        }

        picture.setIcon(uniArrayCopy.get(0).getIcon());
        picture.setBounds(350,300,700,500);
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

        if (event.getSource() == combobox2) {


            if (combobox2.getSelectedIndex() == 0) {            // if its A-Z
                uniArrayCopy = uniClass.getUniversities();
                currentPage = 0;
                reversed = false;
            }
            else if (combobox2.getSelectedIndex() == 1) {                //if its Z-A
                uniArrayCopy = uniClass.getUniversities();
                reverse();
                currentPage = 0;
                reversed = true;
            }


            else if (combobox2.getSelectedIndex() == 2 || combobox2.getSelectedIndex() == 3) {                //Low to High, Average
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
            maxIndex = 13;

            resetPage = true;
            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(0));
            uniPanel.setBounds(800,0,400,300);
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
                comboboxIndex = maxIndex - comboboxIndex;
            }
            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(comboboxIndex));
            uniPanel.setBounds(800,0,500,500);


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
            if (currentPage== maxIndex) {
                currentPage = 0;
            }
            if (currentPage == -1) {
                currentPage = maxIndex;
            }
            System.out.println(currentPage);
            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(currentPage));
            uniPanel.setBounds(800, 0, 400, 300);
            uniPanel.setVisible(true);
            add(uniPanel);
            combobox1.setSelectedItem(uniClass.getUniversities().get(currentPage));
            picture.setIcon(uniArrayCopy.get(currentPage).getIcon());
            picture.setVisible(true);
            repaint();
        }

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
            uniPanel.setVisible(true);
            add(uniPanel);
            combobox1.setSelectedItem(uniClass.getUniversities().get(currentPage));
            picture.setIcon(uniArrayCopy.get(currentPage).getIcon());

            picture.setVisible(true);
            repaint();
        }

        if (event.getSource() == searchButton) {

            ArrayList<String> tempNames = new ArrayList<>();
            for (University uni : uniClass.getUniversities()){
                tempNames.add(uni.getName());
            }
            for (int x = 0; x < tempNames.size(); x++) {
                tempNames.set(x, tempNames.get(x).replace("University", ""));
                tempNames.set(x, tempNames.get(x).replace("of", ""));
                tempNames.set(x, tempNames.get(x).replace(" ", ""));
                tempNames.set(x, tempNames.get(x).toLowerCase());
            }
            currentPage = 0;

            String text = keyword.getText();
            for (int i = 0; i < tempNames.size(); i++) {
                System.out.println(text);
                if (text.equalsIgnoreCase(tempNames.get(i))){
                    customList.add(uniClass.getUniversities().get(i));
                }
            }
            for (University unis : uniClass.getUniversities()) {

                String keywords;
                keywords = unis.getKeywords();
                text = text.toLowerCase();


                if (keywords.contains(text))
                    for (University currentUni : customList) {
                    if (!unis.getName().equals(currentUni.getName()))
                        customList.add(unis);
                }
            }
            System.out.println("Size: " + customList.size());
            if (customList.size() == 0) {
                JLabel searchFailed = new JLabel("No Matches");
                searchFailed.setBounds(600,150,50,30);
                add(searchFailed);

            }
            else {
                currentPage = 0;
                uniArrayCopy = customList;
                maxIndex = customList.size();
                remove(uniPanel);
                uniPanel = createUniPanel(uniArrayCopy.get(currentPage));

                uniPanel.setBounds(800, 0, 400, 300);
                uniPanel.setVisible(true);
                add(uniPanel);
                picture.setIcon(uniArrayCopy.get(currentPage).getIcon());

                picture.setVisible(true);
                repaint();
            }
            customList.clear();

        }
    }

    public void reverse() {
        ArrayList<University> temp = new ArrayList<University>(14);

        for (int i = uniArrayCopy.size(); i > 0; i--) {
            temp.add(uniArrayCopy.get(i-1));
        }
        uniArrayCopy = temp;
    }


    public JPanel createUniPanel(University uni) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300, 500);
        JLabel nameLabel = new JLabel(uni.getName());
        JLabel infoLabel = new JLabel("<html>" + uni.getDescription() + "<html>");
        JLabel nationalRankLabel = new JLabel(String.valueOf(uni.getNationalRank()));


        nameLabel.setBounds(0, 0, 500, 80);
        nameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        nationalRankLabel.setBounds(0, 30, 500, 80);
        nationalRankLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        infoLabel.setBounds(0, 50, 300, 350);
        infoLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 12));
        panel.setOpaque(false);
        panel.add(nameLabel);
        panel.add(nationalRankLabel);
        panel.add(infoLabel);

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

    public void setIcons() {
        for (int i = 0; i < 14; i++) {
            names[i] =uniArrayCopy.get(i).getName();
        }
    }
}