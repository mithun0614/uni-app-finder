package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversitiesInformation {

	public static ArrayList<University> universities = new ArrayList<>();
	private static University[] uni = new University[14];

	// Reads information from Universities.txt, and creates University objects for
	// each University.
	// Stores each instance in an ArrayList.

	public static void setUniversities() {

		Scanner input;

		try {

			input = new Scanner(new File("Universities.txt"));
			input.useDelimiter(",");

			int index = 0;

			while (input.hasNext()) {

				universities.add(new University((input.next().replaceAll("\n", "").replaceAll("\r", "")),
						input.nextDouble(), input.nextDouble(), input.nextInt(), input.nextInt(), input.nextDouble(),
						input.nextDouble()));

				index++;
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not Found :(");
		}
	}
}
