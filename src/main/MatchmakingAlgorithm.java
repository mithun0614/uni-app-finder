package main;

public class MatchmakingAlgorithm {

	public static int[] score = new int[14];
	public static int greatest = score[0];
	public static int secondGreatest;

	public static void Matchmaker() {
		UniversitiesInformation uniClass = new UniversitiesInformation();
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
			personAverage += Integer.parseInt(UniMatchmakerInfoEdit.gradeTextField[counter].getText());

		for (int counter = 0; counter < 14; counter++) {

			uniCutoff[counter] = uniClass.getUniversities().get(counter).getCutoff();
			ranking[counter] = uniClass.getUniversities().get(counter).getNationalRank();
			tuition[counter] = uniClass.getUniversities().get(counter).getTuition();
			uniSize[counter] = uniClass.getUniversities().get(counter).getClassSize();
			residence[counter] = uniClass.getUniversities().get(counter).getTuition();
			classSize[counter] = uniClass.getUniversities().get(counter).getClassSize();

			score[counter] = 0;

			if (personAverage >= uniCutoff[counter])
				score[counter] += 5;

			int factor = 0;

			if (ranking[counter] <= 5 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (ranking[counter] <= 10 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];

			factor++;

			if (tuition[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (tuition[counter] >= 10000 && tuition[counter] <= 15000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (tuition[counter] > 15000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (uniSize[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (uniSize[counter] >= 10000 && uniSize[counter] <= 50000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (uniSize[counter] > 50000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (residence[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (residence[counter] >= 10000 && residence[counter] <= 12000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (residence[counter] > 12000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (classSize[counter] < 100 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] >= 100 && classSize[counter] <= 300 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] > 300 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

		}

		for (int counter = 0; counter < 13; counter++)
			if (greatest < score[counter + 1]) {
				secondGreatest = greatest;
				greatest = score[counter + 1];
			}

	}

}
