package main;

import objects.UniversitiesInformation;

public class MatchmakingAlgorithm {

	public static double[] score = new double[14];
	public static int greatestIndex = 0;
	public static int secondGreatestIndex = 1;

	public static void Matchmaker() {

		int[] dropDownValue = new int[6];
		int[] slidersValue = new int[6];

		for (int counter = 0; counter < dropDownValue.length; counter++) {
			dropDownValue[counter] = UniMatchmakerInfoEdit.dropDownLists[counter].getSelectedIndex();
			slidersValue[counter] = UniMatchmakerInfoEdit.sliders[counter].getValue();
		}

		double[] uniCutoff = new double[14];
		int[] ranking = new int[14];
		int[] tuition = new int[14];
		int[] uniSize = new int[14];
		double[] residence = new double[14];
		int[] classSize = new int[14];

		double personAverage = 0;

		for (int counter = 0; counter < 6; counter++)
			if (UniMatchmakerInfoEdit.gradeTextField[counter].getText().length() > 3)
				personAverage += Integer.parseInt(UniMatchmakerInfoEdit.gradeTextField[counter].getText());
			else
				System.out.print("Enter Courses and Grades!");

		for (int counter = 0; counter < 14; counter++) {

			uniCutoff[counter] = UniversitiesInformation.universities.get(counter).getCutoff();
			ranking[counter] = UniversitiesInformation.universities.get(counter).getRanking();
			tuition[counter] = UniversitiesInformation.universities.get(counter).getTuition();
			uniSize[counter] = UniversitiesInformation.universities.get(counter).getUniSize();
			residence[counter] = UniversitiesInformation.universities.get(counter).getResidenceCost();
			classSize[counter] = UniversitiesInformation.universities.get(counter).getClassSize();

			score[counter] = 0;

			if (personAverage >= uniCutoff[counter])
				score[counter] += 10;

			if (personAverage >= UniversitiesInformation.universities.get(counter).getAverage())
				score[counter] += 5;

			int factor = 0;

			if (dropDownValue[factor] == 0)
				if (ranking[counter] <= 5)
					score[counter] += slidersValue[factor];

			if (dropDownValue[factor] == 1)
				if (ranking[counter] <= 5)
					score[counter] += slidersValue[factor] * 2;
				else if (ranking[counter] <= 10)
					score[counter] += slidersValue[factor];

			factor++;

			if (dropDownValue[factor] == 0)
				if (tuition[counter] < 10000)
					score[counter] += slidersValue[factor];
				else if (tuition[counter] >= 10000 && tuition[counter] <= 15000)
					score[counter] += slidersValue[factor] / 2;

			if (dropDownValue[factor] == 1)
				if (tuition[counter] >= 10000 && tuition[counter] <= 15000)
					score[counter] += slidersValue[factor];
				else if (tuition[counter] < 10000)
					score[counter] += slidersValue[factor] * 2;

			if (dropDownValue[factor] == 2)
				if (tuition[counter] > 15000)
					score[counter] += slidersValue[factor];
				else if (tuition[counter] < 10000 || tuition[counter] > 15000)
					score[counter] += slidersValue[factor] / 2;

			factor++;

			if (dropDownValue[factor] == 0 && uniSize[counter] < 10000)
				score[counter] += slidersValue[factor];

			if (dropDownValue[factor] == 1 && uniSize[counter] >= 10000 && uniSize[counter] <= 50000)
				score[counter] += slidersValue[factor];

			if (uniSize[counter] > 50000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (dropDownValue[factor] == 0)
				if (residence[counter] < 10000)
					score[counter] += slidersValue[factor];

			if (dropDownValue[factor] == 1)
				if (residence[counter] >= 10000 && residence[counter] <= 12000)
					score[counter] += slidersValue[factor];
			if (residence[counter] < 10000)
				score[counter] += slidersValue[factor] * 2;

			if (dropDownValue[factor] == 2)
				if (residence[counter] > 12000)
					score[counter] += slidersValue[factor];
				else
					score[counter] += slidersValue[factor] * 2;

			factor++;

			if (classSize[counter] < 100 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] >= 100 && classSize[counter] <= 300 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] > 300 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			System.out.println(counter + " " + score[counter]);

		}

		double greatest = score[0];
		double secondGreatest = score[1];

		for (int counter = 0; counter < 13; counter++)
			if (greatest < score[counter + 1]) {
				secondGreatestIndex = greatestIndex;
				secondGreatest = greatest;
				greatestIndex = counter + 1;
				greatest = score[counter + 1];
			} else if (secondGreatest < score[counter + 1]) {
				secondGreatestIndex = counter + 1;
				secondGreatest = score[counter + 1];
			}

	}

}
