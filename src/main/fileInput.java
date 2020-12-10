package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileInput {
    public static void main(String[] args) {
        String[] names = new String[14];
        String[] col1 = new String[14];
        Scanner input;



        try {
            input = new Scanner(new File("uni-app-finder/resources/dataTables/(CSV) Secondary School Averages 2016.csv"));
            input.useDelimiter(",");
            int index = 0;
            int arrayIndex = 0;
            int col1ArrayIndex = 0;
            while (input.hasNext()) {
                String value = input.next();
                if (index%9 == 0) {
                    names[arrayIndex] = value;
                    arrayIndex++;
                }
                if (index%9 == 1) {
                    col1[col1ArrayIndex] = value;
                    col1ArrayIndex++;
                }

                index++;
            }
            input.close();
            for (String name : names) {
                System.out.print(name + " ");
            }

            System.out.println("95+");
            for (String value : col1) {
                System.out.print(value + ", ");
            }
        } catch (FileNotFoundException e) { //Safety Check
            System.out.println("FILE ERROR");
        }


    }
}
